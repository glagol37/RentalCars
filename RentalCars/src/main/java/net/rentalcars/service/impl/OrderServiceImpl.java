package net.rentalcars.service.impl;

import java.math.BigDecimal;
import java.util.List;

import net.rentalcars.Constants;
import net.rentalcars.entity.Car;
import net.rentalcars.entity.Order;
import net.rentalcars.entity.Score;
import net.rentalcars.jdbc.JDBCConnectionUtils;
import net.rentalcars.jdbc.JDBCUtils;
import net.rentalcars.jdbc.ResultSetHandler;
import net.rentalcars.jdbc.ResultSetHandlerFactory;
import net.rentalcars.jdbc.Transactional;
import net.rentalcars.service.OrderService;

@Transactional
public class OrderServiceImpl implements OrderService {

	private static final ResultSetHandler<Car> productsResultSetHandler = ResultSetHandlerFactory
			.getSingleResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
	private static final ResultSetHandler<List<Order>> ordersResultSetHandler = ResultSetHandlerFactory
			.getListResultSetHandler(ResultSetHandlerFactory.ORDER_RESULT_SET_HANDLER);
	private static final ResultSetHandler<List<Score>> scoreResultSetHandler = ResultSetHandlerFactory
			.getListResultSetHandler(ResultSetHandlerFactory.SCORE_RESULT_SET_HANDLER);

	public BigDecimal calculatePrice(int id, int days, boolean isDriver) {
		BigDecimal price = selectPriceById(id);
		if (isDriver) {
			price = price.add(Constants.PRICE_FOR_DRIVER);
		}
		price = price.multiply(new BigDecimal(days));
		return price;
	}

	private BigDecimal selectPriceById(int id) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars where id=?", productsResultSetHandler, id).getPrice();
	}

	@Override
	public void createOrder(String login, BigDecimal price, int carId, String passportDetails, boolean isDriver,
			int days) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(),
				"insert into orders (id, id_cars, login_account, price, passport_details, is_driver, days) values(nextval('orders_seq'),?,?,?,?,?,?)",
				carId, login, price, passportDetails, isDriver, days);
	}

	@Override
	public List<Order> listAllOrders() {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select o.*, c.mark, c.title from orders o, cars c where c.id = o.id_cars",
				ordersResultSetHandler);
	}

	public void confirmOrder(int id, int id_car) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "update cars set is_busy=false where id=?", id_car);
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "update orders set paid=true where id=?", id);
	}

	public void cancelOrder(int id, String description) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "update orders set cancel=true, description=? where id=?", description, id);
	}

	public void deleteOrder(int id) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "delete from orders where id = ?", id);
	}

	public void createScore(int id, BigDecimal price, String login) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "insert into score values(nextval('score_seq'), ?, ?, ?)", login, price, id);
	}

	public List<Order> getOrdersByLogin(String login) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(),
				"select o.*, c.mark, c.title from orders o, cars c where c.id = o.id_cars and login_account=?",
				ordersResultSetHandler, login);
	}

	public List<Score> getScoreByLogin(String login) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from score where login_account=?", scoreResultSetHandler, login);
	}

	public List<Score> listAllScore() {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from score", scoreResultSetHandler);
	}

	public void deleteScore(int id) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "delete from score where id = ?", id);
	}
}
