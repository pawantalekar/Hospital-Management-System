package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Statement;
import java.util.Scanner;

public class Patient {

	private String pname;
	private int page;
	private String gender;

	public Patient(String pname, int page, String gender) {
		super();

		this.pname = pname;
		this.page = page;
		this.gender = gender;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/Hospital";
	String user = "root";
	String password = "system";

	public void addPatient() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			String query = "insert into patient(name,age, gender) values(?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, pname);
			preparedStatement.setInt(2, page);
			preparedStatement.setString(3, gender);

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Patient added Successfully :) ");
			} else {
				System.out.println("Unable to add patient! ");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean viewPatient() {
		System.out.println("Enter a Patient id : ");
		int id = sc.nextInt();
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String query = "select *from patient where id=" + id;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs =preparedStatement.executeQuery();
			if(rs.next()) {
				System.out.println("Patient Exists ");
				return true;
			}
			else {
				System.out.println("Patient Not Exists");
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
//	public void addPatient() {
//	
//	String url = "jdbc:mysql://localhost:3306/Hospital";
//	String user = "root";
//	String password = "system";
//
//	try {
//		Connection conn = DriverManager.getConnection(url, user, password);
//
//		Statement stm = conn.createStatement();
//
//		String query = "insert into patients values  ("+pname+","+page+","+gender+")"; ;
//
//		stm.execute(query);
//		System.out.println("Data inserted Successfully");
//		conn.close();
//	} catch (SQLException e) {
//
//		e.printStackTrace();
//	}
//}

	// main method

//	public static void main(String[] args) throws SQLException {
//
//		String url = "jdbc:mysql://localhost:3306/Hospital";
//		String user = "root";
//		String password = "system";
//
//		try {
//			Connection conn = DriverManager.getConnection(url, user, password);
//
//			Statement stm = conn.createStatement();
//
//			String query = "";
//
//			stm.execute(query);
//			System.out.println("Databse Created Successfully");
//			conn.close();
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//	}

}
