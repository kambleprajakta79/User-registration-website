package login;

import java.sql.*;
import java.util.Scanner;

public class DisplayUserInfo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
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
			System.out.println("Enter correct information or register your details first :)");
		}
	}

}
