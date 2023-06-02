package interceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import action.LoginAction;

public class LoginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		System.out.println("Destroy method called");
		
	}

	@Override
	public void init() {
		System.out.println("Init method called");
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		Object user = ServletActionContext.getRequest().getSession().getAttribute("LoggedInUser");
		if(user==null) {
			if(ai.getAction().getClass().equals(LoginAction.class)){
				return ai.invoke();
			}

			return "input";
		}
		return ai.invoke();
	}

}
