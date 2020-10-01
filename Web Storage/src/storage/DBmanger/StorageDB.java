package storage.DBmanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import storage.entity.Storage;


public class StorageDB {

	private static String url = "jdbc:mysql://localhost:3306/storagedb?allowPublicKeyRetrieval=true&serverTimezone=Europe/Kiev&useSSL=false";
    private static String username = "yevheniiKravtsov";
    private static String password = "ab1234ab";

	public static ArrayList<Storage> select(){	
		ArrayList<Storage> storageList = new ArrayList<Storage>();
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){      
            	Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from storages");
                while(resultSet.next()){
                	int id = resultSet.getInt(1);
                    String storageAdres = resultSet.getString(2);
                    Storage storage=new Storage(id, storageAdres);
                    storageList.add(storage);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return storageList;
    }
	public static int insert(Storage storage) {
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	            try (Connection conn = DriverManager.getConnection(url, username, password)){
	                  
	                String sql = "INSERT INTO storages (storage_adres) Values (?)";
	                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
	                    preparedStatement.setString(1, storage.getStorageAdres());
	                      
	                    return  preparedStatement.executeUpdate();
	                }
	            }
	        }
	        catch(Exception ex){
	            System.out.println(ex);
	        }
	        return 0;
	    }
	public static int delete(int id) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM storages WHERE storage_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
	}
	public static Storage selectOne(int id) {
        
        Storage storage = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM storages WHERE storage_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	int storageId = resultSet.getInt(1);
                        String storageAdres = resultSet.getString(2);
                        storage=new Storage(storageId, storageAdres);	
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return storage;
    }
    public static int update(Storage storage) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE storages SET storage_adres = ? WHERE storage_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, storage.getStorageAdres());
                    preparedStatement.setInt(2, storage.getStorageId());
                      
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
