package com.bank;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("WELCOME");
		System.out.println("------------------------------");
		BankDAO bankDAO=BankDAOFactory.createBankDAO();
		
			while(true) {
			
			try {
				
				int choice;
				System.out.println("Enter 1. to Create new Account ");
				System.out.println("Enter 2. to Fetch data of Accounts");
				System.out.println("Enter 3. to Update data of Existing Account");
				System.out.println("Enter 4. to Delete Account");
				System.out.println("Enter 5. to Restore Deleted Account");
				System.out.println("Enter 6. to Exit ");
				
				System.out.print("enter your choice:  ");
				choice=sc.nextInt();
				if(choice>6) {
					System.out.println("----------OOPS----------");
					System.out.println("---WRONG OPTION SELECTED---");
					System.out.println("PLEASE ENTER CORRECT OPTION ");
					System.out.println("------------------------------");
				}
				
				Bank bank;
				switch(choice) {
				case 1:
					//input
					Bank b=bankDAO.input();
					String result=bankDAO.create(b);
					System.out.println(result);
					System.out.println("--------------------");
					break;
				case 2:
					//fetch data
					System.out.println("-------------------");
					System.out.println("ALL RECORDS:-");
					result=bankDAO.fetchAll();
					System.out.println(result);
					System.out.println("--------------------");
					break;
				case 3:
					//update
					System.out.println("Enter only existing Account no. to update");
					bank=bankDAO.input();
					result=bankDAO.update(bank);
					System.out.println(result);
					System.out.println("--------------------");
					break;
				case 4:
					//delete
					System.out.print("Enter Costumer Account no. to delete: ");
					int accountno=sc.nextInt();
					result=bankDAO.delete(accountno);
					System.out.println(result);
					System.out.println("--------------------");
					break;
				case 5:
					//restore
					System.out.print("Enter Deleted Account no. to reactivate ");
					int Accountno=sc.nextInt();
					result=bankDAO.restore(Accountno);
					System.out.println(result);
					System.out.println("--------------------");
					break;
				case 6:
					System.out.println("--------Thanks for using my software----------");
					System.exit(0);
					System.out.println("--------------------");
				}
			}
			
			catch(Exception e) {
				System.out.println(e);
			}

		
			}
		}
	}
