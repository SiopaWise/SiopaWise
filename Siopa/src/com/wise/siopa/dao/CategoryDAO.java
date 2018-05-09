package com.wise.siopa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.siopa.dto.Category;
import com.wise.siopa.dto.Item;
import com.wise.siopa.dto.Moderator;
import com.wise.siopa.dto.SubCategory;
import com.wise.siopa.dto.User;
import com.wise.siopa.util.DBUtility;

public class CategoryDAO {
	public static void main(String [] args)	{
		CategoryDAO dao = new CategoryDAO();
		//moderator = dao.delete(1) ;
		System.out.println(dao.delete(1));
	}
	public int insert(Category category)	{
		System.out.println(category);
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "insert into category(name,logo,moderator_id) values(?,?,?)";		
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,category.getCategoryName());
			preparedStatement.setString(2, category.getLogo());
			preparedStatement.setInt(3, category.getModerator().getModeratorId());
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(preparedStatement);
		}			
		return status;
	}
	public Category getCategoryByCategoryName(String categoryName)	{
		System.out.println("hsvfhsbfhsbd");
		final String QUERY = "select * from category where name = ? and deleted = 0" ;
		ResultSet resultSet = null;
		Category category  = new Category();
		Moderator moderator = new Moderator();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {			
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, categoryName);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				System.out.println("Hai");
				category.setCategoryId(resultSet.getInt(1));
				category.setCategoryName(resultSet.getString(2));
				category.setLogo(resultSet.getString(3));
				System.out.println("hello");
				moderator.setModeratorId(resultSet.getInt(4));
				category.setModerator(moderator);
				System.out.println("hdwbqks" + category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return category;
	}
	public int delete(int categoryId)	{
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "update category set deleted = 1 where id = ? ";
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, categoryId);
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(preparedStatement);
		}		
		return status;
	}
	
	
	public List<Category> getAll()	{
		final String QUERY = "select * from category where deleted = "+0+"";
		ResultSet resultSet = null;
		List<Category> categoryList = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				categoryList = new ArrayList();
				do	{
					Category category = new Category();
					category.setCategoryId(resultSet.getInt(1));
				    category.setCategoryName(resultSet.getString(2));
				    category.setLogo(resultSet.getString(3));
				    categoryList.add(category);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return categoryList;
	}
}
