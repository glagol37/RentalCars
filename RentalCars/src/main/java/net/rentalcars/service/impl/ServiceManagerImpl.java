package net.rentalcars.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.rentalcars.jdbc.JDBCTransactionalServiceFactory;
import net.rentalcars.listener.ApplicationListener;
import net.rentalcars.service.AccountService;
import net.rentalcars.service.OrderService;
import net.rentalcars.service.ProductService;
import net.rentalcars.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager {
	private static final Logger LOGGER = LogManager.getLogger(ApplicationListener.class);
	private final OrderService ordertService;
	private final ProductService productService;
	private final AccountService accountService;
	private final BasicDataSource dataSource;

	private ServiceManagerImpl(ServletContext context) {
		dataSource = createDataSource();
		productService = (ProductService) JDBCTransactionalServiceFactory.createTransactionalService(dataSource,
				new ProductServiceImpl());
		ordertService = (OrderService) JDBCTransactionalServiceFactory.createTransactionalService(dataSource,
				new OrderServiceImpl());
		accountService = (AccountService) JDBCTransactionalServiceFactory.createTransactionalService(dataSource,
				new AccountServiceImpl());
	}

	private BasicDataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost/car");
		dataSource.setUsername("car_rental");
		dataSource.setPassword("372543");
		dataSource.setInitialSize(3);
		dataSource.setMaxTotal(20);
		return dataSource;
	}

	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManagerImpl) context.getAttribute("SERVICE_MANAGER");
		if (instance == null) {
			instance = new ServiceManagerImpl(context);
			context.setAttribute("SERVICE_MANAGER", instance);
		}
		return instance;
	}

	public void close() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			LOGGER.error("Close datasource failed: "+e.getMessage(), e);
		}
	}

	public ProductService getProductService() {
		return productService;
	}

	public OrderService getOrdertService() {
		return ordertService;
	}

	public AccountService getAccountService() {
		return accountService;
	}
}