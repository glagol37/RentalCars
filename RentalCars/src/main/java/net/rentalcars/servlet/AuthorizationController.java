package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.model.CurrentAccount;
import net.rentalcars.util.RoutingUtils;
import net.rentalcars.util.SessionUtils;
@WebServlet("/authorization")
public class AuthorizationController extends AbstractController{

	
	private static final long serialVersionUID = -4010048999598263220L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("number_one", getAccountService().generateRandomNumber());
		req.setAttribute("number_two", getAccountService().generateRandomNumber());
		RoutingUtils.forwardToPage("authorization.jsp", req, resp);
	} 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		CurrentAccount currentAccount = getAccountService().authorization(login, password);
		if (currentAccount != null) {
			SessionUtils.setCurrentAccount(req, currentAccount);
			RoutingUtils.redirect(req, resp);
		} else {
			RoutingUtils.forwardToPage("authorization.jsp", req, resp);
		}
	}
}