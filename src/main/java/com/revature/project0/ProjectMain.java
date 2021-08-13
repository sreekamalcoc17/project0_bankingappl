package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ProjectMain {
	private String psw1;
	static Customer c1 = new Customer();
	static Employee e1 = new Employee();
	static DisplayMenu d1 = new DisplayMenu();
	static EmpDisplay ed1 = new EmpDisplay();
	Connection con = null;
	

	public static void loginMain() {
		Scanner scan = new Scanner(System.in);
		try {
			Connection con = ConnectionUtils.getConnection();
			System.out.println("_____________________________________________________");
			System.out.println("|                                                    |");
			System.out.println("|   1. login        2. Register for new account      |");
			System.out.println("|                                                    |");
			System.out.println("|____________________________________________________|");

			int a = scan.nextInt();
			// -----------
			if (a == 1) {
				System.out.println("_____________________________________________________");
				System.out.println("|                                                    |");
				System.out.println("|   1. login as Customer   2. login as employee      |");
				System.out.println("|                                                    |");
				System.out.println("|____________________________________________________|");


				int b = scan.nextInt();
				if (b == 1) {
					System.out.println("enter your ID:");
					int id1 = scan.nextInt();
					System.out.println("enter your password:");
					String psw1 = scan.next();
					boolean bool1 = c1.login(id1, psw1);
					if (bool1 == true) {
						System.out.println("login sucessful");
						d1.display(id1);

					} else {
						System.out.println("please check the id and password!!!");
						loginMain();
					}
				} else if (b == 2) {
					System.out.println("enter your ID:");
					String id1 = scan.next();
					System.out.println("enter your password:");
					String psw1 = scan.next();
					boolean bool1 = e1.login(id1, psw1);
					if (bool1 == true) {
						System.out.println("login sucessful");
						System.out.println("_____________________________________________________________________________________________________________");
						ed1.display();
						

					} else {
						System.out.println("please check the id and password!!!");
						loginMain();
					}

				} }else if (a == 2) {
					System.out.println("please fill the below details: ");
					c1.createCustomerAcc();

				}else {
					System.out.println("please input valid selection:");
					loginMain();
				}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		loginMain();

	}
}
