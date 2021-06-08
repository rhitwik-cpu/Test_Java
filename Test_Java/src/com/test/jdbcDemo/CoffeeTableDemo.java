package com.test.jdbcDemo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoffeeTableDemo {
	
	private static Connection connection = null;
	
	private Connection getConnection() {
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "c##Rhitwik";
		String password = "myrhitwik";
		try {
			if(connection == null) {
				Driver driver = new oracle.jdbc.driver.OracleDriver();
				DriverManager.registerDriver(driver);
				connection = DriverManager.getConnection(dbUrl, userName, password);
			}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
	
	private void closeConnection() {
		try {
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void joinAndPrintInfo() {
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		String joinQuery = "SELECT cod.CUSTOMER_ID,cod.CUSTOMER_NAME,cd.COFFEE_TYPE,cd.PRICE"+
				" FROM coffee_details cd JOIN coffee_order_details cod"+
				" ON cd.id = cod.product_id"+
				" WHERE cd.price >= 20.00"+
				" ORDER BY cod.customer_id";
		
		CoffeeTableDemo c = new CoffeeTableDemo();
		System.out.println("CUSTOMER DETAILS FOR ORDERS WORTH EQUAL TO OR MORE THAN $20.00\n");
		try {
			statement = c.getConnection().createStatement();
			resultSet = statement.executeQuery(joinQuery);
			while(resultSet.next()) {
				System.out.println("Customer ID : "+resultSet.getInt("CUSTOMER_ID"));
				System.out.println("Customer Name : "+resultSet.getString("CUSTOMER_NAME"));
				System.out.println("Coffee Type : "+resultSet.getString("COFFEE_TYPE"));
				System.out.println("Price : $"+resultSet.getFloat("PRICE")+"\n");
			}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				statement.close();
				c.closeConnection();
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}