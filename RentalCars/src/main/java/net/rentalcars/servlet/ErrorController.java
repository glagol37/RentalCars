package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;
@WebServlet("/error")
public class ErrorController extends AbstractController{

	private static final long serialVersionUID = -5265449604644929879L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("statusCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		RoutingUtils.forwardToPage("error.jsp", req, resp);
	}
}
