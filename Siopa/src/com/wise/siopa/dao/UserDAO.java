package com.wise.siopa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.siopa.dto.User;
import com.wise.siopa.util.DBUtility;


public class UserDAO {
	public static void main(String [] args)	{
		UserDAO dao = new UserDAO();
		User user = new User();
		List l = new ArrayList();
		l = dao.getAll();
		//System.out.println(user);
	}
	public int insertUser(User user)	{
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "insert into user(name,phone_number,email_id,password,date_of_birth) values(?,?,?,?,?)";		
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,user.getUserName());
			preparedStatement.setLong(2, user.getUserPhoneNumber());
			preparedStatement.setString(3, user.getUserEmailId());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setDate(5, DBUtility.utilToSql(user.getDateOfBirth()));
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(preparedStatement);
		}	
		return status;
	}
	public User getUserByUserId(int userId)	{
		final String QUERY = "select * from user where id = ? and unsubscribe = "+0+"";
		ResultSet resultSet = null;
		User user = new User();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				user.setUserName(resultSet.getString(2));
			    user.setUserPhoneNumber(resultSet.getLong(3));
			    user.setUserEmailId(resultSet.getString(4));
			    user.setDateOfBirth(resultSet.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return user;
	}
	public User getUserByEmailId(String userEmailId)	{
		final String QUERY = "select * from user where email_id = ? and unsubscribe = "+0+"";
		ResultSet resultSet = null;
		User user = new User();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, userEmailId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				user.setUserName(resultSet.getString(2));
			    user.setUserPhoneNumber(resultSet.getLong(3));			    
			    user.setUserEmailId(resultSet.getString(4));
			    user.setPassword(resultSet.getString(5));
			    user.setDateOfBirth(resultSet.getDate(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return user;
	}
	public int updateUser(int userId)	{
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "update user set email_id = ?,phone_number = ? ,password = ? where  id = ? ";
		User user = new User();
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, user.getUserEmailId());
			preparedStatement.setLong(2,user.getUserPhoneNumber());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, userId);
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally	{
			 DBUtility.close(preparedStatement);
		}		
		return status;
	}
	public List<User> getAll()	{
		final String QUERY = "select * from user where unsubscribe = "+0+"";
		ResultSet resultSet = null;
		List<User> userList = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				userList = new ArrayList<User>();
				do	{
					User user = new User();
					user.setUserName(resultSet.getString(2));
				    user.setUserPhoneNumber(resultSet.getLong(3));
				    user.setUserEmailId(resultSet.getString(4));
				    user.setDateOfBirth(resultSet.getDate(5));
				    userList.add(user);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return userList;
	}
	
}


