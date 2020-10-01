package storage.entity;

import java.io.Serializable;

public class Manufacturer implements Serializable {
	private int manufacturerId;
	private String manufacturerName;
	private String manufacturerPhone;
	
	public Manufacturer() {};
	
	public Manufacturer(String manufacturerName, String manufacturerPhone) {
		this.manufacturerName=manufacturerName;
		this.manufacturerPhone=manufacturerPhone;
	}
	public Manufacturer(int manufacturerId, String manufacturerName, String manufacturerPhone) {
		this.manufacturerId = manufacturerId;
		this.manufacturerName=manufacturerName;
		this.manufacturerPhone=manufacturerPhone;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerPhone() {
		return manufacturerPhone;
	}

	public void setManufacturerPhone(String manufacturerPhone) {
		this.manufacturerPhone = manufacturerPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + manufacturerId;
		result = prime * result + ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		result = prime * result + ((manufacturerPhone == null) ? 0 : manufacturerPhone.hashCode());
		return result;
	}		
	
	
}
