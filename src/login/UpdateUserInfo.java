package login;

import java.sql.*;
import java.util.Scanner;

public class UpdateUserInfo {

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

}
