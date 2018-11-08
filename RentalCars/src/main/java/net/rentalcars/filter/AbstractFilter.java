package net.rentalcars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AbstractFilter implements Filter{
	protected final Logger LOGGER = LogManager.getLogger(getClass());
	public final void doFilter(ServletRequest request, ServletResponse respsponse, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		respsponse.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) respsponse;
		doFilter(req, resp, chain);
	}
	public abstract void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException;
	public void destroy() {

	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}
