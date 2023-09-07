package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	Connection con; 
	ResultSet rs;
	PreparedStatement pstmt;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		 pstmt=con.prepareStatement("select * from customer");
		 rs=pstmt.executeQuery();
		 int noru=0;
		 while(rs.next()) {
			if (uname.equals(rs.getString("username"))){
				if(upass.equals(rs.getString("password"))) {
					if(rs.getInt("flag")==0) {
						pstmt=con.prepareStatement("update customer set flag=1");
						 noru=pstmt.executeUpdate();
						if(noru==1) {
							return "login.success";
						}
					}
				}
			}
		 }
		 if(noru==0) {
			return "login.register";
		 }
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		return "login.register";
	}
	return upass;
	
//	if(uname.equals("mathew")) {
//		return "login.success";
//	}
//	else{
//		return "login.register";
//	}
	
}
}
