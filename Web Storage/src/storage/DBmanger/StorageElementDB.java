package storage.DBmanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import storage.entity.Component;
import storage.entity.Manufacturer;
import storage.entity.Storage;
import storage.entity.StorageElement;
import storage.entity.Supplier;

public class StorageElementDB {
	
	private static String url = "jdbc:mysql://localhost:3306/storagedb?allowPublicKeyRetrieval=true&serverTimezone=Europe/Kiev&useSSL=false";
    private static String username = "yevheniiKravtsov";
    private static String password = "ab1234ab";

	public static ArrayList<StorageElement> select(){
		
		ArrayList<StorageElement> storageElementsList = new ArrayList<StorageElement>();
        try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
            	Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select storage_elements.*,components.*,manufacturers.*,suppliers.*,storages.*\r\n" + 
                		"FROM  ((((storagedb.storage_elements\r\n" + 
                		"left JOIN components ON storage_elements.component_id = components.component_id)\r\n" + 
                		"left JOIN storages ON storage_elements.storage_id = storages.storage_id)\r\n" + 
                		"left join manufacturers ON components.manufacturer_id=manufacturers.manufacturer_id)\r\n" + 
                		"left join suppliers on components.supplier_id=suppliers.supplier_id);");
                while(resultSet.next()){
                      
                	int idElement = resultSet.getInt(1);
                    Timestamp time = resultSet.getTimestamp(2);
                    int componentId = resultSet.getInt(3);
                    int numberOfComponents = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    int storageId = resultSet.getInt(6);
                    
                    componentId = resultSet.getInt(7);
                    String purtNumber = resultSet.getString(8);
                    int manufacturerId = resultSet.getInt(9);
                    int supplierId =resultSet.getInt(10);
                    String description = resultSet.getString(11);
                    
                    manufacturerId = resultSet.getInt(12);
                    String manufacturerName = resultSet.getString(13);
                    String manufacturerPhone = resultSet.getString(14);
                    
                    supplierId = resultSet.getInt(15);
                    String supplierName = resultSet.getString(16);
                    String supplierPhone=resultSet.getString(17);
                    
                    storageId = resultSet.getInt(18);
                    String storageAdres=resultSet.getString(19);
                    Storage storage = new Storage(storageId,storageAdres);
                    Supplier supplier = new Supplier(supplierId,supplierName, supplierPhone);
                    Manufacturer manufacturer = new Manufacturer(manufacturerId, manufacturerName, manufacturerPhone);
                    Component component= new Component(componentId, purtNumber,manufacturer, supplier, description);
                    StorageElement storageElement=new StorageElement(idElement,time,numberOfComponents,price,component,storage);
                    storageElementsList.add(storageElement);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return storageElementsList;
    }
	
	public static StorageElement selectOne(int id){
		
		StorageElement storageElement = null;
        try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql="Select storage_elements.*,components.*,manufacturers.*,suppliers.*,storages.*\r\n" + 
                		"FROM  ((((storagedb.storage_elements\r\n" + 
                		"left JOIN components ON storage_elements.component_id = components.component_id)\r\n" + 
                		"left JOIN storages ON storage_elements.storage_id = storages.storage_id)\r\n" + 
                		"left join manufacturers ON components.manufacturer_id=manufacturers.manufacturer_id)\r\n" + 
                		"left join suppliers on components.supplier_id=suppliers.supplier_id) where storage_element_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setInt(1,id);
            		ResultSet resultSet = preparedStatement.executeQuery();
            		if(resultSet.next()) {      
            			int idElement = resultSet.getInt(1);
                        Timestamp time = resultSet.getTimestamp(2);
                        int componentId = resultSet.getInt(3);
                        int numberOfComponents = resultSet.getInt(4);
                        double price = resultSet.getDouble(5);
                        int storageId = resultSet.getInt(6);
                        
                        componentId = resultSet.getInt(7);
                        String purtNumber = resultSet.getString(8);
                        int manufacturerId = resultSet.getInt(9);
                        int supplierId =resultSet.getInt(10);
                        String description = resultSet.getString(11);
                        
                        manufacturerId = resultSet.getInt(12);
                        String manufacturerName = resultSet.getString(13);
                        String manufacturerPhone = resultSet.getString(14);
                        
                        supplierId = resultSet.getInt(15);
                        String supplierName = resultSet.getString(16);
                        String supplierPhone=resultSet.getString(17);
                        
                        storageId = resultSet.getInt(18);
                        String storageAdres=resultSet.getString(19);
                        Storage storage = new Storage(storageId,storageAdres);
                        Supplier supplier = new Supplier(supplierId,supplierName, supplierPhone);
                        Manufacturer manufacturer = new Manufacturer(manufacturerId, manufacturerName, manufacturerPhone);
                        Component component= new Component(componentId, purtNumber,manufacturer, supplier, description);
                        storageElement=new StorageElement(idElement,time,numberOfComponents,price,component,storage);
            		}       
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return storageElement;
    }
	public static ArrayList<StorageElement> selectBetween(Timestamp timeFrom, Timestamp timeTo){
		
		ArrayList<StorageElement> storageElementsList = new ArrayList<StorageElement>();
        try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql="Select storage_elements.*,components.*,manufacturers.*,suppliers.*,storages.*\r\n" + 
                		"FROM  ((((storagedb.storage_elements\r\n" + 
                		"left JOIN components ON storage_elements.component_id = components.component_id)\r\n" + 
                		"left JOIN storages ON storage_elements.storage_id = storages.storage_id)\r\n" + 
                		"left join manufacturers ON components.manufacturer_id=manufacturers.manufacturer_id)\r\n" + 
                		"left join suppliers on components.supplier_id=suppliers.supplier_id) WHERE storage_element_time BETWEEN ? AND ?;";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setTimestamp(1,timeFrom);
            		preparedStatement.setTimestamp(2,timeTo);
            		ResultSet resultSet = preparedStatement.executeQuery();
            		while(resultSet.next()){      
            			int idElement = resultSet.getInt(1);
                        Timestamp time = resultSet.getTimestamp(2);
                        int componentId = resultSet.getInt(3);
                        int numberOfComponents = resultSet.getInt(4);
                        double price = resultSet.getDouble(5);
                        int storageId = resultSet.getInt(6);
                        
                        componentId = resultSet.getInt(7);
                        String purtNumber = resultSet.getString(8);
                        int manufacturerId = resultSet.getInt(9);
                        int supplierId =resultSet.getInt(10);
                        String description = resultSet.getString(11);
                        
                        manufacturerId = resultSet.getInt(12);
                        String manufacturerName = resultSet.getString(13);
                        String manufacturerPhone = resultSet.getString(14);
                        
                        supplierId = resultSet.getInt(15);
                        String supplierName = resultSet.getString(16);
                        String supplierPhone=resultSet.getString(17);
                        
                        storageId = resultSet.getInt(18);
                        String storageAdres=resultSet.getString(19);
                        Storage storage = new Storage(storageId,storageAdres);
                        Supplier supplier = new Supplier(supplierId,supplierName, supplierPhone);
                        Manufacturer manufacturer = new Manufacturer(manufacturerId, manufacturerName, manufacturerPhone);
                        Component component= new Component(componentId, purtNumber,manufacturer, supplier, description);
                        StorageElement storageElement=new StorageElement(idElement,time,numberOfComponents,price,component,storage);
                        storageElementsList.add(storageElement);
            		}       
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return storageElementsList;
    }
	public static int insert(StorageElement storageElement) {
	    try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Insert into storage_elements (storage_element_time, component_id,storage_element_number,"
                			+ "storage_element_price,storage_id) Values (?,?,?,?,?)";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setTimestamp(1, storageElement.getElementAddingTime());
            		preparedStatement.setInt(2,storageElement.getComponent().getComponentId());
            		preparedStatement.setInt(3,storageElement.getNumberOfComponents());
            		preparedStatement.setDouble(4,storageElement.getStorageElementPrice());
            		preparedStatement.setInt(5,storageElement.getStorage().getStorageId());
            		return  preparedStatement.executeUpdate();
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
	}
	public static int delete(int id){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Delete From storage_elements Where storage_element_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
       
            		preparedStatement.setInt(1,id);
            		
            		return  preparedStatement.executeUpdate();
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
 	}
	public static int update(StorageElement storageElement){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Update storage_elments Set storage_element_time=?, component_id=?, storage_element_number=?,"
                			+ "storage_element_price=?, storage_id=? where storege_element_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setTimestamp(1,storageElement.getElementAddingTime());
            		preparedStatement.setInt(2,storageElement.getComponent().getComponentId());
            		preparedStatement.setInt(3,storageElement.getNumberOfComponents());
            		preparedStatement.setDouble(4,storageElement.getStorageElementPrice());
            		preparedStatement.setInt(5,storageElement.getStorage().getStorageId());
            		preparedStatement.setInt(6,storageElement.getStorageElementId());
            		return  preparedStatement.executeUpdate();
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
 	}
		
}

