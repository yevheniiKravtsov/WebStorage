package storage.DBmanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import storage.entity.Supplier;

public class SupplierDB {
	private static String url = "jdbc:mysql://localhost:3306/storagedb?allowPublicKeyRetrieval=true&serverTimezone=Europe/Kiev&useSSL=false";
    private static String username = "yevheniiKravtsov";
    private static String password = "ab1234ab";

	public static ArrayList<Supplier> select(){
		
		ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
            	Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from suppliers");
                while(resultSet.next()){
                      
                	int id = resultSet.getInt(1);
                	String supplierName = resultSet.getString(2);
                	String supplierPhone = resultSet.getString(3);
                    Supplier supplier = new Supplier(id, supplierName, supplierPhone);
                    supplierList.add(supplier);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return supplierList;
    }
	public static Supplier selectOne(int id){
		
		Supplier supplier=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "SELECT * From suppliers where supplier_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setInt(1,id);
            		ResultSet resultSet = preparedStatement.executeQuery();
            		if(resultSet.next()) {
            			int supplierId=resultSet.getInt(1);
            			String name=resultSet.getString(2);
            			String phone = resultSet.getString(3);
            			supplier= new Supplier(supplierId, name, phone);
            		}
            		
            	}
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return supplier;
 	}
	public static int insert(Supplier supplier){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Insert into suppliers (supplier_name, supplier_phone) Values (?,?)";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		
            		preparedStatement.setString(1,supplier.getSupplierName());
            		preparedStatement.setString(2,supplier.getSupplierPhone());
    
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
                String sql= "Delete From suppliers Where supplier_id=?";
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
	public static int update(Supplier supplier){		
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql= "Update suppliers Set supplier_name=?, supplier_phone=? Where supplier_id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            		preparedStatement.setString(1,supplier.getSupplierName());
            		preparedStatement.setString(2,supplier.getSupplierPhone());
            		preparedStatement.setInt(3,supplier.getSupplierId());
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
