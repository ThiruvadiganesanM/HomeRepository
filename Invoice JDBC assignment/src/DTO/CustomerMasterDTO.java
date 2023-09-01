package DTO;

public class CustomerMasterDTO {
	private int customer_id;
	private String customer_name;
	private String customer_address;
	private long customer_telephone;
@Override
	public String toString() {
		return "CustomerMasterDTO [customer_id=" + customer_id + ", customer_name=" + customer_name
				+ ", customer_address=" + customer_address + ", customer_telephone=" + customer_telephone + "]";
	}
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMasterDTO other = (CustomerMasterDTO) obj;
		if (customer_id != other.customer_id)
			return false;
		return true;
	}


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
