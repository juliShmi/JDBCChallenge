package de.telekom.jdbcchallenge;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Main {

	final static String DRIVER = "org.mariadb.jdbc.Driver";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);

		//final String URL = "'jdbc:mysql://localhost:3306/seadb', 'seauser', 'seapass'";
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seadb", "seauser", "seapass");
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from personen");
		while(resultSet.next()) {
		    System.out.println("ID: " + resultSet.getLong(1)); // ID
		    System.out.println("Anrede: " +resultSet.getShort(2)); // Anrede
		    System.out.println("Vorname: "+resultSet.getString(3)); //Vorname
		    System.out.println("Nachname: "+resultSet.getString(4));// Nachname
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		// TODO Auto-generated method stub

	}

}
