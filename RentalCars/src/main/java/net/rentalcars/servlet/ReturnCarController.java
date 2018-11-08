package net.rentalcars.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/return-car")
public class ReturnCarController extends AbstractController{

	
	private static final long serialVersionUID = -2372327232587127722L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int idCar = Integer.parseInt(req.getParameter("id_car"));
		boolean isScore = Boolean.parseBoolean(req.getParameter("score"));
		if(isScore) {
			String login = req.getParameter("login");
			BigDecimal price = new BigDecimal(req.getParameter("price"));
			if(price.compareTo(BigDecimal.ZERO) != 1) {
				
			} 
			getOrderService().createScore(idCar, price, login);
		} else {
			getOrderService().deleteOrder(id);
		}
		getProductService().returnCar(idCar);
	}
}
