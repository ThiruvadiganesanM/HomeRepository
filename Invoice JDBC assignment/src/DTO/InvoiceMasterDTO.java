package DTO;

import java.sql.Date;


public class InvoiceMasterDTO {
@Override
	public String toString() {
		return "InvoiceMasterDTO [invoice_id=" 	+ invoice_id + ", invoice_date=" + invoice_date + ", discount="
				+ discount + "]";
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + invoice_id;
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
	InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
	if (invoice_id != other.invoice_id)
		return false;
	return true;
}

private int invoice_id;
private Date invoice_date;
private int discount;
public int getInvoice_id() {
	return invoice_id;
}
public void setInvoice_id(int invoice_id) {
	this.invoice_id = invoice_id;
}
public Date getInvoice_date() {
	return invoice_date;
}
public void setInvoice_date(Date invoice_date) {
	this.invoice_date = invoice_date;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
}
