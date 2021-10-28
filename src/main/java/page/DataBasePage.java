package page;

import java.sql.*;

public class DataBasePage {

	/*
	 * String columnValue = null; Connection connection = null; Statement statement
	 * = null; ResultSet rs = null;
	 */
	public static String getData(String columnName) throws ClassNotFoundException,SQLException {
	  
	   //setting properties for mysql
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   String sqlUrl = "jdbc:mysql://localhost:3306/august2020";
	   String sqlUsername = "root";
	   String sqlPassword = "Amenlove1@";
	   String query = "Select * from users";   
	   
	   //Create connection to local database
	   Connection  con= DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);   
	   
	   //Empowering the con reference variable to execute queries
	   Statement smt=con.createStatement();   
	   
	   //Delivering the sql query
	    ResultSet  rs = smt.executeQuery(query);
	   while(rs.next()) {
	     return rs.getString(columnName);
	   }
	   return columnName;
	   }
	}

	/*  } catch (Exception e) {
	   e.printStackTrace();
	  } finally {
	   if (rs != null) {
	    rs.close();
	   }
	   if (connection != null) {
	    connection.close();
	   }
	  }
	  return columnValue;
	 }*/



/*
 * @DbLogin Feature: Techfios Other login functionality validation driving the
 * data from MySql database
 * 
 * Background: Given User is on Techfios login page
 * 
 * @DbScenario1 Scenario: User should be able to login with valid credentials
 * and open a new account When User enters "username" from mysql database When
 * User enters "password" from mysql database And User clicks on Signin button
 * Then User should land on Dashboard page
 */





	/*
	 * @When("^User enters \"([^\"]*)\" from mysql database$") public void
	 * user_enters_from_mysql_database(String data) throws Throwable { switch (data)
	 * { case "username": System.out.println("Username from DB: "+
	 * databasePage.getData("username"));
	 * loginPage.enterUserName(databasePage.getData("username"));
	 * Thread.sleep(3000); break; case "password":
	 * System.out.println("Password from DB: "+ databasePage.getData("password"));
	 * loginPage.enterPassword(databasePage.getData("password")); break; default:
	 * System.out.println("Unable to enter data!"); } }
	 */
