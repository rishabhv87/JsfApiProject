package com.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAccessController {


	public ResultSet callDB(String sqlQuery) {
	
	ResultSet rs ;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	Connection mySqlConnection = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11193239",
								"sql11193239", "QYyc0fgzhSgQPGbG");
	Statement sqlStatement = mySqlConnection.createStatement();
	rs=sqlStatement.executeQuery(sqlQuery);  
 
	
	return rs;
	}catch(Exception e){
		System.out.println(e);
	}

	return null;
	}
	
}
