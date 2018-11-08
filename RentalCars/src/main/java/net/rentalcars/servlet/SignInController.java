package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.Constants;
import net.rentalcars.model.CurrentAccount;
import net.rentalcars.util.RoutingUtils;
import net.rentalcars.util.SessionUtils;
@WebServlet("/sign-in")
public class SignInController extends AbstractController{


	private static final long serialVersionUID = -1032776875035945993L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("number_one", getAccountService().generateRandomNumber());
		req.setAttribute("number_two", getAccountService().generateRandomNumber());
		RoutingUtils.forwardToPage("sign-in.jsp", req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		CurrentAccount currentAccount = getAccountService().signIn(login, password, Constants.TYPE.get(0));
		if (currentAccount != null) {
			SessionUtils.setCurrentAccount(req, currentAccount);
			RoutingUtils.redirect(req, resp);
		} else {
			RoutingUtils.forwardToPage("sign-in.jsp", req, resp);
		}
	}
}
