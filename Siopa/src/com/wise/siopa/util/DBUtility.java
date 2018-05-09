package com.wise.siopa.util;

import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
	static Connection connection = null;
	public static Connection getConnection()	{
		try	{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/siopa?useSSL=true", "root", "root");
			
		} catch(SQLException | ClassNotFoundException  exception)	{
			exception.printStackTrace();
		}
		return connection;
	}
	public static void close(Object ...args)	{
		for(Object arg : args)	{
			if(arg instanceof ResultSet)	{
				try {
					((ResultSet) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			if(arg instanceof Statement)	{
				try {
					((Statement) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(arg instanceof PreparedStatement)	{
				try {
					((PreparedStatement) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(arg instanceof Connection)	{
				try {
					((Connection) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
	public static java.util.Date sqlToUtil(java.sql.Date sqlDate) {
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	public static java.sql.Date utilToSql(java.util.Date utilDate) {
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public static String UtilToString(java.util.Date utilDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String string = formatter.format(utilDate);
		return string;
	}
	
	public static java.util.Date StringToUtil(String string) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date utilDate = null;
		try {
			utilDate = formatter.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return utilDate;
	}
}
