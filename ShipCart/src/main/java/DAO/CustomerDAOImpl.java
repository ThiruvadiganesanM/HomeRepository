package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DTO.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public CustomerDAOImpl(Connection con) {
		this.con=con;
	}
	@Override
	public int createCustomer(CustomerDTO cdto) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?)");
			pstmt.setString(1,cdto.getUserName());
			pstmt.setString(2, cdto.getPassword());
			pstmt.setInt(3, cdto.getFlag());
			pstmt.setDouble(4, cdto.getPhone());
			int nori=pstmt.executeUpdate();
			return nori;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateCustomer(CustomerDTO cdto) {
		
		return 0;
	}

	@Override
	public CustomerDTO findCustomer(long phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteCustomer(long phone) {
		// TODO Auto-generated method stub
		return 0;
	}

}
