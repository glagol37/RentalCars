package net.rentalcars.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import net.rentalcars.exception.AbstractApplicationException;
import net.rentalcars.exception.InternalServerErrorException;
import net.rentalcars.exception.PreconditionFailedException;
import net.rentalcars.exception.ResourceNotFoundException;
import net.rentalcars.exception.ValidationException;
import net.rentalcars.util.RoutingUtils;


@WebFilter(filterName = "errorHandlerFilter")
public class ErrorHandlerFilter extends AbstractFilter {
	private static final String INTERNAL_ERROR = "Internal error";

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(req, new ThrowExceptionInsteadOfSendErrorResponse(resp));
		} catch (Throwable th) {
			String requestUrl = req.getRequestURI();
			LOGGER.error("Request " + requestUrl + " failed: " + th.getMessage(), th);
			handleException(requestUrl, th, req, resp);
		}
	}

	private int getStatusCode(Throwable th) {
		if (th instanceof AbstractApplicationException) {
			return (((AbstractApplicationException) th).getCode());
		} else {
			return (HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	private void handleException(String requestUrl, Throwable th, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int statusCode = getStatusCode(th);
		resp.setStatus(statusCode);
		req.setAttribute("statusCode", statusCode);
		RoutingUtils.forwardToPage("error.jsp", req, resp);
	}

	private static class ThrowExceptionInsteadOfSendErrorResponse extends HttpServletResponseWrapper {
		public ThrowExceptionInsteadOfSendErrorResponse(HttpServletResponse response) {
			super(response);
		}

		@Override
		public void sendError(int sc) throws IOException {
			sendError(sc, INTERNAL_ERROR);
		}

		@Override
		public void sendError(int sc, String msg) throws IOException {
			switch (sc) {
				case 404: {
					throw new ResourceNotFoundException(msg);
				}
				case 400: {
					throw new ValidationException(msg);
				}
				case 412: {
					throw new PreconditionFailedException(msg);
				}
				default:
					throw new InternalServerErrorException(msg);
			}
		}
	}

}
