package net.rentalcars.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.Constants;
import net.rentalcars.entity.Car;
import net.rentalcars.util.RoutingUtils;
import net.rentalcars.util.SessionUtils;
@WebServlet("/products-by-mark")
public class FindCarsByMarkController extends AbstractController {

	private static final long serialVersionUID = 459127616949243042L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mark = req.getParameter("mark");
		List<Car> products = getProductService().listCarsByMark(mark);
		req.setAttribute("products", products);
		req.setAttribute("type", Constants.TYPE);
		req.setAttribute("isSession", SessionUtils.isCurrentAccountCreated(req));
		RoutingUtils.forwardToPage("products.jsp", req, resp);
	}
}
