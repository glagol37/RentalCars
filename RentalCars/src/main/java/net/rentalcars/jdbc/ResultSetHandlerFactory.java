package net.rentalcars.jdbc;

import java.util.ArrayList;
import java.util.List;

import net.rentalcars.entity.Account;
import net.rentalcars.entity.Car;
import net.rentalcars.entity.Mark;
import net.rentalcars.entity.Order;
import net.rentalcars.entity.Score;
import net.rentalcars.model.CurrentAccount;

public final class ResultSetHandlerFactory {

	public static ResultSetHandler<Car> PRODUCT_RESULT_SET_HANDLER = rs -> {
		Car c = new Car();
		c.setId(rs.getInt("id"));
		c.setMark(rs.getString("mark"));
		c.setPrice(rs.getBigDecimal("price"));
		c.setQuality(rs.getShort("quality"));
		c.setTitle(rs.getString("title"));
		c.setBusy(rs.getBoolean("is_busy"));
		return c;
	};
	
	public static ResultSetHandler<Mark> MARK_RESULT_SET_HANDLER = rs -> {
		Mark m = new Mark();
		m.setName(rs.getString("name"));
		return m;
	};
	
	public static ResultSetHandler<Score> SCORE_RESULT_SET_HANDLER = rs -> {
		Score s = new Score();
		s.setId(rs.getInt("id"));
		s.setAccountLogin(rs.getString("login_account"));
		s.setPrice(rs.getBigDecimal("price"));
		s.setOrderId(rs.getInt("id_order"));
		return s;
	};
	
	
	
	public static ResultSetHandler<Order> ORDER_RESULT_SET_HANDLER = rs -> {
		Order o = new Order();
		o.setId(rs.getLong("id"));
		o.setCarsId(rs.getInt("id_cars"));
		o.setAccountLogin(rs.getString("login_account"));
		o.setPrice(rs.getBigDecimal("price"));
		o.setPassportDetails(rs.getString("passport_details"));
		o.setPaid(rs.getBoolean("paid"));
		o.setCancel(rs.getBoolean("cancel"));
		o.setDescription(rs.getString("description"));
		o.setDriver(rs.getBoolean("is_driver"));
		o.setDays(rs.getShort("days"));
		Car c = new Car();
		c.setMark(rs.getString("mark"));
		c.setTitle(rs.getString("title"));
		o.setCar(c);
		return o;
	};

	public static ResultSetHandler<CurrentAccount> AUTHENTIFICATE = rs -> {
		Account a = new Account();
		a.setId(rs.getInt("id"));
		a.setLogin(rs.getString("login"));
		a.setBlocking(rs.getBoolean("blocked"));
		a.setType(rs.getString("type"));
		return a;
	};

	public final static <T> ResultSetHandler<T> getSingleResultSetHandler(
			final ResultSetHandler<T> oneRowResultSetHandler) {
		return rs -> {
			if (rs.next()) {
				return oneRowResultSetHandler.handle(rs);
			} else {
				return null;
			}
		};
	}

	public final static <T> ResultSetHandler<List<T>> getListResultSetHandler(
			final ResultSetHandler<T> oneRowResultSetHandler) {
		return rs -> {
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				list.add(oneRowResultSetHandler.handle(rs));
			}
			return list;
		};
	}

	private ResultSetHandlerFactory() {
	}

}
