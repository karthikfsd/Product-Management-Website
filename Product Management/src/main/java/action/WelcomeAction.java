package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDAO;
import pojo.Product;

public class WelcomeAction extends ActionSupport{
	
	String userName;
	List<Product> product; 
	private String productName;
	private String productCategory;
	private Date createdDate;
	
	public void initializeProducts() {
		String formattedDate = "";
				System.out.println(createdDate);
		if(createdDate!=null ) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	        formattedDate = dateFormat.format(createdDate);
		}
		System.out.println(formattedDate);
		product = ProductDAO.getAllProducts(productName,productCategory,formattedDate);
	}
	
	public String execute() {
		initializeProducts();
		return SUCCESS;
		
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
