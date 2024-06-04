package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
	private String name;
	private String specilization;

	public Doctor(String name, String specilization) {
		super();
		this.name = name;
		this.specilization = specilization;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/Hospital";
	String user = "root";
	String password = "system";

	public void addDoctors() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			String query = "insert into doctors(name,specilization) values(?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, specilization);

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Doctor added Successfully :) ");
			} else {
				System.out.println("Unable to add Doctor! ");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public boolean checkDoctor() {
		System.out.println("Enter a Doctor id : ");
		int id = sc.nextInt();
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String query = "select *from doctors where id=" + id;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				System.out.println(" Doctor Exists");
				return true;
			} else {
				System.out.println("Doctor Not Exists");
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
}
