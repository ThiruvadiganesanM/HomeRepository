package ConnectionUtilityy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	private static ThreadLocal<Connection> r = new ThreadLocal<Connection>();

	public ConnectionUtility() {

	}

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	synchronized public static Connection getConnection() throws SQLException {
		Connection re = r.get();
		if (re == null) {
			String url = "jdbc:mysql://localhost:3306/vastpro";
			String username = "root";
			String password = "Uiq@#123";
			re = DriverManager.getConnection(url, username, password);
			r.set(re);
			return re;
		} else {
			return re;
		}
	}

	synchronized public static void closeConnection() throws SQLException {
		Connection re = r.get();
		if (re == null) {
			System.out.println("There is no Connection");
		} else {
			re.close();
			r.remove();
		}

	}

}