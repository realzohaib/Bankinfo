package com.bank;

public interface BankDAO {
	String create(Bank bank);
	String fetchAll();
	Bank input();
	String update(Bank bank);
	String delete(int accontno);
	String restore(int accountno);
	

}
