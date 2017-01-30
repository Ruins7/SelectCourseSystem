package com.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Department;
import com.vo.Major;
import com.vo.Student;

@ParentPackage("struts2_selectCourse")
public class SigninAction extends ActionSupport{
    
	private static final long serialVersionUID = 1L;
		private Student stu;
		private String sid;
		private ArrayList<Department> dep;
		private ArrayList<Major> maj;
		private String haveBeenSign;
		private String message;
		private String repassword;
		private HttpServletRequest request;
		Map<String, Object> session = ActionContext.getContext()
		.getSession();
		private File upfile;//2进制的文件流
		//注意:在进行文件上传的操作中,有两个属性是默认自动上传的
		// 2进制的名称+固定的后缀---- 命名是有固定要求的
		private String upfileFileName;//上传的文件文件名 真实文件名
		private String upfileContentType;//文件的类型
		private String savepath="\\uploadFile";//创建一个保存文件的路径
		
		public String getRepassword() {
			return repassword;
		}
		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public File getUpfile() {
			return upfile;
		}
		public void setUpfile(File upfile) {
			this.upfile = upfile;
		}
		public String getUpfileFileName() {
			return upfileFileName;
		}
		public void setUpfileFileName(String upfileFileName) {
			this.upfileFileName = upfileFileName;
		}
		public String getUpfileContentType() {
			return upfileContentType;
		}
		public void setUpfileContentType(String upfileContentType) {
			this.upfileContentType = upfileContentType;
		}
		public String getSavepath() {
			return savepath;
		}
		public void setSavepath(String savepath) {
			this.savepath = savepath;
		}
		public SigninAction() {
			request = ServletActionContext.getRequest();
		}
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getHaveBeenSign() {
			return haveBeenSign;
		}
		public void setHaveBeenSign(String haveBeenSign) {
			this.haveBeenSign = haveBeenSign;
		}
		public ArrayList<Department> getDep() {
			return dep;
		}
		public void setDep(ArrayList<Department> dep) {
			this.dep = dep;
		}
		public ArrayList<Major> getMaj() {
			return maj;
		}
		public void setMaj(ArrayList<Major> maj) {
			this.maj = maj;
		}
		public Student getStu() {
			return stu;
		}
		public void setStu(Student stu) {
			this.stu = stu;
		}
		
		//student注册密码验证
		public void validateSignin(){
			if(!this.stu.getPassword().equals(repassword) || repassword.trim().equals(null)){
				addFieldError("repassword", "两次输入密码不一致！请重新输入！");
			}
		}
		
		//学生注册
		@Action(value = "signin", 
				results = {  
				            @Result(name = "error", location = "/student/error.jsp"),
		                    @Result(name = "success", type="chain", location="login"),
		                    @Result(name = "input", location="/student/error.jsp")}
		)
		public String signin() throws Exception {
			boolean sign = new SelectCoursesService().Signin(this.stu);
			if(sign == true){
			//注册成功，studentID和password直接会在当前student对象中，所以可以直接在登陆中使用	
				 return SUCCESS;
			}else{
				haveBeenSign = "该学号已经注册！";
				System.out.println(haveBeenSign);
				return ERROR;
			}
        }
		
		//查找学院和专业findDepMaj
		@Action(value = "findDepMaj", 
				results = {@Result(name = "success", location = "/student/signin.jsp"),
		                   @Result(name = "error", location = "/student/error.jsp")}
		)
        public String findDep() throws Exception {
        	this.dep = new SelectCoursesService().findALLDep();
        	this.maj = new SelectCoursesService().findALLMaj();
        	if(this.dep == null || this.maj == null){
    			System.out.println("101010101010");
    			haveBeenSign = "没有学院或者专业的信息，请联系管理员！！";
    			return ERROR;
    		}
    		return SUCCESS;
        }
		
		//学生修改个人信息前查找学院和专业
		@Action(value = "findDepMajForUp", 
				interceptorRefs = {
				@InterceptorRef(value="LoginCheck")},
				results = {@Result(name = "success", location = "/student/updatestuinfor.jsp")}
		)
		public String findDepMajForUp() throws Exception {
			this.sid = request.getParameter("id");//获取该学生的ID
			this.dep = new SelectCoursesService().findALLDep();
			this.maj = new SelectCoursesService().findALLMaj();
			return SUCCESS;
		}
		
		//admin添加培养方案时查找专业
		@Action(value = "findDepMajForAdmin", 
				interceptorRefs = {
				@InterceptorRef(value="AdminLoginCheck")},
				results = {@Result(name = "success", location = "/admin/addplan.jsp"),
		                   @Result(name = "error", location = "/admin/allplans.jsp")}
		)
		public String findDepForAdmin() throws Exception {
			this.maj = new SelectCoursesService().findALLMaj();
			if(this.maj == null ){
				haveBeenSign = "没有必要的专业信息，无法添加培养方案！";
				return ERROR;
			}
			return SUCCESS;
		}
		
		//学生修改个人信息
		@Action(value = "updatestudent", 
				interceptorRefs = {
				@InterceptorRef(value="LoginCheck")},
				results = { 
				 @Result(name = "error", location = "/student/updatestuinfor.jsp"),
		         @Result(name = "success", type="chain", location="homepage"),
		         @Result(name = "input", location = "/student/error.jsp")}
		)
		public String updatestudent() throws Exception {
			boolean boo = false; 
			boo = new SelectCoursesService().updateStudent(this.stu);
			if(boo == true){	
				haveBeenSign = "修改成功!";
				 return SUCCESS;
			}else{
				haveBeenSign = "信息修改失败！";
				System.out.println(haveBeenSign);
				return ERROR;
			}
        }
		
		//学生上传个人头像
		@Action(value = "fileupload", 
				interceptorRefs = {
				@InterceptorRef(value="LoginCheck")},
				results = { @Result(name = "error", type = "chain", location = "homepage"),
		                    @Result(name = "success", type = "chain", location="homepage")}
		)
		public String fileUpLoad() throws Exception {
			
			System.out.println(this.stu.getStudentID());
			//获取web服务器上的物理路径
			ServletContext sctx =ServletActionContext.getServletContext();
			//获取指定文件保存路径
			String abspath=sctx.getRealPath(savepath); //文件夹的绝对物理路径
			System.out.println(abspath);
			//对于第一次上传,判断文件夹是否存在
			File saveDir=new File(abspath);
			if(!saveDir.exists()){
				saveDir.mkdir();
			}
			
			//获取上传的文件名的属性
			String ext=upfileFileName.substring(upfileFileName.indexOf("."));//获取后缀
			//考虑的原因:必须避免重复文件名的出现
			
			//String saveName=System.currentTimeMillis()+ext;
			String saveName=UUID.randomUUID()+ext; //物理文件名
			
			//可以进行数据库的操作 
			//进行文件的上传
			saveUpfile(abspath+"\\"+saveName);
			//保存提交文件的信息
			
		    boolean boo = false;
		    boo = new SelectCoursesService().upLoadImg(this.stu.getStudentID(), abspath+"\\"+saveName);
			if(boo == true){
				session.put("photo", abspath+"\\"+saveName );
				System.out.println("数据库前："+session.get("photo"));
				message = "头像上传成功！";
				return SUCCESS;	
			}else{
				message = "上传失败！";
				return ERROR;
			}
		    
        }
		
		private void saveUpfile(String string) throws Exception {
			//创建文件
			File file=new File(string);
			//保存使用输出流
			FileOutputStream fos=new FileOutputStream(file);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
		
			
			//创建一个和页面相关的输入流
			FileInputStream fin=new FileInputStream(upfile);
			BufferedInputStream bin=new BufferedInputStream(fin);
			
			//fin.available();//占用的字节数
			
			
			//借助于字节数组
			byte[] bs=new byte[1024];
			int len=-1;
			while((len=bin.read(bs))!=-1){
				bos.write(bs, 0, len);
			}
			bin.close();
			bos.close();
			fin.close();
			fos.close();
			
		}

		
		
		
		
}
