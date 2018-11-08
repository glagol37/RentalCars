package net.rentalcars.jdbc;

import java.sql.Connection;

public final class JDBCConnectionUtils {
	private JDBCConnectionUtils() {
	}

	private static final ThreadLocal<Connection> connections = new ThreadLocal<Connection>();

	public static Connection getCurrentConnection() {
		Connection c = connections.get();
		return c;
	}

	static void setCurrentConnection(Connection c) {
		connections.set(c);
	}

	static void removeCurrentConnection() {
		connections.remove();
	}
}
