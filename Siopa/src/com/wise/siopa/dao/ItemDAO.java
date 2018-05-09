package com.wise.siopa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.siopa.dto.Item;
import com.wise.siopa.dto.Moderator;
import com.wise.siopa.util.DBUtility;

public class ItemDAO {
	public static void main(String [] args)	{
		ItemDAO dao = new ItemDAO();
		System.out.println(dao.getItemsBySubCategoryId(1));
	}
	public int insertItem(Item item1) {
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "insert into item(description,old_months,max_price,min_price,sold,sub_category_id,user_id,locality,city,state,image) values(?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, item1.getDescription());
			preparedStatement.setInt(2, item1.getOldMonths());
			preparedStatement.setInt(3, item1.getMaxPrice());
			preparedStatement.setInt(4, item1.getMinPrice());
			preparedStatement.setString(5, item1.getSold());
			System.out.println(item1.getSubcategory().getSubCategoryId());
			preparedStatement.setInt(6,item1.getSubcategory().getSubCategoryId());
			System.out.println(item1.getUser().getUserId());
			preparedStatement.setInt(7,item1.getUser().getUserId());
			preparedStatement.setString(8, item1.getLocality());
			preparedStatement.setString(9, item1.getCity());
			preparedStatement.setString(10, item1.getState());
			System.out.println(item1.getImage());
			preparedStatement.setString(11,item1.getImage());
			//System.out.println(DBUtility.utilToSql(item1.getDate()));
			//preparedStatement.setDate(8, DBUtility.utilToSql(item1.getDate()));
			status = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(preparedStatement);
		}		
		return status;
	}
	
	public Item getItemByItemId(int itemId)	{
		final String QUERY = "select * from item where id = ?";
		ResultSet resultSet = null;
		Item item = new Item();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, itemId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				item.setDescription(resultSet.getString(2));
				item.setOldMonths(resultSet.getInt(3));
				item.setMaxPrice(resultSet.getInt(4));
				item.setMinPrice(resultSet.getInt(5));
				item.setSold(resultSet.getString(6));
				item.setLocality(resultSet.getString(10));
				item.setCity(resultSet.getString(11));
				item.setState(resultSet.getString(12));
				item.setImage(resultSet.getString(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return item;
	}
	public int updateItem(int itemId) {
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "update item set description = ?, max_price = ?, min_price = ? where id = ?";
		Item item = new Item();
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, item.getDescription());
			preparedStatement.setInt(2, item.getMaxPrice());
			preparedStatement.setInt(3, item.getMinPrice());
			preparedStatement.setInt(4, itemId);
			status = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally	{
			 DBUtility.close(preparedStatement);
		}
		return status;
	}
	public List<Item> getAll() {
		List<Item> itemList = null;
		final String QUERY = "select * from item where sold = 'NO'";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				itemList = new ArrayList();
				do {
					Item item = new Item();
					item.setDescription(resultSet.getString(2));
					item.setOldMonths(resultSet.getInt(3));
					item.setMaxPrice(resultSet.getInt(4));
					item.setMinPrice(resultSet.getInt(5));
					item.setSold(resultSet.getString(6));
					item.setLocality(resultSet.getString(10));
					item.setCity(resultSet.getString(11));
					item.setState(resultSet.getString(12));
					item.setDate(resultSet.getDate(13));
					itemList.add(item);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return itemList;
	}
	public int deleteItem(int itemId) {
		final String QUERY = "update item set sold = 'YES' where id = ?";
		int status = 0;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, itemId);
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(preparedStatement);
		}	
		return status;		
	}
	public List<Item> getItemsByUserId(int userId)	{
		final String QUERY = "select * from item where user_id = ?";
		ResultSet resultSet = null;
		List<Item> itemList = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				itemList = new ArrayList();
				do {
					Item item = new Item();
					item.setDescription(resultSet.getString(2));
					item.setOldMonths(resultSet.getInt(3));
					item.setMaxPrice(resultSet.getInt(4));
					item.setMinPrice(resultSet.getInt(5));
					item.setSold(resultSet.getString(6));
					item.setLocality(resultSet.getString(10));
					item.setCity(resultSet.getString(11));
					item.setState(resultSet.getString(12));
					item.setDate(resultSet.getDate(13));
					itemList.add(item);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return itemList;
	}
	public List<Item> getItemsBySubCategoryId(int subCategoryId)	{
		final String QUERY = "select * from item where sub_category_id = ?";
		ResultSet resultSet = null;
		List<Item> itemList = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, subCategoryId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				itemList = new ArrayList();
				do {
					Item item = new Item();
					item.setDescription(resultSet.getString(2));
					item.setOldMonths(resultSet.getInt(3));
					item.setMaxPrice(resultSet.getInt(4));
					item.setMinPrice(resultSet.getInt(5));
					item.setSold(resultSet.getString(6));
					item.setLocality(resultSet.getString(10));
					item.setCity(resultSet.getString(11));
					item.setState(resultSet.getString(12));
					item.setDate(resultSet.getDate(13));
					itemList.add(item);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return itemList;
	}
	public int approvedItemByModeratorId() {
		final String QUERY = "update item set approved_id = ? where id = ?";
		int status = 0;
		PreparedStatement preparedStatement = null;
		Item item = new Item();
		Moderator moderator = new Moderator();
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, moderator.getModeratorId());
			preparedStatement.setInt(2, item.getItemId());
			status = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally	{
			 DBUtility.close(preparedStatement);
		}		
		return status;		
	}
	public List<Item> getApprovedItems(int approverId)	{
		final String QUERY = "select * from item where approver_id = ? and approver_id <> 'NULL'";
		ResultSet resultSet = null;
		List<Item> itemList = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, approverId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				itemList = new ArrayList();
				do {
					Item item = new Item();
					item.setDescription(resultSet.getString(2));
					item.setOldMonths(resultSet.getInt(3));
					item.setMaxPrice(resultSet.getInt(4));
					item.setMinPrice(resultSet.getInt(5));
					item.setSold(resultSet.getString(6));
					item.setLocality(resultSet.getString(10));
					item.setCity(resultSet.getString(11));
					item.setState(resultSet.getString(12));
					item.setDate(resultSet.getDate(13));
					itemList.add(item);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return itemList;
	}
	public List<Item> getNotApprovedItems()	{
		final String QUERY = "select * from item where approver_id == 'NULL'";
		ResultSet resultSet = null;
		List<Item> itemList = null;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				itemList = new ArrayList();
				do {
					Item item = new Item();
					item.setDescription(resultSet.getString(2));
					item.setOldMonths(resultSet.getInt(3));
					item.setMaxPrice(resultSet.getInt(4));
					item.setMinPrice(resultSet.getInt(5));
					item.setSold(resultSet.getString(6));
					item.setLocality(resultSet.getString(10));
					item.setCity(resultSet.getString(11));
					item.setState(resultSet.getString(12));
					item.setDate(resultSet.getDate(13));
					itemList.add(item);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return itemList;
	}
	public int insertImage() {
		int status = 0;
		PreparedStatement preparedStatement = null;
		final String QUERY = "insert into item_image(item_id,image) values(?,?)";
		Item item = new Item();
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, item.getItemId());
			preparedStatement.setString(2, item.getImage());
			status = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally	{
			 DBUtility.close(preparedStatement);
		}
		return status;
	}
	public Item getImageByItemId(int itemId)	{
		final String QUERY = "select * from item where id = ?";
		ResultSet resultSet = null;
		Item item = new Item();
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()) {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, itemId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())	{
				item.setImage(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			 DBUtility.close(resultSet,preparedStatement);
		}
		return item;
	}
	
}
