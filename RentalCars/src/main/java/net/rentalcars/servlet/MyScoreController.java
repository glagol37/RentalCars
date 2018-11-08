package net.rentalcars.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.Constants;
import net.rentalcars.entity.Order;
import net.rentalcars.entity.Score;
import net.rentalcars.util.RoutingUtils;
import net.rentalcars.util.SessionUtils;

@WebServlet("/my-score")
public class MyScoreController extends AbstractController {

	private static final long serialVersionUID = -5800719822860965213L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			String login = SessionUtils.getCurrentAccount(req).getLogin();
			List<Order> orders = getOrderService().getOrdersByLogin(login);
			List<Score> score = getOrderService().getScoreByLogin(login);
			req.setAttribute("score", score);
			req.setAttribute("orders", orders);
			RoutingUtils.forwardToPage("my-score.jsp", req, resp);
		} else {
			RoutingUtils.redirect(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			if (SessionUtils.getCurrentAccount(req).getType().equals(Constants.TYPE.get(1))) {
				int id = Integer.parseInt(req.getParameter("id"));
				int id_order = Integer.parseInt(req.getParameter("id_order"));
				getOrderService().deleteOrder(id_order);
				getOrderService().deleteScore(id);
				RoutingUtils.redirect("all-orders", req, resp);
			} else {
				doGet(req, resp);
			}
		} else {
			doGet(req, resp);
		}
	}
}
