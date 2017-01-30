package com.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SelectTimeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private String notInTime;
	private String remessage;

    
	public String getNotInTime() {
		return notInTime;
	}


	public void setNotInTime(String notInTime) {
		this.notInTime = notInTime;
	}


	public String getRemessage() {
		return remessage;
	}


	public void setRemessage(String remessage) {
		this.remessage = remessage;
	}


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("student已进入选课时间段拦截器");
		ActionContext ctx = invocation.getInvocationContext();
		// 获得admin设置的选课时间段以及阶段
		String btime = (String) ctx.getApplication().get("begintime");
		String etime = (String) ctx.getApplication().get("endtime");
		// String level = (String) ctx.getApplication().get("level");
		System.out.println(btime + "   " + etime);
		if (btime == null || etime == null) { // 没有设置选课时间
			System.out.println("没有设置选课时间！");
			notInTime = "当前不是选课时间！不能进行选课！(已拦截)";
			return "NotTime2";
		} else {
			System.out.println("当前阶段选课时间为：" + btime + " 到 " + etime);
			long adminbtime = Long.parseLong(btime);
			long adminetime = Long.parseLong(etime);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// 获得当前系统时间
			String time = sdf.format(new Date());// 转换为String
			System.out.println("当前时间为：" + time);
			long stutime = Long.parseLong(time);

			System.out.println(stutime - adminetime < 0);
			System.out.println(stutime - adminbtime > 0);
			if (stutime - adminetime < 0 && stutime - adminbtime > 0) {// 在选课时间段内
				System.out.println("在选课时间内，继续执行。。。");
				return invocation.invoke();// 继续执行
			} else {
				((ActionSupport) invocation.getAction())
						.addActionError("当前不是选课时间！不能进行选课！");
				System.out.println("选课时间已拦截");
				notInTime = "当前不是选课时间！不能进行选课！(已拦截)";
				remessage = "当前不是选课时间！不能进行选课！(已拦截)";
				return "NotTime";
			}
		}
	}
}
