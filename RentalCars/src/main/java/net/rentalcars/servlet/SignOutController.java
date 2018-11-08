package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;
@WebServlet("/sign-out")
public class SignOutController extends AbstractController{

	private static final long serialVersionUID = -276084581393843705L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		RoutingUtils.redirect("authorization.jsp",req, resp);
	}
}
