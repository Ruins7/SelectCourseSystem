package com.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Conofselcou;

@ParentPackage("struts2_selectCourse")
public class AdminCalConseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
    private ArrayList<Conofselcou> cons;//将ArrayList<ArrayList<Conofselcou>>合为总的ArrayList<Conofselcou>
    private ArrayList<ArrayList<Conofselcou>> consequence;
    private String message;
    
	public ArrayList<Conofselcou> getCons() {
		return cons;
	}

	public void setCons(ArrayList<Conofselcou> cons) {
		this.cons = cons;
	}

	public ArrayList<ArrayList<Conofselcou>> getConsequence() {
		return consequence;
	}

	public void setConsequence(ArrayList<ArrayList<Conofselcou>> consequence) {
		this.consequence = consequence;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//admin是否登陆
	@Action(value = "checkAdminLogintwo",
			interceptorRefs = {
			@InterceptorRef(value="AdminLoginCheck")},
			results = {@Result(name = "success", location="/admin/chargeselectconse.jsp"),
	                   @Result(name = "error", location="/admin/chargeselectconse.jsp")}
	)
	public String checkAdminLogintwo() throws Exception{
		//查询当前所有选课记录
		this.cons = new SelectCoursesService().findAllConse();
		System.out.println("admin已登录");
		if(this.cons == null){
			message = "当前没有任课选课记录！";
			return ERROR;
		}
		return SUCCESS;	
	}
	
	//admin 计算第一阶段结束后中选名单(按选课时间)
	@Action(value = "bytime",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") },
			results = {
			@Result(name = "success", location = "/admin/chargeselectconse.jsp"),
			@Result(name = "error", location = "/admin/chargeselectconse.jsp") }
	)
	public String byTime() throws Exception{
		System.out.println("byTime");
		this.consequence = new SelectCoursesService().byTime();
		/*for(int i = 0;i<consequence.size();i++){
			System.out.println("consequence的size:-----"+consequence.size());
			for(int j = 0;j<consequence.get(i).size();j++){
				System.out.println("第"+i+"个arraylist的第"+j+"个小list"+consequence.get(i).get(j).getCourseID()+"学生id--"+consequence.get(i).get(j).getStudentID());
			}	
		}*/
		ArrayList<Conofselcou> middle = new ArrayList<Conofselcou>();
		
		if(this.consequence == null){//没有选课记录
			message = "当前没有任何选课记录！";
			return ERROR;
		}else{
			for(int i = 0; i < consequence.size(); i++){//有几门课程
				System.out.println(consequence.size());
			      for(int j = 0;j < consequence.get(i).size(); j++){
			    	  System.out.println(consequence.get(i).size());
			    	  System.out.println(consequence.get(i).get(j));
			    	  middle.add(consequence.get(i).get(j));
			   }	   
			}
			setCons(middle);						
			return SUCCESS;
		}	
	}
	
	//admin 计算第一阶段结束后中选名单(随机)
	@Action(value = "byrandom",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") },
			results = {
			@Result(name = "success",type = "chain", location = "checkAdminLogintwo"),
			@Result(name = "error",type = "chain", location = "checkAdminLogintwo") }
	)
	public String byRandom() throws Exception{
		System.out.println("byRandom");
		boolean boo = false;
		boo = new SelectCoursesService().byRandom();
		if(boo == true){
			return SUCCESS;
		}else{
			return ERROR;		
		}
	}
	
	
}
