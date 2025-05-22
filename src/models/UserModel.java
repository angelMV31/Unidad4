package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Statement;

public class UserModel {

private ArrayList<User> users = new ArrayList<User>();
	
	public UserModel() {
		
	}
	
	public ArrayList<User> get()
	{
		
		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			while (rs.next()) {
				
				Integer empId = rs.getInt(1);
				String firstName = rs.getString(2);
				String email = rs.getString(3); 
				String role = rs.getString(4); 
				String phone = rs.getString(5);
				
				users.add(new User(empId,firstName,email,role,phone,null,null));
				
				/*System.out.println("empId:" + empId);
				System.out.println("firstName:" + firstName);
				System.out.println("email:" + email); 
				System.out.println("");*/
				
				
			}
			rs.close();
			
			return users; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				((Connection) stmt).close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return users; 
		
	}
	
	public boolean add(String name,String email,String rol, String telefono) {
		String query = "INSERT INTO `users` (`id`, `name`, `email`, `role`, `phone`, `create_at`, `update_at`) VALUES (NULL, '"+name+"', '"+email+"', '"+rol+"', '"+telefono+"', NULL, NULL);";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = (Statement) conn.createStatement();
			
			int rs = ((java.sql.Statement) stmt).executeUpdate(query);
			
			if(rs>0)
				return true;
			
			return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				((Connection) stmt).close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false; 
	}
}
