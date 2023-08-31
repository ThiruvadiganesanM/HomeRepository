package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.InvoiceTransactionDTO;

public interface InvoiceTransactionDAO {
	public InvoiceTransactionDTO findInvoiceTransactionByInvoiceId(int invoice_id) throws SQLException;
	public InvoiceTransactionDTO findInvoiceTransactionByItemId(int item_id) throws SQLException;
	public List<InvoiceTransactionDTO> findAll();
	public int addInvoiceTransaction(InvoiceTransactionDTO itd);
	public int updateInvoiceTransaction(InvoiceTransactionDTO itd);
	public int deleteInvoiceTransaction(int invoice_id);
}
