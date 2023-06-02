package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.ProductDAO;
import pojo.Product;

public class AddAction {
	
	Integer productId;
	String productName;
	String productCategory;
	Integer productPrice;
	
	public String execute() {
		String statusCode="";
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = dateFormat.format(new Date());
		Product product = new Product(productId, productName, productCategory, productPrice,formattedDate);
		int recordAdd = ProductDAO.addProduct(product);
		
		if(recordAdd==1) {
			statusCode="success";
		}else {
			statusCode="error";
		}
		
		return statusCode;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
