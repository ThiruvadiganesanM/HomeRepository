package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	private ConnectionUtility() {

	}

	static ThreadLocal<Connection> tlocal = new ThreadLocal<>();
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection con = tlocal.get();
		if (con == null) {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro", "root", "Uiq@#123");
			tlocal.set(con);
			return con;
		} else {
			return con;
		}
	}

	public static synchronized void closeConnection() {
		Connection con = tlocal.get();
		if (con == null) {
			System.out.println("no connection is there to close");
		} else {
			try {
				con.close();
				tlocal.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
