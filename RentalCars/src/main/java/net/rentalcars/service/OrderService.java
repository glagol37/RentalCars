package net.rentalcars.service;

import java.math.BigDecimal;
import java.util.List;

import net.rentalcars.entity.Order;
import net.rentalcars.entity.Score;

public interface OrderService {
	BigDecimal calculatePrice(int id, int days, boolean isDriver);

	void createOrder(String login, BigDecimal price, int carId, String passportDetails, boolean isDriver, int days);
	
	List<Order> listAllOrders();
	
	 void cancelOrder(int id, String description);
	
	 void confirmOrder(int id , int id_car);
	 
	 void deleteOrder(int id);
	 
	 void createScore(int id, BigDecimal price, String login);
	 
	 List<Order> getOrdersByLogin(String login);
	 
	 List<Score> getScoreByLogin(String login);
	 
	 List<Score> listAllScore();
	 
	 void deleteScore (int id);
}
