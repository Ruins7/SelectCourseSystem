package com.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
    private String noLogin;
    
	public String getNoLogin() {
		return noLogin;
	}

	public void setNoLogin(String noLogin) {
		this.noLogin = noLogin;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("已进入login拦截器");
		ActionContext ctx = invocation.getInvocationContext();
		String sid = (String) ctx.getSession().get("studentID");
		
		if(sid != null){
			return invocation.invoke();//继续执行
		}
		((ActionSupport)invocation.getAction()).addActionError("您还木有登陆！");
		System.out.println("已拦截");
		noLogin = "您还木有登陆！(已拦截)";
		return "needToLogin";
	}
}
