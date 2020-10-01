package storage.DBmanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import storage.entity.Manufacturer;
import storage.entity.Supplier;

public class ManufacturerDB {
	private static String url = "jdbc:mysql://localhost:3306/storagedb?allowPublicKeyRetrieval=true&serverTimezone=Europe/Kiev&useSSL=false";
    private static String username = "yevheniiKravtsov";
    private static String password = "ab1234ab";

	public static ArrayList<Manufacturer> select(){
		
		ArrayList<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
        try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
            	Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from manufacturers");
                while(resultSet.next()){
                      
                	int id = resultSet.getInt(1);
                	String manufacturerName = resultSet.getString(2);
                	String manufacturerPhone = resultSet.getString(3);
                    Manufacturer manufacturer = new Manufacturer(id, manufacturerName, manufacturerPhone);
                    manufacturerList.add(manufacturer);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return manufacturerList;
    }
	public static Manufacturer selectOne(int id){
		Manufacturer manufacturer = null;
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "SELECT * From manufacturers where manufacturer_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setInt(1,id);
            		ResultSet resultSet = preparedStatement.executeQuery();
            		if(resultSet.next()) {
            			int manufacturerId=resultSet.getInt(1);
            			String name=resultSet.getString(2);
            			String phone = resultSet.getString(3);
            			manufacturer = new Manufacturer(manufacturerId, name, phone);
            		}
            		
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return manufacturer;
	}
	public static int insert(Manufacturer manufacturer){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Insert into manufacturers (manufacturer_name, manufacturer_phone) Values (?,?)";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setString(1,manufacturer.getManufacturerName());
            		preparedStatement.setString(2,manufacturer.getManufacturerPhone());
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
                String sql= "Delete From manufacturers Where manufacturer_id=?";
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
	public static int update(Manufacturer manufacturer){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Update manufacturers Set manufacturer_name=?, manufacturer_phone=? Where manufacturer_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setString(1,manufacturer.getManufacturerName());
            		preparedStatement.setString(2,manufacturer.getManufacturerPhone());
            		preparedStatement.setInt(3,manufacturer.getManufacturerId());
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
