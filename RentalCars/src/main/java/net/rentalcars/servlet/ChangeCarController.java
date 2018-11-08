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
@WebServlet("/change-car")
public class ChangeCarController extends AbstractController {


	private static final long serialVersionUID = 7362381894441966401L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Mark> marks = getProductService().listAllMark();
		req.setAttribute("marks", marks);
		RoutingUtils.forwardToPage("change_car.jsp", req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		if(price.compareTo(BigDecimal.ZERO) != 1) {
			throw new ValidationException("Incorrect price specified");
		}
		int id = Integer.parseInt(req.getParameter("id"));
		String mark = req.getParameter("mark");
		int quality = Integer.parseInt(req.getParameter("quality"));
		String title = req.getParameter("title");
		getProductService().changeCar(mark, title, price, quality, id);
		RoutingUtils.redirect( req, resp);
	}
}
