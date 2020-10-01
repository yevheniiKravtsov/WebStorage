package storage.entity;

import java.io.Serializable;

public class Storage implements Serializable {
	private int storageId;
	private String storageAdres;
	
	public Storage(){};
	
	public Storage(String storageAdres) {
		this.storageAdres=storageAdres;
	}
	public Storage(int storageId, String storageAdres) {
		this.storageId=storageId;
		this.storageAdres=storageAdres;
	}

	public int getStorageId() {
		return storageId;
	}

	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}

	public String getStorageAdres() {
		return storageAdres;
	}

	public void setStorageAdres(String storageAdres) {
		this.storageAdres = storageAdres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storageAdres == null) ? 0 : storageAdres.hashCode());
		result = prime * result + storageId;
		return result;
	}

}
