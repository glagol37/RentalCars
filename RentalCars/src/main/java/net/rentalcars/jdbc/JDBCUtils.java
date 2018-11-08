package net.rentalcars.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.rentalcars.exception.InternalServerErrorException;

public final class JDBCUtils {

	public static <T> T select(Connection c, String sql, ResultSetHandler<T> resultSetHandler, Object... parameters) {
		try(PreparedStatement ps = c.prepareStatement(sql)) {
			populatePreparedStatement(ps, parameters);
			ResultSet rs = ps.executeQuery();
			return resultSetHandler.handle(rs);
		} catch (SQLException e) {
			throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
		}
	}

	
	public static void insert(Connection c, String sql, Object... parameters) {
		try(PreparedStatement ps = c.prepareStatement(sql)) {
			populatePreparedStatement(ps, parameters);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
		}
	}

	private static void populatePreparedStatement(PreparedStatement ps, Object... parameters) throws SQLException {
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
		}
	}
	
	private JDBCUtils() {
	}
}