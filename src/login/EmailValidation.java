package login;

import java.util.Scanner;

public class EmailValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                            
        if (!email.matches(emailRegex)) {
            System.out.println("Invalid email format.");
        }
        else
        {
        	  System.out.println("Email is valid");
        }   

	}

}
