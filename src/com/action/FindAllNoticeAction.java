package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Notice;

@ParentPackage("struts2_selectCourse")
public class FindAllNoticeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Notice> notices = null;
	private String noticeContent;
    private String noticeID;
    private HttpServletRequest request;
	
	public FindAllNoticeAction() {
		request = ServletActionContext.getRequest();
	}
    
	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(String noticeID) {
		this.noticeID = noticeID;
	}

	public ArrayList<Notice> getNotices() {
		return notices;
	}

	public void setNotices(ArrayList<Notice> notices) {
		this.notices = notices;
	}
	
    //findAllNotice==homepage.action
	@Action(value = "homepage",
			results = {@Result(name = "homepage", location = "/student/homepage.jsp")}
	)
	public String execute() throws Exception {
        System.out.println("findAllNotice");
        String n = "findAllNotice";
        System.out.println(n.equals("findAllNotice"));
		this.notices = new SelectCoursesService().findAllNotice();
		return "homepage";
	}
	
	//findSpecificNotice
	@Action(value = "findSpecificNotice",
            results = {@Result(name = "success", location = "/student/noticecontent.jsp")
		}				
	)
	public String findSpecificNotice() throws Exception {
		System.out.println("findSpecificNotice");
		System.out.println(request.getParameter("id"));
		this.noticeContent = new SelectCoursesService().findSpecificNotice(request.getParameter("id"));
		this.noticeID = request.getParameter("id");
		return SUCCESS;
	}
	
	 //admin 查找所有公告
	@Action(value = "adminfindAllNots",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = {@Result(name = "success", location = "/admin/allnotices.jsp")}
	)
	public String adminFindAllNots() throws Exception {
		//request.getSession().invalidate();
        System.out.println("findAllNotice");
		this.notices = new SelectCoursesService().findAllNotice();
		return SUCCESS;
	}
	
	//admin findSpecificNotice
	@Action(value = "adminfindSpecificNotice",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") },
            results = {@Result(name = "success", location = "/admin/showspecificnotice.jsp")
		}				
	)
	public String adminFindSpecificNotice() throws Exception {
		System.out.println("findSpecificNotice");
		System.out.println(request.getParameter("id"));
		this.noticeContent = new SelectCoursesService().findSpecificNotice(request.getParameter("id"));
		this.noticeID = request.getParameter("id");
		return SUCCESS;
	}
}
