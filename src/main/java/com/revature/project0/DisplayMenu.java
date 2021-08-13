package com.revature.project0;

import java.util.Scanner;

public class DisplayMenu {
	static ProjectMain p1 = new ProjectMain();
	static Customer c1 = new Customer();
	

	public static void display(int id) {
		System.out.println("_______________________________________________________________________");
		System.out.println("|                                                                      |");
		System.out.println("|1.view balance  2.Make a transaction 3.send money  4.Account details  |");
		System.out.println("|         5.create new account   6.logout  7.logout and exit           |");
		System.out.println("|______________________________________________________________________|");
		Scanner scan = new Scanner(System.in);
		int menutemp001 = scan.nextInt();
		if (menutemp001 == 1) {
			System.out.println("Your current balance is: "+ c1.viewbal(id));
			DisplayMenu.display(id);
		} else if (menutemp001 == 2) {
			System.out.println("select one option:\n1.Withdrawl\n2.Deposit");
			int modeofTransaction = scan.nextInt();
			if (modeofTransaction == 1) {
				System.out.println("enter the amount to withdraw: ");
				int withdrawTemp = scan.nextInt();
				c1.transactionWithdrawl(withdrawTemp,id);
				DisplayMenu.display(id);
			}
			else if(modeofTransaction == 2) {
				System.out.println("enter the amount to deposit: ");
				int withdrawTemp = scan.nextInt();
				c1.transactionDeposit(withdrawTemp,id,0);
				DisplayMenu.display(id);
			}
		}
		else if(menutemp001 == 3) {
			System.out.println("Enter the id of the reciever: ");
			int recID = scan.nextInt();
			System.out.println("Enter your amount to transfer: ");
			int sendamount = scan.nextInt();
			c1.transactionWithdrawl(sendamount,id);
			c1.transactionDeposit(sendamount,recID,1);
			DisplayMenu.display(id);
		}
		else if (menutemp001== 4) {
			c1.accDetails(id);
			DisplayMenu.display(id);
		}
		else if (menutemp001 == 5) {
			c1.createNewAcc();
		} else if (menutemp001 == 6) {
			System.out.println("you're now logged out!! please login to continue...!");
			p1.loginMain();
		} else if (menutemp001 == 7) {
			System.out.println("exiting the application! goodbye!!");
			System.exit(0);
		}

	}

}
