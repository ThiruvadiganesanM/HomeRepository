package JDBCDemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCdemo1 {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=ConnectionUtility.getConnection();
//	Statement stmt=con.createStatement();
//	int n=stmt.executeUpdate("delete from students where sid=3");
//	System.out.println(n);
	
	
	CallableStatement cs=con.prepareCall("{call myproc3(?,?)}");
	cs.setInt(1,3);
	cs.registerOutParameter(2, Types.VARCHAR);
	ResultSet rs=cs.executeQuery();
	if(rs.next()) {
		System.out.println(rs.getString(2));
		
	}
}
}
