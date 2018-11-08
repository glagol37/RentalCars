package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rentalcars.util.RoutingUtils;
@WebServlet("/add-mark")
public class AddMarkController extends AbstractController{

	private static final long serialVersionUID = 4988088195060433325L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("mark");
		getProductService().addMark(name);
		RoutingUtils.redirect("add-car", req, resp);
	}
}
