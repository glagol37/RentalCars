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

@WebServlet("/products")
public class AllProductsController extends AbstractController {
	
	
	private static final long serialVersionUID = 4723430225802640047L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Car> products = null;
		if(SessionUtils.isCurrentAccountCreated(req)) {
			products = getProductService().listAllCars(SessionUtils.getCurrentAccount(req).getType());
		} else {
			products = getProductService().listAllCars();
		}
		req.setAttribute("products", products);
		req.setAttribute("type", Constants.TYPE);
		req.setAttribute("isSession", SessionUtils.isCurrentAccountCreated(req));
		RoutingUtils.forwardToPage("products.jsp", req, resp);
	}
}