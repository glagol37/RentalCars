package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;

@WebServlet("/create-order")
public class CreateOrderController extends AbstractController {

	private static final long serialVersionUID = -5204180942210523049L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToPage("create-order.jsp", req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean isDriver = Boolean.parseBoolean(req.getParameter("is_driver"));
		int days = Integer.parseInt(req.getParameter("days"));
		if (days > 0) {
			req.setAttribute("price", getOrderService().calculatePrice(id, days, isDriver));
			RoutingUtils.forwardToPage("score.jsp", req, resp);
		} else {
			RoutingUtils.redirect(req, resp);
		}
	}
}