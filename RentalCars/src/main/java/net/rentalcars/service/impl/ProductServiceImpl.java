package net.rentalcars.service.impl;

import java.math.BigDecimal;
import java.util.List;

import net.rentalcars.Constants;
import net.rentalcars.entity.Car;
import net.rentalcars.entity.Mark;
import net.rentalcars.jdbc.JDBCConnectionUtils;
import net.rentalcars.jdbc.JDBCUtils;
import net.rentalcars.jdbc.ResultSetHandler;
import net.rentalcars.jdbc.ResultSetHandlerFactory;
import net.rentalcars.jdbc.Transactional;
import net.rentalcars.service.ProductService;

@Transactional
public class ProductServiceImpl implements ProductService {
	private static final ResultSetHandler<List<Car>> productsResultSetHandler = ResultSetHandlerFactory
			.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
	private static final ResultSetHandler<List<Mark>> markResultSetHandler = ResultSetHandlerFactory
			.getListResultSetHandler(ResultSetHandlerFactory.MARK_RESULT_SET_HANDLER);

	public List<Car> listCarsByMark(String mark) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars where mark=?", productsResultSetHandler, mark);
	}

	public List<Car> listCarsByQuality(int mark) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars where quality=?", productsResultSetHandler, mark);
	}

	public List<Car> SortedListCars(String columnName) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars order by" + columnName, productsResultSetHandler);
	}

	public List<Car> listAllCars(String accountType) {
		if (accountType.equals(Constants.TYPE.get(1))) {
			return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars", productsResultSetHandler);
		} else {
			return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars where is_busy", productsResultSetHandler);
		}
	}

	public List<Car> listAllCars() {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from cars where is_busy", productsResultSetHandler);
	}

	public void addCar(String mark, String title, BigDecimal price, int quality) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "insert into cars values(nextval('cars_seq'),?,?,?,?)", mark, quality, price, title);
	}

	public void changeCar(String mark, String title, BigDecimal price, int quality, int id) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "update cars set mark=?, quality=?, price=?, title=? where id = ?", mark, quality, price,
				title, id);
	}

	@Override
	public void deleteCar(int id) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "delete from cars where id = ?", id);
	}

	public void returnCar(int idCar) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "update cars set is_busy=true where id=?", idCar);
	}

	public List<Mark> listAllMark() {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from mark", markResultSetHandler);
	}

	public void addMark(String name) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "insert into mark values(?)", name);
	}
}
