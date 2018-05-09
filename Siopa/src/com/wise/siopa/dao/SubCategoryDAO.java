package com.wise.siopa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.siopa.dto.SubCategory;
import com.wise.siopa.dto.User;
import com.wise.siopa.util.DBUtility;

public class SubCategoryDAO {
	public static void main(String [] args)	{
		SubCategoryDAO dao = new SubCategoryDAO();
		//moderator = dao.delete(1) ;
		System.out.println(dao.delete(1));
	}
	public int insert(SubCategory subCategory)	{
		int status = 0;
		final String QUERY = "insert into sub_category(name,image,moderator_id,category_id) values(?,?,?,?)";		
		try(Connection connection = DBUtility.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,subCategory.getSubCategoryName());
			preparedStatement.setString(2, subCategory.getImage());
			preparedStatement.setInt(3, subCategory.getModerator().getModeratorId());
			System.out.println(subCategory.getCategory().getCategoryId());
			preparedStatement.setInt(4,subCategory.getCategory().getCategoryId());
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;
	}
	public int delete(int subCategoryId)	{
		int status = 0;
		final String QUERY = "update sub_category set deleted = 1 where id = ? ";
		try(Connection connection = DBUtility.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, subCategoryId);
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;
	}
	
	public List<SubCategory> getAll()	{
		final String QUERY = "select * from sub_category where deleted = "+0+"";
		ResultSet resultSet = null;
		SubCategory subCategory = null;
		List<SubCategory> subCategoryList = new ArrayList();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				do	{
					subCategory = new SubCategory();
					subCategory.setSubCategoryId(resultSet.getInt(1));;
				    subCategory.setSubCategoryName(resultSet.getString(2));;
				    subCategory.setImage(resultSet.getString(3));
				    subCategoryList.add(subCategory);
				    System.out.println(subCategoryList+"loop");
				} while(resultSet.next());
				System.out.println(subCategoryList+"----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return subCategoryList;
	}
}
