package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.CustomerMasterDTO;

public class CustomerMasterDAOImpl implements CustomerMasterDAO {
	Connection con;
	ResultSet rs;

	public CustomerMasterDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public CustomerMasterDTO findByCustomerId(int customerId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("select * from customer_master where customer_id=? ");
		pstmt.setInt(1, customerId);
		rs = pstmt.executeQuery();
		CustomerMasterDTO cmd = new CustomerMasterDTO();
		if (rs.next()) {

			cmd.setCustomer_id(rs.getInt(1));
			cmd.setCustomer_name(rs.getString(2));
			cmd.setCustomer_address(rs.getString(3));
			cmd.setCustomer_telephone(rs.getLong(4));
		}
		con.close();
		rs.close();
		return cmd;

	}

	@Override
	public CustomerMasterDTO findByCustomerName(String customerName) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("select * from customer_master where customer_name=?");
		pstmt.setString(1, customerName);
		rs = pstmt.executeQuery();
		CustomerMasterDTO cmd = new CustomerMasterDTO();
		if (rs.next()) {
			cmd.setCustomer_id(rs.getInt(1));
			cmd.setCustomer_name(rs.getString(2));
			cmd.setCustomer_address(rs.getString(3));
			cmd.setCustomer_telephone(rs.getLong(4));
		}
		con.close();
		rs.close();
		return cmd;

	}

	@Override
	public List<CustomerMasterDTO> findAll() throws SQLException {

		PreparedStatement pstmt = con.prepareStatement("select * from customer_master");
		ResultSet rs = pstmt.executeQuery();
		ArrayList<CustomerMasterDTO> list = new ArrayList<>();
		while (rs.next()) {
			CustomerMasterDTO cmd = new CustomerMasterDTO();
			cmd.setCustomer_id(rs.getInt(1));
			cmd.setCustomer_name(rs.getString(2));
			cmd.setCustomer_address(rs.getString(3));
			cmd.setCustomer_telephone(rs.getLong(4));
			list.add(cmd);
		}
		con.close();
		rs.close();
		return list;
	}

	@Override
	public int addCustomerMaster(CustomerMasterDTO cmd) {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into customer_master values(?,?,?,?)");

			pstmt.setInt(1, cmd.getCustomer_id());
			pstmt.setString(2, cmd.getCustomer_name());
			pstmt.setString(3, cmd.getCustomer_address());
			pstmt.setLong(4, cmd.getCustomer_telephone());
			int nori = pstmt.executeUpdate();
			//con.close();rs.close();
			return nori;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateCustomerMaster(CustomerMasterDTO cmd) {
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"update customer_Master set customer_id=?, customer_name=?, customer_address=?, customer_telephone=?");
			pstmt.setInt(1, cmd.getCustomer_id());
			pstmt.setString(2, cmd.getCustomer_name());
			pstmt.setString(3, cmd.getCustomer_address());
			pstmt.setLong(4, cmd.getCustomer_telephone());
			
			int noru=pstmt.executeUpdate();
			con.close();rs.close();
			return noru;
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteCustomerMaster(int customerId) {
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from Customer_Master where customer_id=?");
			pstmt.setInt(1, customerId);
			int nord=pstmt.executeUpdate();
			con.close();rs.close();
			return nord;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
