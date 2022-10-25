package com.bank;
import java.sql.*;
import java.util.Scanner;
public class BankDAOimpl implements BankDAO{
	
	private String driver="com.mysql.cj.jdbc.Driver",
			username="root",
			password="",
			dburl="jdbc:mysql://localhost:3306/zohaibdb";
	private Connection con=null;
	void createConnection() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl,
					username, password);
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	

	@Override
	public String create(Bank bank) {
		// TODO Auto-generated method stub
		String result="";
		try {
			createConnection();
			String insertquery="insert into bank values(?,?,?,?,?,?,?,?,?,?)" ;
			PreparedStatement ps=con.prepareStatement(insertquery);
			ps.setInt(1, bank.getAccountno());
			ps.setString(2, bank.getFname());
			ps.setString(3, bank.getLname());
			ps.setString(4, bank.getGender());
			ps.setString(5, bank.getAddress());
			ps.setString(6, bank.getCity());
			ps.setString(7, bank.getPincode());
			ps.setString(8, bank.getMobileno());
			ps.setString(9, bank.getRegdate());
			ps.setString(10, "active");
			int res=ps.executeUpdate();
			result=res+" record/s inserted in bank table";
			ps.close();
			con.close();
		}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	}

	@Override
	public String fetchAll() {
		String result="";
		try {
			createConnection();
			String query="select * from bank "
					+ "where "
					+ "currentstatus='active'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()==true) {
				for(int i=1;i<=10;i++) {
					result+=rs.getString(i)+"\t ";
				}
				result+="\n";
			}
			rs.close();
			stmt.close();
			}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	}

	@Override
	public Bank input() {
		Bank bank=new Bank();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Costumer first name: ");
		bank.setFname(sc.nextLine());
		System.out.print("Enter Costumer last name: ");
		bank.setLname(sc.nextLine());
		System.out.print("Enter Costumer Gender: ");
		bank.setGender(sc.nextLine());
		System.out.print("Enter Costumer Address: ");
		bank.setAddress(sc.nextLine());
		System.out.print("Enter City: ");
		bank.setCity(sc.nextLine());
		System.out.print("Enter City Pincode: ");
		bank.setPincode(sc.nextLine());
		System.out.print("Enter Mobile no.: ");
		bank.setMobileno(sc.nextLine());
		System.out.print("Enter Rgistration date in format yyyy/mm/dd: ");
		bank.setRegdate(sc.nextLine());
		System.out.print("Enter Costumer Account no.: ");
		bank.setAccountno(sc.nextInt());
		return(bank);
		}
	

	@Override
	public String update(Bank bank) {
		String result="";
		try {
			String query="update bank set "+
					" Fname=?, "+
							" Lname=?, "+
					"Gender=?,"+
							"Address=?,"+
					"City=?,"+
							"Pincode=?,"+
					"Mobileno=?,"+
							"Regdate=?"+
					" where Accountno=?";
			createConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,bank.getFname());
			ps.setString(2, bank.getLname());
			ps.setString(3, bank.getGender());
			ps.setString(4, bank.getAddress() );
			ps.setString(5, bank.getCity());
			ps.setString(6, bank.getPincode());
			ps.setString(7, bank.getMobileno());
			ps.setString(8, bank.getRegdate());
			ps.setInt(9, bank.getAccountno());
			
			int res=ps.executeUpdate();
			result=res+" reocord/s updated in bank table";
			}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	}
	

	@Override
	public String delete(int accountno) {
		
		String result="";
		try {
			createConnection();
			String query="update bank set "+
					" currentstatus='close' "+
								" where Accountno=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, accountno);
			int res=ps.executeUpdate();
			result=res+" record/s deleted from bank table";
			ps.close();
			con.close();
			}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	}


	@Override
	public String restore(int accountno) {
		String result="";
		try {
			createConnection();
			String query="update bank set "+
					" currentstatus='active' "+
					" where Accountno=?";;
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, accountno);
			int res=ps.executeUpdate();
			result=res+" record/s activated from bank table";
			ps.close();
			con.close();
			}
		catch(Exception e) {
			result=e.toString();
		}
	return result;
		}
}

