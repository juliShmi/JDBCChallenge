package de.telekom.jdbcchallenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	final static String DRIVER = "org.mariadb.jdbc.Driver";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(DRIVER);
		// final String URL = "jdbc:mysql://localhost:3306/seadb","seauser","seapass";
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seadb", "seauser", "seapass");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from personen");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("ID: ");
		long id = Long.parseLong(scanner.nextLine());
		System.out.println("Anrede: ");
		short anrede = Short.parseShort(scanner.nextLine());
		System.out.println("Vorname: ");
		String vorname = scanner.nextLine();
		System.out.println("Nachname: ");
		String nachname = scanner.nextLine();
		System.out.println(id + " " + anrede + " " + vorname + " ");
		statement.executeQuery("INSERT INTO personen (ID, ANREDE, VORNAME, NACHNAME) VALUES  (" + id + ", " + anrede
				+ ", '" + vorname + "', '" + nachname + "')");
		
		
		resultSet = statement.executeQuery("select * from personen");
		while (resultSet.next()) {
			System.out.println("ID: " + resultSet.getLong(1)); // ID
			System.out.println("Anrede: " + resultSet.getShort(2)); // Anrede
			System.out.println("Vorname: " + resultSet.getString(3)); // Vorname
			System.out.println("Nachname: " + resultSet.getString(4)); // Nachname
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
}
