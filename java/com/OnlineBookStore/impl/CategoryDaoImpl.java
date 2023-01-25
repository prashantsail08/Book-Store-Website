//package com.OnlineBookStore.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.OnlineBookStore.Models.Book;
//import com.OnlineBookStore.Models.Category;
//import com.OnlineBookStore.Util.Constant;
//import com.OnlineBookStore.Util.Dbutil;
//import com.OnlineBookStore.dao.CategoryDao;
//
//public class CategoryDaoImpl implements CategoryDao{
//
//	@Override
//	public boolean addCategory(Category c) {
//		try {
//			Connection con=Dbutil.getDbConnection();
//
//			PreparedStatement ps= con.prepareStatement("INSERT INTO "+Constant.DBCONSTANT.get(Constant.CATEGORY_TABLE)+"(categoryName) values(?)");
//			ps.setString(1, c.getCategoryName());
//			
//
//			int x=ps.executeUpdate();
//			if(x != 0) {
//				return true;
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	
//	}
//
//	@Override
//	public List<Category> getBookByCategory(String categoryName) {
//		try {
//			Connection con=Dbutil.getDbConnection();
//
//			PreparedStatement ps= con.prepareStatement("SELECT * FROM "+Constant.DBCONSTANT.get(Constant.CATEGORY_TABLE)+" where categoryName=?");
//			ps.setString(1, categoryName);
//			ResultSet rs =ps.executeQuery();
//			
//			List<Category> categories = new ArrayList<>(); 
//			
//			while(rs.next()) {
//				Category category = new Category();
//				category.setCategoryName(rs.getString("categoryName"));
//				categories.add(category);
//			}
//			return categories;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}
//	
//
//}
