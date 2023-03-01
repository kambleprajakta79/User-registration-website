package login;

import java.sql.*;
import java.util.Scanner;

public class DeleteUser {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
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
        
        conn.close();

	}

}
