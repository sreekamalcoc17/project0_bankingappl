package com.revature.project0;

import java.util.Scanner;

public class EmpDisplay {
	static Employee e1 = new Employee();
	static ProjectMain p1 = new ProjectMain();
	
	public static void display() {
		System.out.println("_______________________________________________________________________");
		System.out.println("|                                                                      |");
		System.out.println("|    1.view customer accounts  2.pending approvals 	3.view logs		   |");
		System.out.println("|                    4.logout  5.logout and exit                       |");
		System.out.println("|______________________________________________________________________|");
		Scanner scan = new Scanner(System.in);
		int menutemp001 = scan.nextInt();
		if(menutemp001 == 2) {
			e1.acceptReject();
		}else if(menutemp001==1){
			e1.viewCustomerDetails();
			EmpDisplay.display();
		}
		else if (menutemp001 == 4) {
			System.out.println("you're now logged out!! please login to continue...!");
			p1.loginMain();
		} else if (menutemp001 == 5) {
			System.out.println("exiting the application! goodbye!!");
			System.exit(0);
		}else if(menutemp001 == 3) {
			e1.viewLogs();
			EmpDisplay.display();
		}
	}

}

