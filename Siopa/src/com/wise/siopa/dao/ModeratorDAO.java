package com.wise.siopa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wise.siopa.dto.Moderator;
import com.wise.siopa.dto.User;
import com.wise.siopa.util.DBUtility;

public class ModeratorDAO {
	public static void main(String [] args)	{
		ModeratorDAO dao = new ModeratorDAO();
		
		Moderator moderator = new Moderator();
		moderator = dao.getModeratorByEmailId("tsaivaishnavi11@gmail.com") ;
		System.out.println(moderator);
	}
	public int insertModerator(Moderator moderator)	{
		int status = 0;
		final String QUERY = "insert into moderator(name,password,email,phone_number) values(?,?,?,?)";		
		try(Connection connection = DBUtility.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,moderator.getModeratorName());
			preparedStatement.setString(2, moderator.getPassword());
			preparedStatement.setString(3, moderator.getModeratorEmailId());
			preparedStatement.setLong(4, moderator.getModeratorPhoneNumber());
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;
	}
	public Moderator getModeratorById(int moderatorId)	{
		final String QUERY = "select * from moderator where id = ?";
		ResultSet resultSet = null;
		Moderator moderator = new Moderator();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, moderatorId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				moderator.setModeratorName(resultSet.getString(2));
			    moderator.setModeratorPhoneNumber(resultSet.getLong(5));
			    moderator.setModeratorEmailId(resultSet.getString(4));    
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return moderator;
	}
	public Moderator getModeratorByEmailId(String moderatorEmailId)	{
		final String QUERY = "select * from moderator where email = ?";
		ResultSet resultSet = null;
		Moderator moderator = new Moderator();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, moderatorEmailId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				moderator.setModeratorId(resultSet.getInt(1));
				moderator.setModeratorName(resultSet.getString(2));
				moderator.setPassword(resultSet.getString(3));
			    moderator.setModeratorPhoneNumber(resultSet.getLong(5));
			    moderator.setModeratorEmailId(resultSet.getString(4)); 
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return moderator;
	}
	public int updateModerator(int moderatorId)	{
		int status = 0;
		final String QUERY = "update user set email_id = ?,phone_number = ? ,password = ? where  id = ? ";
		Moderator moderator = new Moderator();
		try(Connection connection = DBUtility.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, moderator.getModeratorEmailId());
			preparedStatement.setLong(2,moderator.getModeratorPhoneNumber());
			preparedStatement.setString(3, moderator.getPassword());
			preparedStatement.setInt(4, moderatorId);
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;
	}
}
