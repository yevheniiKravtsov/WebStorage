package storage.entity;

import java.io.Serializable;

public class Component implements Serializable {
	private int componentId;
	private String partNumber;
	//private int manufacturerId;
	//private String manufacturerName;
	//private int supplierId;
	//private String supplierName;
	private String componentDescription;
	private Manufacturer manufacturer;
	private Supplier supplier;
	
	public Component() {};
	
	//Constructor for getting data from database.
	public Component(int componentId, String partNumber, Manufacturer manufacturer, Supplier supplier, String componentDescription) {
		this.componentId=componentId;
		this.partNumber=partNumber;
		this.manufacturer=manufacturer;
		this.supplier=supplier;
		//this.manufacturerId=manufacturerId;
		//this.supplierId=supplierId;
		this.componentDescription=componentDescription;
		//this.manufacturerName=manufacturerName;
		//this.supplierName=supplierName;
	}
	//Constructor for adding data to database.
	public Component(String partNumber, Manufacturer manufacturer,
			Supplier supplier,  String componentDescription) {
		this.partNumber=partNumber;
		this.manufacturer=manufacturer;
		this.supplier=supplier;
		//this.manufacturerId=manufacturerId;
		//this.supplierId=supplierId;
		this.componentDescription=componentDescription;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public Supplier getSupplier() {
		return supplier;
	}
//	public void setSupplier(Supplier supplier) {
//		this.supplier = supplier;
//	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
//	public void setManufacturer(Manufacturer manufacturer) {
//		this.manufacturer = manufacturer;
//	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
//	public int getManufacturerId() {
//		return manufacturerId;
//	}
//	public void setManufacturerId(int manufacturerId) {
//		this.manufacturerId = manufacturerId;
//	}
//	public String getManufacturerName() {
//		return manufacturerName;
//	}
//	public void setManufacturerName(String manufacturerName) {
//		this.manufacturerName = manufacturerName;
//	}
//	public int getSupplierId() {
//		return supplierId;
//	}
//	public void setSupplierId(int supplierId) {
//		this.supplierId = supplierId;
//	}
//	public String getSupplierName() {
//		return supplierName;
//	}
//	public void setSupplierName(String supplierName) {
//		this.supplierName = supplierName;
//	}
	public String getComponentDescription() {
		return componentDescription;
	}
	public void setComponentDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentDescription == null) ? 0 : componentDescription.hashCode());
		result = prime * result + componentId;
//		result = prime * result + manufacturerId;
//		result = prime * result + ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
//		result = prime * result + supplierId;
//		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		return result;
	}
		
}
