package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.Constants;
import net.rentalcars.util.RoutingUtils;
@WebServlet("/add-manager")
public class AddManagerController extends AbstractController {

	private static final long serialVersionUID = -6193812048555555826L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToPage("add-manager.jsp", req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		getAccountService().signIn(login, password, Constants.TYPE.get(1));
		RoutingUtils.redirect(req, resp);
	}
}
