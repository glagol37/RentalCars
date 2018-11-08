package net.rentalcars.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;
import net.rentalcars.util.SessionUtils;
@WebServlet("/order")
public class OrderController extends AbstractController{

	private static final long serialVersionUID = 4886223292339948645L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = SessionUtils.getCurrentAccount(req).getLogin();
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		int carId = Integer.parseInt(req.getParameter("id"));
		int days = Integer.parseInt(req.getParameter("days")); 
		String passportDetails = req.getParameter("passport_details");
		boolean isDriver = Boolean.parseBoolean(req.getParameter("is_driver"));
		getOrderService().createOrder(login, price, carId, passportDetails, isDriver, days);
		RoutingUtils.redirect(req, resp);
	}	
}
