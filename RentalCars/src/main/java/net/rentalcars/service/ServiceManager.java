package net.rentalcars.service;

public interface ServiceManager {

	ProductService getProductService();
	OrderService getOrdertService();
	AccountService getAccountService();
	void close();
}
