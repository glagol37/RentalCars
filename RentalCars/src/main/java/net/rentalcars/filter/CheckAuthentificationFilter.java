package net.rentalcars.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;
import net.rentalcars.util.SessionUtils;


@WebFilter(filterName = "CheckAuthentificationFilter")
public class CheckAuthentificationFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			chain.doFilter(req, resp);
		} else {
			RoutingUtils.forwardToPage("authorization.jsp", req, resp);
		}
	}
}