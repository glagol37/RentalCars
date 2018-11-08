package net.rentalcars.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.entity.Order;
import net.rentalcars.entity.Score;
import net.rentalcars.util.RoutingUtils;


@WebServlet("/all-orders")
public class AllOrdersController extends AbstractController{

	
	private static final long serialVersionUID = 3277157723580489520L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> orders = getOrderService().listAllOrders();
		List<Score> score = getOrderService().listAllScore();
		req.setAttribute("score", score);
		req.setAttribute("orders", orders);
		RoutingUtils.forwardToPage("all-orders.jsp", req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String action = req.getParameter("action");
		if(action.equals("cancel")) {
			String description = req.getParameter("description");
			getOrderService().cancelOrder(id, description);
		} else if(action.equals("paid")) {
			int id_car = Integer.parseInt(req.getParameter("id_car"));
			getOrderService().confirmOrder(id, id_car);
		} else {
			
		}
		RoutingUtils.redirect("all-orders", req, resp);
	}
}
