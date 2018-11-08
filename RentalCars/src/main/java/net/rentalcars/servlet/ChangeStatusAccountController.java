package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;
@WebServlet("/change-status-account")
public class ChangeStatusAccountController extends AbstractController{

	private static final long serialVersionUID = -7849015302299540792L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isBlock = Boolean.parseBoolean(req.getParameter("is_block"));
		String login = req.getParameter("login");
		getAccountService().changeStatusAccount(isBlock, login);
		RoutingUtils.redirect(req, resp);
	}
}
