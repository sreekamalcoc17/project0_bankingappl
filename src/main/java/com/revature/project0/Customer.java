package com.revature.project0;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer extends User implements CustomerIntr {
	private int id;
	private String password;

	Connection con = ConnectionUtils.getConnection();
	private static final Logger logger = LogManager.getLogger(Customer.class);

	
	@Override
	public boolean login(int id, String password) {
		// TODO Auto-generated method stub
		this.id = id;
		this.password = password;
		boolean bool = false;
		logger.entry();
		String query01 = "select * from customerlogindetails where id=? and pswd=? and approval=1";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setInt(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				stmt.close();
				bool = true;
				logger.info(id+" logged in");
			} else {
				stmt.close();
				bool = false;
				logger.info(id+" tried to login and failed.");
			}

			// con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.exit();
		return bool;
	}

	@Override
	public void createCustomerAcc() {
		logger.entry();
		// TODO Auto-generated method stub
		int candidateId = 0;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter your fist name: ");
		String fname = scan.next();
		System.out.println("enter your last name: ");
		String lname = scan.next();
		System.out.println("enter your opening balance: ");
		int bal = scan.nextInt();
		System.out.println("enter your password:");
		String pass = scan.next();
		try {
			String query01="insert into customerlogindetails(firstname,lastname,balance,pswd,approval) values(?,?,?,?,0)";
			PreparedStatement stmt = con.prepareStatement(query01,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setInt(3, bal);
			stmt.setString(4, pass);
			
			int rowAffected = stmt.executeUpdate();
			if(rowAffected == 1) {
				rs = stmt.getGeneratedKeys();
				if(rs.next()) 
	                candidateId = rs.getInt("id");
	            
				System.out.println("welcome to the bank, "+fname);
				System.out.println("Your id is: "+candidateId);
				System.out.println("press 1 to go back to login screen..");
				int temp0001 = scan.nextInt();
				logger.info("new account registered"+candidateId);
				if(temp0001 == 1) {
					stmt.close();
					ProjectMain.loginMain();
				}else {
					stmt.close();
				}
			}else {
				stmt.close();
				
			}
            
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
logger.exit();
	}

	// --------------------------------

	@Override
	public void createNewAcc() {
		// TODO Auto-generated method stub
		createCustomerAcc();

	}

	@Override
	public int viewbal(int id) {
		// TODO Auto-generated method stub
		logger.entry();
		int balTemp = 0;
		String query01 = "select balance from customerlogindetails where id = ?";
		try {
			logger.info(id+" trying to retrive the balance");
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				balTemp =  rs.getInt("balance");
				
			}
			logger.info(id+" balance retrieval success.");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.exit();
		return balTemp;

		

	}

	@Override
	public void transactionWithdrawl(int amount,int id) {
		// TODO Auto-generated method stub
		int balanceT = viewbal(id);
			System.out.println("Processing withdrawl...");
			
			if(balanceT>amount && amount>0) {
				balanceT = balanceT-amount;
				String query01 = "update customerlogindetails set balance = ? where id = ?";
				try {
					PreparedStatement stmt = con.prepareStatement(query01);
					stmt.setInt(1, balanceT);
					stmt.setInt(2, id);
					stmt.execute();
					
					System.out.println("Transaction Sucessfull..");
					System.out.println("Your current balance is: "+ viewbal(id));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Transaction Failed!!..Insufficient funds..try again!!");
				DisplayMenu.display(id);
			}
			
		}
			
		

	@Override
	public void transactionDeposit(int amount, int id, int params) {
		// TODO Auto-generated method stub
		int balanceT = viewbal(id);
			if(amount>0) {
				balanceT = balanceT+amount;
				String query01 = "update customerlogindetails set balance = ? where id = ?";
				try {
					PreparedStatement stmt = con.prepareStatement(query01);
					stmt.setInt(1, balanceT);
					stmt.setInt(2, id);
					stmt.execute();
					if(params ==0) {
						System.out.println("Transaction Sucessfull..");
						System.out.println("Your current balance is: "+ viewbal(id));
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Transaction Failed!!..please enter a valid amount..try again!!");
				DisplayMenu.display(id);
			}
		}

	@Override
	public void accDetails(int id) {
		// TODO Auto-generated method stub
		String query01 = "select * from customerlogindetails where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("Your name is:"+rs.getString("firstname")+" "+rs.getString("lastname")+"\n"+"Your ID is: "+rs.getInt("id")+"\n"+"Your balance is : "+rs.getInt("balance"));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}


