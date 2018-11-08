package net.rentalcars.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.rentalcars.service.ServiceManager;
import net.rentalcars.service.impl.ServiceManagerImpl;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private ServiceManager serviceManager;
	private static final Logger LOGGER = LogManager.getLogger(ApplicationListener.class);
	public void contextInitialized(ServletContextEvent sce) {
		try {
			serviceManager = ServiceManagerImpl.getInstance(sce.getServletContext());			
		} catch (RuntimeException e) {
			LOGGER.error("Web application 'RentalCars' init failed: "+e.getMessage(), e);
			throw e;
		}
		LOGGER.info("Web application 'RentalCars' initialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		serviceManager.close();
		LOGGER.info("Web application 'RentalCars' destroyed");
	}
}
