package storage.DBmanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import storage.entity.Component;
import storage.entity.Manufacturer;
import storage.entity.Supplier;

public class ComponentDB {

	private static String url = "jdbc:mysql://localhost:3306/storagedb?allowPublicKeyRetrieval=true&serverTimezone=Europe/Kiev&useSSL=false";
    private static String username = "yevheniiKravtsov";
    private static String password = "ab1234ab";

	public static ArrayList<Component> select(){
		
		ArrayList<Component> componentList = new ArrayList<Component>();
        try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
            	Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select components.*,manufacturers.*, suppliers.*\r\n" + 
                		"from ((components\r\n" + 
                		"left join manufacturers ON components.manufacturer_id = manufacturers.manufacturer_id)\r\n" + 
                		"LEFT JOIN suppliers ON components.supplier_id = suppliers.supplier_id);");
                while(resultSet.next()){
                	int id = resultSet.getInt(1);
                    String purtNumber = resultSet.getString(2);
                    int manufacturerId = resultSet.getInt(3);
                    int supplierId =resultSet.getInt(4);
                    String description = resultSet.getString(5);
                    
                    manufacturerId = resultSet.getInt(6);
                    String manufacturerName = resultSet.getString(7);
                    String manufacturerPhone = resultSet.getString(8);
                    
                    supplierId = resultSet.getInt(9);
                    String supplierName = resultSet.getString(10);
                    String supplierPhone=resultSet.getString(11);
                    Manufacturer manufacturer = new Manufacturer(manufacturerId, manufacturerName, manufacturerPhone);
                    Supplier supplier = new Supplier(supplierId, supplierName, supplierPhone);
                    Component component = new Component(id, purtNumber, manufacturer, supplier, description);
                    componentList.add(component);
                    
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return componentList;
    }
	public static int delete(int id){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Delete From components Where component_id=?";
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
	public static Component selectOne(int id){
		Component component = null;
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Select components.*,manufacturers.*, suppliers.*"
                		+ " from ((components left join manufacturers ON components.manufacturer_id = manufacturers.manufacturer_id)"
                		+ " LEFT JOIN suppliers ON components.supplier_id = suppliers.supplier_id) where component_id=?;\r\n" ;
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setInt(1,id);
            		ResultSet resultSet = preparedStatement.executeQuery();
            		if(resultSet.next()) {
            			int componentId = resultSet.getInt(1);
                        String purtNumber = resultSet.getString(2);
                        int manufacturerId = resultSet.getInt(3);
                        int supplierId =resultSet.getInt(4);
                        String description = resultSet.getString(5);

                        manufacturerId = resultSet.getInt(6);
                        String manufacturerName = resultSet.getString(7);
                        String manufacturerPhone = resultSet.getString(8);
                        
                        supplierId = resultSet.getInt(9);
                        String supplierName = resultSet.getString(10);
                        String supplierPhone=resultSet.getString(11);
                        Manufacturer manufacturer = new Manufacturer(manufacturerId, manufacturerName, manufacturerPhone);
                        Supplier supplier = new Supplier(supplierId, supplierName, supplierPhone);
                        component = new Component(componentId, purtNumber, manufacturer, supplier, description);
            		}
            		
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return component;
	}
	public static int insert(Component component){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Insert into components (part_number, manufacturer_id, supplier_id, component_description) Values (?,?,?,?)";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setString(1,component.getPartNumber());
            		preparedStatement.setInt(2,component.getManufacturer().getManufacturerId());
            		preparedStatement.setInt(3,component.getSupplier().getSupplierId());
            		preparedStatement.setString(4,component.getComponentDescription());
            		return  preparedStatement.executeUpdate();
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
 	}
	public static int update(Component component){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Update components Set part_number=?, manufacturer_id=?, supplier_id=?,component_description=? Where component_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setString(1,component.getPartNumber());
            		preparedStatement.setInt(2,component.getManufacturer().getManufacturerId());
            		preparedStatement.setInt(3,component.getSupplier().getSupplierId());
            		preparedStatement.setString(4,component.getComponentDescription());
            		preparedStatement.setInt(5,component.getComponentId());
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
