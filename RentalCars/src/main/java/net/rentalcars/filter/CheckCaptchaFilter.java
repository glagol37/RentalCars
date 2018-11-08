package net.rentalcars.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.exception.PreconditionFailedException;

@WebFilter(filterName = "checkCaptchaFilter")
public class CheckCaptchaFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if (req.getMethod().equals("POST")) {
			int numberOne = Integer.parseInt(req.getParameter("number_one"));
			int numberTwo = Integer.parseInt(req.getParameter("number_two"));
			int result = Integer.parseInt(req.getParameter("result"));
			if (numberOne + numberTwo == result) {
				chain.doFilter(req, resp);
			} else {
				throw new PreconditionFailedException("Captcha check failed");
			}
		} else {
			chain.doFilter(req, resp);
		}
	}
}
