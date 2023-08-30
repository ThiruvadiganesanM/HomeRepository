package JDBCTopics;

import java.util.List;
public interface EmployeeDAO {
	public Emp findByID(int eno)throws Exception;
	public Emp findByEname(String ename)throws Exception;
	public List<Emp> findAll()throws Exception;
	public int createEmployee(Emp emp);
	public int updateEmployee(Emp emp);
	public int deleteEmployeeByID(int eno);
	public int deleteEmployeeByName(String ename);
}
