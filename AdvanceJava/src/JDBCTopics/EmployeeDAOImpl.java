package JDBCTopics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAOImpl implements EmployeeDAO{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	 public EmployeeDAOImpl(Connection con) {
		this.con=con;
	}
	@Override
	public Emp findByID(int eno) throws Exception{
		ps=con.prepareStatement("select * from employee where eid=?");
		ps.setInt(1, eno);
		rs=ps.executeQuery();
		Emp emp=new Emp();
		if(rs.next()) {
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setEpass(rs.getString(3));
			emp.setEsal(rs.getInt(4));
			emp.setEcity(rs.getString(5));
			emp.setFlag(rs.getInt("flag"));
		}
		else {
			System.out.println("No Record found.....");
		}
		ps.close();rs.close();
		ConnectionUtility.closeConnection(null, null);
		return emp;
	}
	@Override
	public Emp findByEname(String ename)throws Exception {
		ps=con.prepareStatement("select * from employee where ename=?");
		ps.setString(1, ename);
		rs=ps.executeQuery();
		Emp emp=new Emp();
		if(rs.next()) {
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setEpass(rs.getString(3));
			emp.setEsal(rs.getInt(4));
			emp.setEcity(rs.getString(5));
			emp.setFlag(rs.getInt("flag"));
		}
		else {
			System.out.println("No Record found.....");
		}
		ps.close();rs.close();
		ConnectionUtility.closeConnection(null, null);
		return emp;
	}
	@Override
	public List<Emp> findAll()throws Exception {
		ps=con.prepareStatement("select * from employee");
		rs=ps.executeQuery();
		ArrayList<Emp> list=new ArrayList<Emp>();
		while(rs.next()) {
			Emp emp=new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setEpass(rs.getString(3));
			emp.setEsal(rs.getInt(4));
			emp.setEcity(rs.getString(5));
			emp.setFlag(rs.getInt("flag"));
			list.add(emp);
		}		
		ps.close();rs.close();
		ConnectionUtility.closeConnection(null, null);
		return list;
	}
	@Override
	public int createEmployee(Emp emp) {
		try {
			ps=con.prepareStatement("insert into employee values (?,?,?,?,?,?)");
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getEpass());
			ps.setInt(4, emp.getEsal());
			ps.setString(5, emp.getEcity());
			ps.setInt(6, emp.getFlag());
			int i=ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			try{ps.close();rs.close();}catch(Exception ee) {}
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
	}
	@Override
	public int updateEmployee(Emp emp) {
		try {
			ps=con.prepareStatement
("update employee set ename=?, epass=?,esal=?,ecity=?,flag=? where eid=?");			
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getEpass());
			ps.setInt(3, emp.getEsal());
			ps.setString(4, emp.getEcity());
			ps.setInt(5, emp.getFlag());
			ps.setInt(6, emp.getEid());
			int i=ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			try{ps.close();rs.close();}catch(Exception ee) {}
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
	}
	@Override
	public int deleteEmployeeByID(int eno) {
		try {
			ps=con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, eno);
			
			int i=ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			try{ps.close();rs.close();}catch(Exception ee) {}
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
	}
	@Override
	public int deleteEmployeeByName(String ename) {
		try {
			ps=con.prepareStatement("delete from employee where ename=?");
			ps.setString(1, ename);
			
			int i=ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			try{ps.close();rs.close();}catch(Exception ee) {}
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
	}
}
