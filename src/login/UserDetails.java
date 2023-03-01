package login;

import java.sql.*;
import java.util.Scanner;

public class UserDetails {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();
        
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
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
	
}
