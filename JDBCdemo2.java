package JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCdemo2 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection con=null;
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=ConnectionUtility.getConnection();
	PreparedStatement pstmt=con.prepareStatement("insert into students values(4,'malar','chemistry'");
	pstmt.execute();
	
	PreparedStatement pstm=con.prepareStatement("insert into students values(4,'hari','chemistry'");
	pstmt.execute();
	}catch(Exception e) {
	//	con.rollback();
		e.printStackTrace();
	}
}
}
