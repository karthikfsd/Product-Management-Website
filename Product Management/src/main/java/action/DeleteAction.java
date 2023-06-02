package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDAO;
import pojo.Product;

public class DeleteAction extends ActionSupport{
	
	int productId;
	
	public String execute() {

		int status = ProductDAO.deleteProduct(productId);
		if(status==1) {
			return SUCCESS;
		}else {
			return ERROR;
		}
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

}
