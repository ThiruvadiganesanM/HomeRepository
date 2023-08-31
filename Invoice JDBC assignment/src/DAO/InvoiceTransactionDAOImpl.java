package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.InvoiceTransactionDTO;

public class InvoiceTransactionDAOImpl implements InvoiceTransactionDAO{
	Connection con;
	ResultSet rs;
	
	public InvoiceTransactionDAOImpl(Connection con) {
		this.con=con;
	}
	@Override
	public InvoiceTransactionDTO findInvoiceTransactionByInvoiceId(int invoice_id) throws SQLException {
		PreparedStatement pstmt=con.prepareStatement("select * from Invoice_transaction where invoice_id=?");
		pstmt.setInt(1, invoice_id);
		rs=pstmt.executeQuery();
		InvoiceTransactionDTO itd=new InvoiceTransactionDTO();
		if(rs.next()) {
			itd.setInvoice_id(rs.getInt(1));
			itd.setItem_id(rs.getInt(2));
			itd.setQuantity(rs.getInt(3));
		}
		con.close();rs.close();
		return itd;
	}

	@Override
	public InvoiceTransactionDTO findInvoiceTransactionByItemId(int item_id) throws SQLException {
		PreparedStatement pstmt=con.prepareStatement("select * from Invoice_transaction where item_id=?");
		pstmt.setInt(1, item_id);
		rs=pstmt.executeQuery();
		InvoiceTransactionDTO itd=new InvoiceTransactionDTO();
		if(rs.next()) {
			itd.setInvoice_id(rs.getInt(1));
			itd.setItem_id(rs.getInt(2));
			itd.setQuantity(rs.getInt(3));
		}
		con.close();rs.close();
		return itd;
	}

	@Override
	public List<InvoiceTransactionDTO> findAll() {
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from Invoice_transaction");
			rs=pstmt.executeQuery();
			ArrayList<InvoiceTransactionDTO> list=new ArrayList<>();
			while(rs.next()) {
				InvoiceTransactionDTO itd=new InvoiceTransactionDTO();
				itd.setInvoice_id(rs.getInt(1));
				itd.setItem_id(rs.getInt(2));
				itd.setQuantity(rs.getInt(3));
				list.add(itd);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addInvoiceTransaction(InvoiceTransactionDTO itd) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Invoice_transaction values(?,?,?)");
			pstmt.setInt(1, itd.getInvoice_id());
			pstmt.setInt(2, itd.getItem_id());
			pstmt.setInt(3, itd.getQuantity());
			int nori=pstmt.executeUpdate();
			con.close();rs.close();
			return nori;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int updateInvoiceTransaction(InvoiceTransactionDTO itd) {
		try {
			PreparedStatement pstmt=con.prepareStatement("update Invoice_Transaction set invoice_id=?, item_id=?,quantity=?");
			pstmt.setInt(1, itd.getInvoice_id());
			pstmt.setInt(2,itd.getItem_id() );
			pstmt.setInt(3, itd.getQuantity());
			int noru=pstmt.executeUpdate();
			con.close();rs.close();
			return noru;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	
	}

	@Override
	public int deleteInvoiceTransaction(int invoice_id) {
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from invoice_transaction where invoice_id=?");
			pstmt.setInt(1, invoice_id);
			int nord=pstmt.executeUpdate();
			con.close();rs.close();
			return nord;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
