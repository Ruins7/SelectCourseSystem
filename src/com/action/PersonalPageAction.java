package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Conofselcou;
import com.vo.Friend;
import com.vo.Student;
import com.vo.Stumess;

@ParentPackage("struts2_selectCourse")
public class PersonalPageAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
    private Stumess sme;
    private Student person;
    private ArrayList<Conofselcou> course;
    private ArrayList<Friend> friends;
    private ArrayList<Stumess> allmessage;//留言
    private ArrayList<Stumess> allrequst;//申请回复
    private String messmessage;
    private String requestmessage;
    private String fmessage;
    private String addfriendmessage;
    private String addsuccess;
    private String coursemessage;
    private String deletemessage;
    private String leavemessage;
    private String beiID;
    private String yaoID;
    private HttpServletRequest request;
    Map<String, Object> session = ActionContext.getContext()
	.getSession();
    
    public String getBeiID() {
		return beiID;
	}

	public void setBeiID(String beiID) {
		this.beiID = beiID;
	}

	public String getYaoID() {
		return yaoID;
	}

	public void setYaoID(String yaoID) {
		this.yaoID = yaoID;
	}

	public String getLeavemessage() {
		return leavemessage;
	}

	public void setLeavemessage(String leavemessage) {
		this.leavemessage = leavemessage;
	}

	public ArrayList<Conofselcou> getCourse() {
		return course;
	}

	public void setCourse(ArrayList<Conofselcou> course) {
		this.course = course;
	}

	public String getDeletemessage() {
		return deletemessage;
	}

	public void setDeletemessage(String deletemessage) {
		this.deletemessage = deletemessage;
	}

	public String getCoursemessage() {
		return coursemessage;
	}

	public void setCoursemessage(String coursemessage) {
		this.coursemessage = coursemessage;
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public String getRequestmessage() {
		return requestmessage;
	}

	public String getAddsuccess() {
		return addsuccess;
	}

	public void setAddsuccess(String addsuccess) {
		this.addsuccess = addsuccess;
	}

	public void setRequestmessage(String requestmessage) {
		this.requestmessage = requestmessage;
	}

	public PersonalPageAction() {
		request = ServletActionContext.getRequest();
	}
    
	public ArrayList<Stumess> getAllrequst() {
		return allrequst;
	}

	public void setAllrequst(ArrayList<Stumess> allrequst) {
		this.allrequst = allrequst;
	}

	public String getAddfriendmessage() {
		return addfriendmessage;
	}

	public void setAddfriendmessage(String addfriendmessage) {
		this.addfriendmessage = addfriendmessage;
	}

	public ArrayList<Friend> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Friend> friends) {
		this.friends = friends;
	}
	public ArrayList<Stumess> getAllmessage() {
		return allmessage;
	}
	public void setAllmessage(ArrayList<Stumess> allmessage) {
		this.allmessage = allmessage;
	}
	
	public Stumess getSme() {
		return sme;
	}

	public void setSme(Stumess sme) {
		this.sme = sme;
	}

	public String getMessmessage() {
		return messmessage;
	}
	public void setMessmessage(String messmessage) {
		this.messmessage = messmessage;
	}
	public String getFmessage() {
		return fmessage;
	}
	public void setFmessage(String fmessage) {
		this.fmessage = fmessage;
	}
	
	//我的主页  查找所有好友，查找所有留言
	@Action(value = "mypage",
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", location="/student/mypage.jsp")}
	)
	public String myPage() throws Exception{
		System.out.println("myPage");
		//查找所有好友，查找所有留言
		this.allmessage = new SelectCoursesService().findAllMyMessage((String)session.get("studentID"));
		this.friends = new SelectCoursesService().findAllMyFriend((String)session.get("studentID"));
		this.allrequst = new SelectCoursesService().findAllrequest((String)session.get("studentID"));
		requestmessage = null;
		if(this.allrequst != null){	
			requestmessage = "您有新消息！";
			System.out.println(messmessage);
		}
		messmessage = null;
		if(this.allmessage == null){
			messmessage = "您暂时没有留言！";
			System.out.println(messmessage);
		}
		fmessage = null;
		if(this.friends == null){
			fmessage = "您暂时没有好友！";
			System.out.println(fmessage);
		}
		return SUCCESS;
	}
	
	//student 好友留言验证
	public void validateLeaveMessage(){
		if(this.sme.getContent().trim().equals(null) || this.sme.getContent().trim().equals("")){
			addFieldError("contentnull", "留言内容不能为空！");
		}
		
	}
	
    //student留言板 给好友留言
	@Action(value = "leavemessage",
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", type="chain",location="mypage"),
			           @Result(name = "input", location="/student/error.jsp"),
	                   @Result(name = "error",type="chain", location="mypage")}
	)
	public String leaveMessage() throws Exception{
		System.out.println("leaveMessage");
		//只要是注册用户就可以留言
		boolean boo = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(0, 4));// 年
		System.out.println(time.substring(5, 7));// 月
		System.out.println(time.substring(8, 10));// 日
		System.out.println(time.substring(11, 13));// 时
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		//messageID
		String messageid =time.substring(0, 4)+time.substring(5, 7)+time.substring(8, 10)+time.substring(11, 13)+time.substring(14, 16)+time.substring(17, 19); 
		//time
		boo = new SelectCoursesService().leaveMessage(getBeiID(), getYaoID(), messageid, time, this.sme.getContent());
		if(boo == true){
			leavemessage = "留言成功！";
		    return SUCCESS; 
		}else{
			leavemessage = "留言失败！";
		    return ERROR; 
		}
	}
	
	// 删除留言
	@Action(value = "deletemess",
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", type="chain", location="mypage"),
	                   @Result(name = "error", type="chain", location="mypage")}
	)
	public String deleteMess() throws Exception{
		System.out.println("leaveMessage");
		boolean boo = false;
		boo = new SelectCoursesService().deleteMess(request.getParameter("id"));
		if(boo == true){
			System.out.println("删除成功！");
			messmessage = "删除成功！";
			return SUCCESS;
		}else{
			System.out.println("删除失败！");
			messmessage = "删除失败！";
			return ERROR;
		}
	}
	
	// 添加好友发送请求
	@Action(value = "addfriendrequest",
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", type="chain",location="homepage"),
	                   @Result(name = "error", type="chain",location="homepage")}
	)
	public String addFriendRequest() throws Exception{
		System.out.println("addFriendRequest");
		boolean boo = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(0, 4));// 年
		System.out.println(time.substring(5, 7));// 月
		System.out.println(time.substring(8, 10));// 日
		System.out.println(time.substring(11, 13));// 时
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		//messageID
		String messageid =time.substring(0, 4)+time.substring(5, 7)+time.substring(8, 10)+time.substring(11, 13)+time.substring(14, 16)+time.substring(17, 19); 
		//fromid
		request.getParameter("id");
		//toid
		request.getParameter("id2");
		//time
		boo = new SelectCoursesService().addFriendRequest(messageid, request.getParameter("id"), request.getParameter("id2"), time);
		if(boo == true){
			System.out.println("好友申请发送成功！");
			addfriendmessage = "好友申请发送成功！";
			return SUCCESS;
		}else{
			System.out.println("好友申请发送失败！");
			addfriendmessage = "好友申请发送失败！";
			return ERROR;
		}
	}
	
	// 查看所有未读请求
	@Action(value = "checkreuqest",
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", location="/student/addfriendrequestpage.jsp")}	              
	)
	public String checkReuqest() throws Exception{
		System.out.println("checkReuqest");
		this.allrequst = new SelectCoursesService().findAllrequest((String)session.get("studentID"));
		return SUCCESS;
	}
	
	// 同意好友请求
	@Action(value = "agreetoadd",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success",type="chain", location="mypage"),	              
	                   @Result(name = "error",type="chain", location="mypage")}	              
	)
	public String agreeToAdd() throws Exception{
		System.out.println("agreeToAdd");
		boolean boo = false;
		boo = new SelectCoursesService().agreeToAdd(request.getParameter("id"));
		if(boo == true){
			addsuccess = "添加好友成功！";
			System.out.println(addsuccess);
			return SUCCESS;
		}else{
			addsuccess = "添加好友失败！";
			System.out.println(addsuccess);
			return ERROR;
		}	
	}
	
	// 拒绝好友请求
	@Action(value = "refusetoadd",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success",type="chain", location="mypage"),	              
	                   @Result(name = "error",type="chain", location="mypage")}	              
	)
	public String refuseToAdd() throws Exception{
		System.out.println("refuseToAdd");
		boolean boo = false;
		boo = new SelectCoursesService().refuseToAdd(request.getParameter("id"));
		if(boo == true){
			addsuccess = "拒绝好友成功！";
			System.out.println(addsuccess);
			return SUCCESS;
		}else{
			addsuccess = "拒绝好友失败！";
			System.out.println(addsuccess);
			return ERROR;
		}	
	}
	
	// 进入好友个人主页
	@Action(value = "gotofriendpage",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success", location="/student/friendpage.jsp")}	          	                         
	)
	public String gotoFriendPage() throws Exception{
		System.out.println("gotoFriendPage");
		//查找好友个人信息
		this.person = new SelectCoursesService().findPersonnalMessage(request.getParameter("id"));
		//查找好友留言
		this.allmessage = new SelectCoursesService().findAllMyMessage(request.getParameter("id"));
		//查找好友的好友
		this.friends = new SelectCoursesService().findAllMyFriend(request.getParameter("id"));
		//查找好友的课表
		this.course = new SelectCoursesService().findPersonnalCourse(request.getParameter("id"));
		coursemessage = null;
		if(this.allmessage != null){	
			coursemessage = "好友暂时没有课程！";
			System.out.println(coursemessage);
		}
		messmessage = null;
		if(this.allmessage == null){
			messmessage = "暂时没有留言！";
			System.out.println(messmessage);
		}
		fmessage = null;
		if(this.friends == null){
			fmessage = "暂时没有好友！";
			System.out.println(fmessage);
		}
		System.out.println("seee");
		return SUCCESS;
	}
	
	// 进入好友个人主页 删除好友
	@Action(value = "deletefriend",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success",type="chain", location="mypage"),	          	                         
                       @Result(name = "error", location="/student/friendpage.jsp")}	          	                         
	)
	public String deleteFriend() throws Exception{
		System.out.println("deleteFriend");
		boolean boo = false;
		System.out.println("被删人----"+request.getParameter("id"));
		System.out.println("要删人----"+request.getParameter("id2"));
		boo = new SelectCoursesService().deleteFriend(request.getParameter("id"), request.getParameter("id2"));
		if(boo == false){
			deletemessage = "删除好友失败！";
			return ERROR;
		}else{
			deletemessage = "删除好友成功！";
			return SUCCESS;
		}
	}

	// 留言回复 查看于某个好友的聊天记录
	@Action(value = "replymess",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success", location="/student/replymessage.jsp")}	          	                                    	          	                         
	)
	public String replyMess() throws Exception{
		System.out.println("replyMess");
		this.allmessage = new SelectCoursesService().findAllSPMyMessage((String)session.get("studentID"), request.getParameter("id"));
			return SUCCESS;
		}
	
	// 留言回复 验证
	public void validateWriteReply(){
		if(this.sme.getContent().trim().equals(null) || this.sme.getContent().trim().equals("")){
			  addFieldError("recontentnull", "留言回复不能为空！");
		}
	}
	
	// 留言回复
	@Action(value = "writereply",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success", type="chain",location="mypage"),	
			           @Result(name = "input", location="/student/error.jsp"),
	                   @Result(name = "error",type="chain", location="mypage")}	          	                                    	          	                         
	)
	public String writeReply() throws Exception{
		System.out.println("replyMess");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(0, 4));// 年
		System.out.println(time.substring(5, 7));// 月
		System.out.println(time.substring(8, 10));// 日
		System.out.println(time.substring(11, 13));// 时
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		//messageID
		String messageid = time.substring(0, 4)+time.substring(5, 7)+time.substring(8, 10)+time.substring(11, 13)+time.substring(14, 16)+time.substring(17, 19); 
		boolean boo = false;
		System.out.println(messageid);
		System.out.println(getYaoID());
		System.out.println(getBeiID());
		System.out.println(this.sme.getContent());
		boo = new SelectCoursesService().writeReply(messageid, getYaoID(), getBeiID(), time, this.sme.getContent());
	    if(boo == true){
	    	leavemessage = "回复成功！";
	    	return SUCCESS;
	    }else{
	    	leavemessage = "回复失败！";
	    	return ERROR;
	    }
		}
	
	/*// studen修改motto
	@Action(value = "writemotto",
		    interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
		    results = {@Result(name = "success", type="chain",location="mypage"),	          	                                    	          	                         
	                   @Result(name = "error",type="chain", location="mypage")}	          	                                    	          	                         
	)
	public String writeMotto() throws Exception{
		System.out.println("writeMotto");
		
		boolean boo = false;
		
		//boo = new SelectCoursesService().writeMotto();
		
	    if(boo == true){
	    	leavemessage = "回复成功！";
	    	return SUCCESS;
	    }else{
	    	leavemessage = "回复失败！";
	    	return ERROR;
	    }
		}*/
}
