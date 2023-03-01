package login;

import java.sql.*;
import java.util.Scanner;

public class Ready {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("1)Registration...");
		System.out.println("2)Show your details.");
		System.out.println("3)update details.");
		System.out.println("4)Update password.");
		System.out.println("5)Detele user.");
		int ch = sc.nextInt();
		
		switch(ch)
		{
			case 1:
			{
				System.out.print("Enter name: ");
		        String name = sc.next();

		        System.out.print("Enter mobile number: ");
		        String mobile = sc.next();
		        
		        System.out.print("Enter address: ");
		        String address = sc.next();

		        System.out.print("Enter email: ");
		        String email = sc.next();

		        System.out.print("Enter password: ");
		        String password = sc.next();
		        
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("Connecting to database...");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root", "");
		        
		        String sql = "INSERT INTO user_info (name, mobile, address, email,  password) VALUES (?,?,?,?,?)";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, name);
		        pstmt.setString(2, mobile);
		        pstmt.setString(3, address);
		        pstmt.setString(4, email);
		        pstmt.setString(5, password);
		        pstmt.executeUpdate();

		        System.out.println("Data inserted successfully");
		        
		        conn.close();
			}
			break;
			
			case 2:
			{
				System.out.print("Enter email: ");
		        String email = sc.next();

		        System.out.print("Enter password: ");
		        String password = sc.next();
		        
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("Connecting to database...");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root", "");
		        
		        String sql = "SELECT * FROM user_info WHERE email = ? AND password = ?";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, email);
		        pstmt.setString(2, password);
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) 
		        {
		            System.out.println("Name: " + rs.getString("name"));
		            System.out.println("Mobile:" + rs.getString("mobile"));
					System.out.println("Email: " + rs.getString("email"));
					System.out.println("Address: " + rs.getString("address"));
				} 
				else 
				{
					System.out.println("Invalid email or password.");
				}
			}
			break;
			
			case 3:
			{
				System.out.print("Enter email: ");
		        String email = sc.next();

		        System.out.print("Enter password: ");
		        String password = sc.next();
		        
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("Connecting to database...");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root", "");
		        
		        String sql = "SELECT * FROM user_info WHERE email = ? AND password = ?";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, email);
		        pstmt.setString(2, password);
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) 
		        {
		        	System.out.println("1. Update name");
		            System.out.println("2. Update mobile number");
		            System.out.println("3. Update address");
		            System.out.print("Enter your choice: ");
		            int choice = sc.nextInt();
		            sc.nextLine();

		            String columnName = "";
		            String newValue = "";
		            switch (choice) 
		            {
		            	case 1:
		            		columnName = "name";
		                    System.out.print("Enter new name: ");
		                    newValue = sc.nextLine();
		                    break;
		                case 2:
		                    columnName = "mobile";
		                    System.out.print("Enter new mobile number: ");
		                    newValue = sc.nextLine();
		                    break;
		                case 3:
		                    columnName = "address";
		                    System.out.print("Enter new address: ");
		                    newValue = sc.nextLine();
		                    break;
		                default:
		                    System.out.println("Invalid choice.");
		            }
		            sql = "UPDATE user_info SET " + columnName + " = ? WHERE email = ? AND password = ?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, newValue);
		            pstmt.setString(2, email);
		            pstmt.setString(3, password);
		            int rowsAffected = pstmt.executeUpdate();
		            if (rowsAffected > 0) {
		                System.out.println(columnName + " updated successfully");
		            } else {
		                System.out.println("Failed to update " + columnName);
		            }
		        } 
		        else 
		        {
		            System.out.println("Invalid email or password.");
		        }
			}
			break;
			
			case 4:
			{
				System.out.print("Enter email: ");
		        String email = sc.next();

		        System.out.print("Enter current password: ");
		        String currentPassword = sc.next();

		        System.out.print("Enter new password: ");
		        String newPassword = sc.next();
		        
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("Connecting to database...");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root", "");
		        
		        String sql = "SELECT * FROM user_info WHERE email = ? AND password = ?";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, email);
		        pstmt.setString(2, currentPassword);
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) 
		        {
		            sql = "UPDATE user_info SET password = ? WHERE email = ?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, newPassword);
		            pstmt.setString(2, email);
		            int rowsAffected = pstmt.executeUpdate();
		            if (rowsAffected > 0) {
		                System.out.println("Password updated successfully");
		            } else {
		                System.out.println("Failed to update password.");
		            }
		        } 
		        else 
		        {
		            System.out.println("Invalid email or current password.");
		        }
			}
			break;
			
			case 5:
			{
				System.out.print("Enter email: ");
		        String email = sc.next();

		        System.out.print("Enter password: ");
		        String password = sc.next();
		        
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("Connecting to database...");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root", "");
		        
		        String sql = "DELETE FROM user_info WHERE email = ? AND password = ?";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, email);
		        pstmt.setString(2, password);
		        int rowsDeleted = pstmt.executeUpdate();
		        if (rowsDeleted > 0) 
		        {
		            System.out.println("User information deleted successfully.");
		        } 
		        else 
		        {
		            System.out.println("Invalid email or password.");
		        }
		        
			}
			break;
			
			default:
			{
				System.out.println("Enter write choice...");
			}
		}
		
		

	}

}
