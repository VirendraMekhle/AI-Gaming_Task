package Gamingtask.com;

import java.sql.SQLException;
import java.util.Scanner;

public class HomeMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		LoginScreen lgs = new LoginScreen();
		System.out.println("Enter username: ");
		String username = sc.nextLine();
		System.out.println("Enter your password: ");
		String password = sc.nextLine();
		if (lgs.login(username, password)) {
			System.out.println("Login successfully");
			new LostScreen(username).showScreen();
		} else {
			System.out.println("Wrong username & password");
		}
		sc.close();
	}
}
