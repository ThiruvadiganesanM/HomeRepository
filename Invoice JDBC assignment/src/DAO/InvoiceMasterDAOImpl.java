package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.InvoiceMasterDTO;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	public InvoiceMasterDAOImpl(Connection con) {
		this.con=con;
	}
	@Override
	public InvoiceMasterDTO findByInvoiceId(int invoiceId) throws SQLException {
		pstmt=con.prepareStatement("select * from invoice_master where invoice_id=?");
		pstmt.setInt(1, invoiceId);
		rs=pstmt.executeQuery();
		InvoiceMasterDTO imd=new InvoiceMasterDTO();
		if(rs.next()) {
			imd.setInvoice_id(rs.getInt(1));
			imd.setInvoice_date(rs.getDate(2));
			imd.setDiscount(rs.getInt(3));
		}
		con.close();rs.close();
		return imd;
	}

	@Override
	public List<InvoiceMasterDTO> findAll() throws SQLException {
		ArrayList<InvoiceMasterDTO> list=new ArrayList<InvoiceMasterDTO>();
		pstmt=con.prepareStatement("select * from invoice_master;");
		rs=pstmt.executeQuery();
		while(rs.next()) {
			InvoiceMasterDTO imd=new InvoiceMasterDTO();
			imd.setInvoice_id(rs.getInt(1));
			imd.setInvoice_date(rs.getDate(2));
			imd.setDiscount(rs.getInt(3));
			list.add(imd);
		}
		return list;
	}

	@Override
	public int addInVoiceMaster(InvoiceMasterDTO imd)  {
		try {
			pstmt=con.prepareStatement("insert into invoice_master values(?,?,?)");
			pstmt.setInt(1, imd.getInvoice_id());
			pstmt.setDate(2, imd.getInvoice_date());
			pstmt.setInt(3, imd.getDiscount());
			
			int nori=pstmt.executeUpdate();
			return nori;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	
		
		
	}

	@Override
	public int updateInVoiceMaster(InvoiceMasterDTO ivm) {
		try {
			pstmt=con.prepareStatement("update invoice_master set invoice_id=? , invoice_date=?, discount=?");
			pstmt.setInt(1, ivm.getInvoice_id());
			pstmt.setDate(2, ivm.getInvoice_date());
			pstmt.setInt(3, ivm.getDiscount());
			int noru=pstmt.executeUpdate();
			return noru;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int deleteInvoiceMasterById(int invoiceId) {
		try {
			pstmt=con.prepareStatement("delete from invoice_master where invoice_id=?");
			pstmt.setInt(1, invoiceId);
			int noru=pstmt.executeUpdate();
			return noru;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}

}
