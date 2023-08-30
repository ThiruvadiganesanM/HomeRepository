package JDBCTopics;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
public class DTODemo {
	public static void main(String[] args)throws Exception {
		Connection con=ConnectionUtility.getConnection();
		
		PreparedStatement p=con.prepareStatement("select * from employee");
		
		ResultSet rs=p.executeQuery();
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
		
		
	}
}
//DTO - Data Transfer Object
class Emp implements Serializable{
	private int eid,esal,flag;
	private String ename,epass,ecity;
	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}
	/**
	 * @return the esal
	 */
	public int getEsal() {
		return esal;
	}
	/**
	 * @param esal the esal to set
	 */
	public void setEsal(int esal) {
		this.esal = esal;
	}
	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the epass
	 */
	public String getEpass() {
		return epass;
	}
	/**
	 * @param epass the epass to set
	 */
	public void setEpass(String epass) {
		this.epass = epass;
	}
	/**
	 * @return the ecity
	 */
	public String getEcity() {
		return ecity;
	}
	/**
	 * @param ecity the ecity to set
	 */
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(eid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return eid == other.eid;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", esal=" + esal + ", flag=" + flag + ", ename=" + ename + ", epass=" + epass
				+ ", ecity=" + ecity + "]";
	}
	
	
}
