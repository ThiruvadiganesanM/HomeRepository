package DTO;

import java.io.FileInputStream;

public class ItemMasterDTO {
	@Override
	public String toString() {
		return "ItemMasterDTO [item_id=" + item_id + ", item_name=" + item_name + ", unit=" + unit + ", price=" + price
				+ ", image=" + image + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item_id;
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
		ItemMasterDTO other = (ItemMasterDTO) obj;
		if (item_id != other.item_id)
			return false;
		return true;
	}
	private int item_id;
	private String item_name;
	private String unit;
	private float price;
	private FileInputStream image;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public FileInputStream getImage() {
		return image;
	}
	public void setImage(FileInputStream image) {
		this.image = image;
	}
	
}
