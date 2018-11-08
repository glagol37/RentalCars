package net.rentalcars.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.rentalcars.service.AccountService;
import net.rentalcars.service.OrderService;
import net.rentalcars.service.ProductService;
import net.rentalcars.service.impl.ServiceManagerImpl;

public abstract class AbstractController extends HttpServlet {

	private static final long serialVersionUID = -5515771939902554064L;

	private ProductService productService;
	private OrderService orderService;
	private AccountService accountService;

	@Override
	public final void init() throws ServletException {
		productService = ServiceManagerImpl.getInstance(getServletContext()).getProductService();
		orderService = ServiceManagerImpl.getInstance(getServletContext()).getOrdertService();
		accountService = ServiceManagerImpl.getInstance(getServletContext()).getAccountService();
	}

	public final ProductService getProductService() {
		return productService;
	}

	public final OrderService getOrderService() {
		return orderService;
	}
	
	public final AccountService getAccountService() {
		return accountService;
	}

}
