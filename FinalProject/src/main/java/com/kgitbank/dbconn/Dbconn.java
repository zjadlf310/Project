package com.kgitbank.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	private Connection con;
	public Dbconn() throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated constructor stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.58.17:1521:xe","hr","hr");
	}
	public Connection getConnection(){
		return con;
	}
}