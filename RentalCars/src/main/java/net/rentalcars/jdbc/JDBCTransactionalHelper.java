package net.rentalcars.jdbc;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

class JDBCTransactionalHelper {
	private final Object realService;
	private final DataSource dataSource;

	JDBCTransactionalHelper(Object realService, DataSource dataSource) {
		this.realService = realService;
		this.dataSource = dataSource;
	}

	Object invokeTransactional(Transactional transactional, Method method, Object[] args) throws Exception {
		try (Connection c = dataSource.getConnection()) {
			JDBCConnectionUtils.setCurrentConnection(c);
			return method.invoke(realService, args);
		} catch (SQLException e) {
			// TODO
			return null;
		} finally {
			JDBCConnectionUtils.removeCurrentConnection();
		}
	}

}
