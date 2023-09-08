package DAO;

import java.util.List;

import DTO.CustomerDTO;

public interface CustomerDAO {
	public int createCustomer(CustomerDTO cdto);
	public int updateCustomer(CustomerDTO cdto);
	public CustomerDTO findCustomer(long phone);
	public List<CustomerDTO> findAll();
	public int deleteCustomer(long phone);
	
}
