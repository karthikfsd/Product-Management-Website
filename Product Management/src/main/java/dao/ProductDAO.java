package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.Product;

public class ProductDAO {
	
	public static List<Product> getAllProducts(String productName, String productCategory, String createdDate){
		
		List<Product> listProduct = new ArrayList<Product>();
		String whereClauseCond = "";
		
		if((productName == null || productName.equals("")) && (productCategory == null || productCategory.equals("")) && (createdDate == null || createdDate.equals(""))){
			whereClauseCond="";
		}
		else {
			whereClauseCond=" WHERE ";
		}
		
		int count=0;
		
		if(productName!=null && !productName.equals("")) {
			count ++;
				if(count!=1) {
				whereClauseCond +=" AND ";
				}
			whereClauseCond += "product_name = "+"'"+productName+"'";
		}
		
		if(productCategory!=null && !productCategory.equals("")) {
			count ++;
				if(count!=1) {
				whereClauseCond +=" AND ";
				}
			whereClauseCond += "product_category = "+"'"+productCategory+"'";
		}
		System.out.println("Created Date in productDAO: "+createdDate);
		
		if(createdDate!=null && !createdDate.equals("")) {
			count ++;
				if(count!=1) {
				whereClauseCond +=" AND ";
				}
			whereClauseCond += "created_date = "+"'"+createdDate+"'";
		}
		
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * from product "+whereClauseCond+ " order by product_id asc");
			
			while(rs.next()) {
				listProduct.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getString("product_category"),rs.getInt("product_price"),rs.getString("created_date")));
			}
			
			rs.close();
			st.close();
			DBUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}
	
	public static int addProduct(Product product) {
		int rows=0;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO product values(?,?,?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			ps.setString(5, product.getCreatedDate());
			rows=ps.executeUpdate();
			
			ps.close();
			DBUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public static Product getProductbyId(int productId) {
		
		Product product = null;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM product where PRODUCT_ID = ?");
			preparedStatement.setInt(1, productId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getString("product_category"),rs.getInt("product_price"),rs.getString("created_date"));
			}
			
			rs.close();
			preparedStatement.close();
			DBUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	public static int updateProduct(Product product) {
		int index=0;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("UPDATE product set product_name=?, product_category=?, product_price=? where product_id = ?");
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getProductCategory());
			preparedStatement.setInt(3, product.getProductPrice());
			preparedStatement.setInt(4, product.getProductId());
			index = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			DBUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return index;
	}
	
	public static int deleteProduct(int productId) {
		int index=0;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM product where PRODUCT_ID = ?");
			preparedStatement.setInt(1, productId);
			index = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			DBUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return index;
	}

}
