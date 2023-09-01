package TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import DAO.CustomerMasterDAOImpl;
import DTO.CustomerMasterDTO;

public class TestCustomerMasterDAOImpl {
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
	}
	@Test
	public static void testAddCustomer() throws ClassNotFoundException, SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
		CustomerMasterDTO cmd=new CustomerMasterDTO();
		cmd.setCustomer_id(120);
		cmd.setCustomer_name("kaala");
		cmd.setCustomer_address("Mumbai");
		cmd.setCustomer_telephone(9988890400l);
		int nori=cmdi.addCustomerMaster(cmd);
		assertEquals(1,nori);
		System.out.println("no of rows inserted : "+nori);
		int nori1=cmdi.addCustomerMaster(cmd);
	}
	@Test
	public static void testFindByCustomerId() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
		CustomerMasterDTO c=cmdi.findByCustomerId(102);
		assertNotNull(c);
		System.out.println(c.getCustomer_name());
	}
	public static void testFindByCustomerName() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
		CustomerMasterDTO c=cmdi.findByCustomerName("Priya");
		System.out.println(c);
	}
	public static void testFindAll() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
		List<CustomerMasterDTO> list=cmdi.findAll();
		for(CustomerMasterDTO cmd:list) {
			System.out.println(cmd);
		}
	}
	@Test
	public static void testUpdateCustomerMaster() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
		CustomerMasterDTO cmd=new CustomerMasterDTO();
		cmd.setCustomer_id(108);
		cmd.setCustomer_name("prasanth");
		cmd.setCustomer_address("India");
		cmd.setCustomer_telephone(9039029010l);
		
		int noru=cmdi.updateCustomerMaster(cmd);
		assertEquals(1,noru);
	}
	@Test
	public static void testDeleteCustomerMaster() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
		CustomerMasterDAOImpl cmdi=new CustomerMasterDAOImpl(con);
		int nord=cmdi.deleteCustomerMaster(106);
		assertEquals(1,nord);
	}
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	testAddCustomer();
	testFindByCustomerId();
	testFindByCustomerName();
	testFindAll();
	testUpdateCustomerMaster();
	testDeleteCustomerMaster();
	
	
	
	
}

}
