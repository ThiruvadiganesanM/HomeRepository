package JDBCTopics;

import java.sql.Connection;
import java.util.List;
public class TestEmployeeDAO {
	public static void main(String[] args) throws Exception{
		
		EmployeeDAO edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		
		Emp emp=edao.findByID(1);
		
		System.out.println(emp);
		
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		emp=edao.findByEname("ramu");
		
		System.out.println(emp);
		
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		List<Emp> list =edao.findAll();
		
		System.out.println(list);
		
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		Emp emp3=new Emp();
		emp3.setEid(3);
		emp3.setEname("rajesh");
		emp3.setEpass("jackal");
		emp3.setEsal(20000);
		emp3.setEcity("delhi");
		emp3.setFlag(0);
		int i=edao.createEmployee(emp3);
		
		System.out.println(i==1?"record inserted..":"not inserted...");
		
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		emp=edao.findByEname("rajesh");
		emp.setEsal(50000);
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		edao.updateEmployee(emp);
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		emp=edao.findByEname("rajesh");
		System.out.println("Salary..:"+emp.getEsal());
		
		edao=new EmployeeDAOImpl(ConnectionUtility.getConnection());
		edao.deleteEmployeeByName("rajesh");
	}
}









