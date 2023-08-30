package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.InvoiceMasterDTO;

public interface InvoiceMasterDAO {
	public InvoiceMasterDTO findByInvoiceId(int invoiceId) throws SQLException;
	public List<InvoiceMasterDTO> findAll() throws SQLException;
	public int addInVoiceMaster(InvoiceMasterDTO ivm);
	public int updateInVoiceMaster(InvoiceMasterDTO ivm);
	public int deleteInvoiceMasterById(int invoiceId);
	
}
