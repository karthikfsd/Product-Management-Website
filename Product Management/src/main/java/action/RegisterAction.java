package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDAO;
import pojo.LoginInfo;

public class RegisterAction extends ActionSupport{
	
	String userName; // when user enter data on the register screen we will bind the data here! 
	String password; 
	
	public String execute() {
		String registerCode="";
		
		int registerStatus = LoginDAO.registerUser(new LoginInfo(userName,password));
		if(registerStatus==1) {
			registerCode ="success";
		}else {
			registerCode="error";
		}
		
		return registerCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
