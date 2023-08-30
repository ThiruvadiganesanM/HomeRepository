package JDBCTopics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
	String sql="insert into employee values(1,'ganesh','ganesh',2000,'chennai',1)";
	Statement stmt=con.createStatement();
	int n=stmt.executeUpdate(sql);
	System.out.println(n);
}
}
