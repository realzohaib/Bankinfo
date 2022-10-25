package com.bank;

public class BankDAOFactory {
	public static BankDAO createBankDAO()  {
		return (new BankDAOimpl());
	}

}
	
