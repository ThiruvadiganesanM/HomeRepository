package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.CustomerMasterDTO;

public interface CustomerMasterDAO {
public CustomerMasterDTO findByCustomerId(int customerId) throws SQLException;
public CustomerMasterDTO findByCustomerName(String customerName) throws SQLException;
public List<CustomerMasterDTO> findAll()  throws SQLException;
public int addCustomerMaster(CustomerMasterDTO cmd);
public int updateCustomerMaster(CustomerMasterDTO cmd);
public int deleteCustomerMaster(int customerId);
}
