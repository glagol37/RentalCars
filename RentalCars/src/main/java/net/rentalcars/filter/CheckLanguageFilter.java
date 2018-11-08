package net.rentalcars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="checkLanguageFilter")
public class CheckLanguageFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String language = request.getParameter("language");
		if (language != null) {
			request.setAttribute("language", language);
		} else {
			request.setAttribute("language", "ru");
		}
		chain.doFilter(request, response);		
	}

	@Override
	public void destroy() {}


}
