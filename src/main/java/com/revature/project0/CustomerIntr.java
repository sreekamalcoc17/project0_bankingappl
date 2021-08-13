package com.revature.project0;

public interface CustomerIntr {
	
	void createNewAcc();
	int viewbal(int id);
	void transactionWithdrawl(int amount, int id);
	void transactionDeposit(int amount, int id,int params);
	//void sendReq();
	//void recievedReq();
	//void login(int id, String password);
	void accDetails(int id);
}
