package com.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vo.Time;

@ParentPackage("struts2_selectCourse")
public class SelectTimeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Time time;
	private String message;

	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//admin设置选课时间以及选课阶段
	@Action(value = "selecttime", 
			interceptorRefs = {
			@InterceptorRef(value="AdminLoginCheck")},
			results = { @Result(name = "error", location = "/admin/changeselectcoursetime.jsp"),
	                    @Result(name = "success", location = "/admin/changeselectcoursetime.jsp")}
	)
	public String setTimeLeve() throws Exception{
		String beginTime = time.getBy()+time.getBm()+time.getBd()+time.getBh()+time.getBmin()+time.getBs();//开始时间 
		String endTime = time.getEy()+time.getEm()+time.getEd()+time.getEh()+time.getEmin()+time.getEs();//结束时间
        String level = time.getLevel();//阶段选择
		Map<String, Object> app = ActionContext.getContext()
			.getApplication();
		 app.put("begintime", beginTime);
		 app.put("endtime", endTime);
		 app.put("level", level);
		 app.put("by", time.getBy());
		 app.put("bm", time.getBm());
		 app.put("bd", time.getBd());
		 app.put("bh", time.getBh());
		 app.put("bmin", time.getBmin());
		 app.put("bs", time.getBs());
		 app.put("ey", time.getEy());
		 app.put("em", time.getEm());
		 app.put("ed", time.getEd());
		 app.put("eh", time.getEh());
		 app.put("emin", time.getEmin());
		 app.put("es", time.getEs());
		 System.out.println(app.get("begintime"));
		 System.out.println(app.get("endtime"));
		 System.out.println(app.get("level"));
		 if(app.get("begintime") != null && app.get("endtime") != null && app.get("level") != null){
			 message = "设置成功！";
			 return SUCCESS;
		 }else{
			 message = "设置失败！";
			 return ERROR;
		 }	
	}

	//admin清除选课时间以及选课阶段
	@Action(value = "cleartime", 
			interceptorRefs = {
			@InterceptorRef(value="AdminLoginCheck")},
			results = {@Result(name = "success", location = "/admin/changeselectcoursetime.jsp")}
	)
	public String clearTime() throws Exception{
		Map<String, Object> app = ActionContext.getContext()
			.getApplication();
		app.clear();
		return SUCCESS;	
	}
}
