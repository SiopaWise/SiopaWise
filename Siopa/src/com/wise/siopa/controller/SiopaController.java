package com.wise.siopa.controller;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.wise.siopa.dao.CategoryDAO;
import com.wise.siopa.dao.ItemDAO;
import com.wise.siopa.dao.ModeratorDAO;
import com.wise.siopa.dao.SubCategoryDAO;
import com.wise.siopa.dao.UserDAO;
import com.wise.siopa.dto.Category;
import com.wise.siopa.dto.Item;
import com.wise.siopa.dto.Moderator;
import com.wise.siopa.dto.SubCategory;
import com.wise.siopa.dto.User;
import com.wise.siopa.util.DBUtility;

/**
 * Servlet implementation class SiopaController
 */
@WebServlet("/SiopaController")
@MultipartConfig(maxFileSize = 16177215)
public class SiopaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY1="category";
	private static final String UPLOAD_DIRECTORY2="subCategory";
	private static final String UPLOAD_DIRECTORY3="items";
	private static final int THRESHOLD_SIZE=1024*1024*3;
	private static final int MAX_FILE_SIZE=1024*1024*40;
	private static final int MAX_REQUEST_SIZE=1024*1024*50;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiopaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.sendRedirect("./welcome.jsp");
		String action = request.getParameter("action");
		if(action == null){
			response.sendRedirect("./home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hai");
		List<Category> categoryList = null;
		List<SubCategory> subcategoryList = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			System.out.println("jhfjehagfh");
			imageUploader(request).forward(request,response);
		}
		String action = request.getParameter("action");
		if(action.equals("RegisteredUser"))	{
			registerAsUser(request).forward(request,response);
		}
		if(action.equals("LoginUser"))	{
			loginAsUser(request).forward(request,response);
		}
		if(action.equals("ModeratorUser"))	{
			loginAsModerator(request).forward(request,response);
		}
	
		if(action.equals("button1"))	{
			System.out.println("hello");
			CategoryDAO categorydao = new CategoryDAO();
			categoryList = categorydao.getAll();
			request.setAttribute("categoryList", categoryList);
			//System.out.println(categoryList);
			redirectPage(request).forward(request,response);
		}
		if(action.equals("button2"))	{
			System.out.println("hello");
			SubCategoryDAO subcategorydao = new SubCategoryDAO();
			subcategoryList = subcategorydao.getAll();
			request.setAttribute("subcategoryList", subcategoryList);
			System.out.println(subcategoryList);
			redirectPage(request).forward(request,response);
		}
		if(action.equals("xyz"))	{
			ItemDAO itemdao = new ItemDAO();
			List<Item> itemList = new ArrayList();
			itemList = itemdao.getAll();
			System.out.println(itemList);
			request.setAttribute("itemList", itemList);
			redirect(request).forward(request,response);
		}
		
		
	}
	private RequestDispatcher redirectPage(HttpServletRequest request) {
		System.out.println("hy");
		
		return request.getRequestDispatcher("./moderatorLogin.jsp");
	}
	private RequestDispatcher redirect(HttpServletRequest request) {
		System.out.println("hy");
		
		return request.getRequestDispatcher("./userPanel.jsp");
	}
	private RequestDispatcher getCategoryImages(HttpServletRequest request) {
		System.out.println("Hai123456");
		CategoryDAO categoryDao = new CategoryDAO();
		List<Category> categoryList = new ArrayList();
		categoryList = categoryDao.getAll();
		request.setAttribute("categoryList", categoryList);
		System.out.println(categoryList);
		return request.getRequestDispatcher("./moderatorLogin.jsp");
	}
	private RequestDispatcher registerAsUser(HttpServletRequest request) {
		int status = 0;
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String phoneNum = request.getParameter("phoneNum");
		String dob = request.getParameter("dob");
		User user = new User();
		user.setUserName(userName);
		user.setUserEmailId(email);
		user.setPassword(pwd);
		user.setUserPhoneNumber(Long.parseLong(phoneNum));
		user.setDateOfBirth(DBUtility.StringToUtil(dob));
		UserDAO userDao = new UserDAO();
		status = userDao.insertUser(user);
		return request.getRequestDispatcher("./home.jsp");
	}
	private RequestDispatcher loginAsUser(HttpServletRequest request) {
		String email = request.getParameter("emailid");
		String pwd = request.getParameter("password");
		User user = new User();
		UserDAO userDao = new UserDAO();
		user = userDao.getUserByEmailId(email);
		if((email != null) && (pwd != null) && (user.getPassword().equals(pwd)))	{
			HttpSession session1 = request.getSession();
			session1.setAttribute("userid", user.getUserId());
			return request.getRequestDispatcher("./userPanel.jsp");
		}
		else	{
			request.setAttribute("userLoginStatus", "Invalid Email ID or Password..!");
			
		}
		return request.getRequestDispatcher("./home.jsp");
	}
	private RequestDispatcher loginAsModerator(HttpServletRequest request) {
		String email = request.getParameter("emailid");
		String pwd = request.getParameter("password");
		Moderator moderator = new Moderator();
		ModeratorDAO moderatorDao = new ModeratorDAO();
		moderator = moderatorDao.getModeratorByEmailId(email);
		if((email != null) & (pwd != null) & (moderator.getPassword().equals(pwd)))	{
			HttpSession session = request.getSession();
			session.setAttribute("id", moderator.getModeratorId());
			return request.getRequestDispatcher("./moderatorLogin.jsp");

			//return request.getRequestDispatcher("./dummy.jsp");
		}
		else	{
			request.setAttribute("ModeratorLoginStatus", "Invalid Email ID or Password..!");
			
		}
		return request.getRequestDispatcher("./home.jsp");
	}
	private RequestDispatcher imageUploader(HttpServletRequest request)	{
		System.out.println("In image Uploader method");
	       try	{
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(THRESHOLD_SIZE);
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
				ServletFileUpload upload = new ServletFileUpload(factory);
			    upload.setFileSizeMax(MAX_FILE_SIZE);
			    upload.setSizeMax(MAX_REQUEST_SIZE);
				List<FileItem>  items = upload.parseRequest(request);
			    System.out.println(items);
			    int subId = 0;
			    String uploadDirectory = null;
			    String catName = null;
			    String description = null;
			    String oldMonths = null;
			    String maxPrice = null;
			    String minPrice = null;
			    String date = null;
			    String sold = null;
			    String locality = null;
			    String city = null;
			    String state = null;
			    String country = null;
			    String subCatName = null;
			    String action = null;
			    String categoryName = null;
			    String itemSubCategoryName = null;
			    for(FileItem item :items){
			        if(item.isFormField())	{
			        	if(item.getFieldName().equals("action"))	{
			        		action = item.getString();
			        		System.out.println(action);
			        		if(action.equals("category"))	{
			        			System.out.println(action);
			        			uploadDirectory = "category";
			        		}
			        		if(action.equals("subCategory"))	{
			        			System.out.println(action);
			        			uploadDirectory = "subCategory";
			        		}	
			        		if(action.equals("itemInput"))	{
			        			System.out.println(action);
			        			uploadDirectory = "items";
			        		}	

			        	}
			        	System.out.println(item.getFieldName());
			        	if(item.getFieldName().equals("catName"))	{
			        		catName = item.getString();
			        		System.out.println(catName);	        		
			        	}
			        	if(item.getFieldName().equals("subCatName"))	{
			        		subCatName = item.getString();
			        		System.out.println(subCatName);	        		
			        	}
			        	if(item.getFieldName().equals("categoryName"))	{			        		
			        		categoryName = item.getString();
			        		System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("description"))	{			        		
			        		description = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("state"))	{			        		
			        		state = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("oldMonths"))	{			        		
			        		oldMonths = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("maxPrice"))	{			        		
			        		maxPrice = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("minPrice"))	{			        		
			        		minPrice = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	
			        	if(item.getFieldName().equals("sold"))	{			        		
			        		sold = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("locality"))	{			        		
			        		locality = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("city"))	{			        		
			        		city = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("country"))	{			        		
			        		country = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        	if(item.getFieldName().equals("itemSubCategoryName"))	{			        		
			        		itemSubCategoryName = item.getString();
			        		//System.out.println("Category Name" + categoryName);	        		
			        	}
			        }
			    }
			    for(FileItem item:items){
			        if(!item.isFormField())	{
			        	String uploadFolder = getServletContext().getInitParameter("imageupload") +File.separator+uploadDirectory;
			        	System.out.println(uploadFolder);
					    File uploadDir=new File(uploadFolder);

					    if(!uploadDir.exists()){
					    	uploadDir.mkdir();
					    }
			        	String fileName = new File(item.getName()).getName();
			        	String filePath = uploadFolder + File.separator + fileName;
			        	
	                    File uploadedFile = new File(filePath);	                    
	                    item.write(uploadedFile);
	                    System.out.println(filePath);
	                    HttpSession session = request.getSession(false);
	                    HttpSession session1 = request.getSession(false);
	                    if (session1 != null) {
	                    	System.out.println("session");
	            			if (session1.getAttribute("userid") != null) {
	            				System.out.println("userid");
	            				if(action.equals("itemInput")) {
	            					System.out.println("item.....Input");
	            					ItemDAO itemdao = new ItemDAO();
	            					Item item1 = new Item();
	            					item1.setDescription(description);
	            					item1.setOldMonths(Integer.parseInt(oldMonths));
	            					item1.setMaxPrice(Integer.parseInt(maxPrice));
	            					item1.setMinPrice(Integer.parseInt(minPrice));
	            					item1.setCity(city);
	            					item1.setLocality(locality);
	            					item1.setState(state);
	            					item1.setSold(sold);
	            					item1.setCountry(country);
	            					item1.setImage(item.getName());
	            					//item1.setDate(date);
	            					SubCategory subCategory = new SubCategory();
	            					SubCategoryDAO subCategoryDao = new SubCategoryDAO();
	            					List<SubCategory> subCategoryList = new ArrayList();
	            					subCategoryList = subCategoryDao.getAll();
	            					for(SubCategory subCategory1 :subCategoryList)	{
	            						if(itemSubCategoryName.equals(subCategory1.getSubCategoryName()))	{
	            							subId = subCategory1.getSubCategoryId();
	            							System.out.println(subId);
	            						}
	            					}
	            					subCategory.setSubCategoryId(subId);
	            					item1.setSubcategory(subCategory);
	            					User user = new User();
	            					user.setUserId((int) session1.getAttribute("userid"));
	            					item1.setUser(user);
	            					System.out.println(item1);
	            					itemdao.insertItem(item1);
	            					
	            				}
	            			}
	                    }
	                    if (session != null) {
	            			if (session.getAttribute("id") != null) {
	            				if(action.equals("category"))	{
	            					Category category = new Category();
		            				CategoryDAO categoryDAO = new CategoryDAO();
		            				category.setCategoryName(catName);
		            				System.out.println(catName);
		            				category.setLogo(item.getName());
		            				System.out.println(item.getName());
		            				Moderator moderator = new Moderator();
		            				moderator.setModeratorId((int) session.getAttribute("id"));
		            				System.out.println(moderator);
		            				category.setModerator(moderator);
		            				System.out.println(category);
		            				categoryDAO.insert(category);		            				
		            				
		            				
	            				}
	            				if(action.equals("subCategory"))	{
	            					SubCategory subCategory = new SubCategory();
	            					SubCategoryDAO subCategoryDao = new SubCategoryDAO();
	            					subCategory.setSubCategoryName(subCatName);
	            					System.out.println(subCatName);
	            					subCategory.setImage(item.getName());
	            					System.out.println(item.getName());
	            					Moderator moderator = new Moderator();
		            				moderator.setModeratorId((int) session.getAttribute("id"));
		            				System.out.println(moderator);
		            				subCategory.setModerator(moderator);
		            				Category category = new Category();
		            				CategoryDAO categorydao = new CategoryDAO();
		            				System.out.println(categoryName);
		            				category = categorydao.getCategoryByCategoryName(categoryName);
		            				System.out.println(category);
		            				subCategory.setCategory(category);
		            				subCategoryDao.insert(subCategory);		            				
	            					
	            					
	            					
	            				}
	            				 
	            			} 
	                    }
			        }
			    }
			    
			} catch(Exception e)	{
				e.printStackTrace();
			}
	       
	       return request.getRequestDispatcher("./moderatorLogin.jsp");
	

	       }
}
