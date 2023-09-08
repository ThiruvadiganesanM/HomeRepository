package ActionClasses;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConnectionUtilityy.ConnectionUtility;
import DAO.CustomerDAOImpl;
import DTO.CustomerDTO;

public class MyRegisterAction extends MyAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Connection con;
		try {
			con = ConnectionUtility.getConnection();
		CustomerDAOImpl cdao=new CustomerDAOImpl(con);
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		double phone=Double.parseDouble( request.getParameter("phone"));
		CustomerDTO c=new CustomerDTO(userName,passWord,0,phone);
		int nori=cdao.createCustomer(c);
		if(nori==1) {
		return "login.success";
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
