package DTO;

public class CustomerMasterDTO {
private int customer_id;
private String customer_name;
private String customer_address;
private long customer_telephone;

public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public String getCustomer_address() {
	return customer_address;
}
public void setCustomer_address(String customer_address) {
	this.customer_address = customer_address;
}
public long getCustomer_telephone() {
	return customer_telephone;
}
public void setCustomer_telephone(long customer_telephone) {
	this.customer_telephone = customer_telephone;
}

}
