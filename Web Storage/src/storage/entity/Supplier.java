package storage.entity;

import java.io.Serializable;

public class Supplier implements Serializable{
	private int supplierId;
	private String supplierName;
	private String supplierPhone;
	
	public Supplier() {};
	
	public Supplier(String supplierName, String supplierPhone) {
		this.supplierName = supplierName;
		this.supplierPhone= supplierPhone;
	}
	
	public Supplier(int supplierId, String supplierName, String supplierPhone) {
		this.supplierId=supplierId;
		this.supplierName = supplierName;
		this.supplierPhone= supplierPhone;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + supplierId;
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		result = prime * result + ((supplierPhone == null) ? 0 : supplierPhone.hashCode());
		return result;
	}

}
