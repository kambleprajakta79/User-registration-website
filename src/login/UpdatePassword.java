package login;

import java.sql.*;
import java.util.Scanner;

public class UpdatePassword {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter current password: ");
        String currentPassword = sc.nextLine();

        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();
        
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
        
        conn.close();
	}

}
