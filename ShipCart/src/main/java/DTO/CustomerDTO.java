package DTO;

import java.util.Objects;

public class CustomerDTO {
	String userName;
	String password;
	int flag;
	double phone;
	public CustomerDTO(String userName, String password, int flag, double phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.flag = flag;
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFlag() {
		return flag;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [userName=" + userName + ", password=" + password + ", flag=" + flag + ", phone=" + phone+ "]";
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
