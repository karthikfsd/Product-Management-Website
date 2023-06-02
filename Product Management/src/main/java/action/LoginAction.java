package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDAO;
import pojo.LoginInfo;

public class LoginAction extends ActionSupport{
	
	String userName; // when user enter data on the screen we will bind the data here! 
	String password;
	
	
	public String execute() {
		String statusCode="";
		
		boolean validStatus = LoginDAO.isUserValid(new LoginInfo(userName, password));
		ServletActionContext.getRequest().getSession().setAttribute("LoggedInUser", userName);
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a");
        String formattedDateTime = dateFormat.format(new Date());
		ServletActionContext.getRequest().getSession().setAttribute("now", formattedDateTime);
		if(validStatus) {
			statusCode="success";
		}else {
			statusCode="input";
		}
		
		return statusCode;
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
