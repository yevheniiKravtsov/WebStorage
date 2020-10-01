package storage.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class StorageElement implements Serializable{
	private int storageElementId;
	private Timestamp elementAddingTime;
//	private int componentId;
//	private String componentPartNumber;
	private int numberOfComponents;
	private double storageElementPrice;
//	private int storageId;
//	private String storageAdres;
	private Component component;
	private Storage storage;
	
	public StorageElement(){};
	
	//Constructor for getting data from database.
	public StorageElement(int storageElementId, Timestamp elementAddingTime, int numberOfComponents, double storageElementPrice,
							Component component, Storage storage) {
		this.storageElementId=storageElementId;
		this.elementAddingTime=elementAddingTime;
		this.numberOfComponents=numberOfComponents;
		this.storageElementPrice=storageElementPrice;
		this.component=component;
		this.storage=storage;
	}
	
	//Constructor for adding data to database.
	public StorageElement(Timestamp elementAddingTime, int numberOfComponents,
							double storageElementPrice, Component component, Storage storage) {
		this.elementAddingTime=elementAddingTime;
		this.component=component;
		this.numberOfComponents=numberOfComponents;
		this.storageElementPrice=storageElementPrice;
		this.storage=storage;
	}

	public int getStorageElementId() {
		return storageElementId;
	}

	public void setStorageElementId(int storageElementId) {
		this.storageElementId = storageElementId;
	}

	public Timestamp getElementAddingTime() {
		return elementAddingTime;
	}

	public void setElementAddingTime(Timestamp elementAddingTime) {
		this.elementAddingTime = elementAddingTime;
	}
	public Component getComponent() {
		return component;
	}
	public Storage getStorage() {
		return storage;
	}

//	public int getComponentId() {
//		return componentId;
//	}
//
//	public void setComponentId(int componentId) {
//		this.componentId = componentId;
//	}
//
//	public String getComponentPartNumber() {
//		return componentPartNumber;
//	}
//
//	public void setComponentPartNumber(String componentPartNumber) {
//		this.componentPartNumber = componentPartNumber;
//	}

	public int getNumberOfComponents() {
		return numberOfComponents;
	}

	public void setNumberOfComponents(int numberOfComponents) {
		this.numberOfComponents = numberOfComponents;
	}

	public double getStorageElementPrice() {
		return storageElementPrice;
	}

	public void setStorageElementPrice(double storageElementPrice) {
		this.storageElementPrice = storageElementPrice;
	}

//	public int getStorageId() {
//		return storageId;
//	}
//
//	public void setStorageId(int storageId) {
//		this.storageId = storageId;
//	}
//
//	public String getStorageAdres() {
//		return storageAdres;
//	}
//
//	public void setStorageAdres(String storageAdres) {
//		this.storageAdres = storageAdres;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + componentId;
//		result = prime * result + ((componentPartNumber == null) ? 0 : componentPartNumber.hashCode());
		result = prime * result + ((elementAddingTime == null) ? 0 : elementAddingTime.hashCode());
		result = prime * result + numberOfComponents;
//		result = prime * result + ((storageAdres == null) ? 0 : storageAdres.hashCode());
		result = prime * result + storageElementId;
		long temp;
		temp = Double.doubleToLongBits(storageElementPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + storageId;
		return result;
	}
	
}
