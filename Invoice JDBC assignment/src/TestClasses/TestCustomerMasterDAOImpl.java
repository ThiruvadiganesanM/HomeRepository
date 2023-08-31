package TestClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.CustomerMasterDAOImpl;
import DTO.CustomerMasterDTO;

public class TestCustomerMasterDAOImpl {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
	CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
	
	CustomerMasterDTO cmd=new CustomerMasterDTO();
	cmd.setCustomer_id(102);
	cmd.setCustomer_name("Muthu");
	cmd.setCustomer_address("Dubai");
	cmd.setCustomer_telephone(9988778800l);
	cmdi.addCustomerMaster(cmd);
	
	CustomerMasterDTO c=cmdi.findByCustomerId(100);
	 System.out.println(c.getCustomer_name());
}

}
