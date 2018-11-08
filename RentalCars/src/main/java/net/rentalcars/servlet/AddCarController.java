package net.rentalcars.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.entity.Mark;
import net.rentalcars.exception.ValidationException;
import net.rentalcars.util.RoutingUtils;
@WebServlet("/add-car")
public class AddCarController extends AbstractController{

	private static final long serialVersionUID = -1225603003939712547L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Mark> marks = getProductService().listAllMark();
		req.setAttribute("marks", marks);
		RoutingUtils.forwardToPage("add-car.jsp", req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		if(price.compareTo(BigDecimal.ZERO) != 1) {
			throw new ValidationException("Incorrect price specified");
		}
		int quality = Integer.parseInt(req.getParameter("quality"));
		String mark = req.getParameter("mark");
		String title = req.getParameter("title");
		getProductService().addCar(mark, title, price, quality);
		RoutingUtils.redirect(req, resp);
	}
}
