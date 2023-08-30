package DTO;

import java.sql.Date;


public class InvoiceMasterDTO {
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
