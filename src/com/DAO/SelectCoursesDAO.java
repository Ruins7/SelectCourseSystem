package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.IDAO.ISelectCoursesDAO;
import com.vo.Conofselcou;
import com.vo.Course;
import com.vo.Department;
import com.vo.Friend;
import com.vo.Major;
import com.vo.Notice;
import com.vo.Plan;
import com.vo.Student;
import com.vo.Stumess;
import com.vo.Suggestion;
import com.vo.Teacher;

public class SelectCoursesDAO implements ISelectCoursesDAO {

	private Connection connection;

	// 连接数据库
	public SelectCoursesDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/selectcoursesystem", "root",
					"123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查询所有公告
	public ArrayList<Notice> findAllNotice() {
		ArrayList<Notice> list = new ArrayList<Notice>();
		String sql = "select * from notice order by noticeID Desc";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Notice n = new Notice(rs.getString(1), rs.getString(2), rs
							.getString(3), rs.getString(4), rs.getString(5), rs
							.getString(6));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return list;
	}

	// 查询某一个公告的具体信息
	public String findSpecificNotice(String noticeID) {
		String content = null;
		String sql = "select content from notice where noticeID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, noticeID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					content = rs.getString(1);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return content;
	}

	// 查询所有课程
	public ArrayList<Course> findAllCourses() {
		System.out.println("selectALLCourse");
		ArrayList<Course> list = new ArrayList<Course>();
		String sql = "select * from course";
		String boo = "1";
		try {
			System.out.println("++++++++++++");
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				System.out.println("-------------");
				while (rs.next()) {
					boo = "2";
					Course n = new Course(rs.getString(1), rs.getString(2), rs
							.getShort(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getString(9), rs.getString(10), rs.getString(11),
							rs.getString(12), rs.getString(13), rs
									.getString(14), rs.getString(15), rs
									.getShort(16), rs.getString(17), rs
									.getString(18), rs.getString(19), rs
									.getString(20), rs.getString(21));
					list.add(n);
					System.out.println("0101**********");
				}
				rs.close();
				ps.close();
				connection.close();

			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// 主页检索之课程
	public ArrayList<Course> homepageQueryCourse(String querycontent) {
		System.out.println("homepageQueryCourse");
		System.out.println(querycontent);
		ArrayList<Course> list = new ArrayList<Course>();
		String boo = "1";
		String sql = "select * from course where courseName like ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, "%" + querycontent + "%");// 模糊查询
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Course n = new Course(rs.getString(1), rs.getString(2), rs
							.getShort(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getString(9), rs.getString(10), rs.getString(11),
							rs.getString(12), rs.getString(13), rs
									.getString(14), rs.getString(15), rs
									.getShort(16), rs.getString(17), rs
									.getString(18), rs.getString(19), rs
									.getString(20), rs.getString(21));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();

			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// 主页检索之学生
	public ArrayList<Student> homepageQueryStudent(String querycontent) {
		System.out.println("homepageQueryStudent");
		ArrayList<Student> list = new ArrayList<Student>();
		String boo = "1";
		String sql = "select * from student where studentName like ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, "%" + querycontent + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Student n = new Student(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs
									.getString(13), rs.getString(14), rs
									.getString(15), rs.getDate(16), rs
									.getString(17), rs.getString(18), rs
									.getString(19), rs.getString(20));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// 主页检索之教师
	public ArrayList<Teacher> homepageQueryTeacher(String querycontent) {
		System.out.println("homepageQueryTeacher");
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String boo = "1";
		String sql = "select * from teacher where teacherName like ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, "%" + querycontent + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Teacher n = new Teacher(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.out.println("出错拉");
			e.printStackTrace();

		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// 查询所有学院
	public ArrayList<Department> findALLDep() {
		System.out.println("selectALLDepartment");
		ArrayList<Department> list = new ArrayList<Department>();
		String sql = "select * from department";
		String boo = "1";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Department n = new Department(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// 查询所有专业
	public ArrayList<Major> findALLMaj() {
		System.out.println("selectALLMajor");
		ArrayList<Major> list = new ArrayList<Major>();
		String boo = "1";
		String sql = "select * from major";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Major n = new Major(rs.getString(1), rs.getString(2), rs
							.getString(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// 学生注册
	public boolean Signin(Student stu) {
		System.out.println("signin");
		String sid = stu.getStudentID();
		String sname = null;
		String sql = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, sid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					sname = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sname == null) {// 未注册
			System.out.println("未注册");
			String dep = stu.getDepID();
			String maj = stu.getMajID();
			stu.getBirthday();
			String depname = null;
			String majname = null;
			String sql1 = "select depName from department where depID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setString(1, dep);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String name = rs.getString(1);
						depname = name;
					}
					rs.close();
					ps.close();
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String sql2 = "select majorName from major where majID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql2);
					ps.setString(1, maj);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String name = rs.getString(1);
						majname = name;
					}
					rs.close();
					ps.close();
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StringBuffer sql3 = new StringBuffer();
			sql3.append("insert into student(studentID,password,studentName,"
					+ "sex,department,depID,major,majID,yearEnter,"
					+ "classes,direction,qq,stuTeleNum,stuEmail,"
					+ "idCardNum,birthday,eduLevel)");
			sql3.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql3
							.toString());
					ps.setString(1, stu.getStudentID());
					ps.setString(2, stu.getPassword());
					ps.setString(3, stu.getStudentName());
					ps.setString(4, stu.getSex());
					ps.setString(5, depname);
					ps.setString(6, stu.getDepID());
					ps.setString(7, majname);
					ps.setString(8, stu.getMajID());
					ps.setString(9, stu.getYearEnter());
					ps.setString(10, stu.getClasses());
					ps.setString(11, stu.getDirection());
					ps.setString(12, stu.getQq());
					ps.setString(13, stu.getStuTeleNum());
					ps.setString(14, stu.getStuEmail());
					ps.setString(15, stu.getIdCardNum());
					ps.setDate(16, stu.getBirthday());
					ps.setString(17, stu.getEduLevel());
					int rowCount = ps.executeUpdate();
					if (rowCount > 0) {
						ps.close();
						connection.close();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {// 已注册
			System.out.println("已注册！");
			return false;
		}
	}

	// 学生登陆
	public boolean login(String studentID, String password) {
		System.out.println("login");
		String sid = null;// 用来保存当前登陆的学号,并且进行判断
		String sql = "select * from stulogin where studentID = ? and password = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					sid = n;
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (sid == null) {
			System.out.println("false");
			return false;
		} else {
			System.out.println("true");
			return true;
		}
	}

	// 学生密码找回
	public String findPassword(String studentID, String stuEmail) {
		System.out.println("findPssword");
		String password = null;// 用来保存当前登陆学号的密码
		String sql = "select password('password') from student where studentID = ? and stuEmail = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ps.setString(2, stuEmail);
				ResultSet rs = ps.executeQuery();
				System.out.println(studentID + "   " + stuEmail);
				while (rs.next()) {
					String n = rs.getString(1);
					password = n;
				}
				rs.close();
				ps.close();
				connection.close();
				System.out.println(password);// null
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (password == null) {// 输入的学号或注册邮箱有误
			System.out.println("输入学号或注册邮箱有误");
			return null;
		} else {
			return password;
		}
	}

	// 学生更改密码
	public boolean changePassword(String sid, String oldpassword,
			String newpassword) {
		System.out.println("changePassword");
		String password = null;
		String sql = "select password from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, sid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					password = n;// 保存数据库中的密码
				}
				rs.close();
				ps.close();
				System.out.println(password);
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("2222222222222");
		if (password.equals(oldpassword)) {// 数据库中的密码和输入的原密码一致
			System.out.println("匹配正确");
			String sql1 = "update student set password = ? where studentID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setString(1, newpassword);
					ps.setString(2, sid);
					int rowCount = ps.executeUpdate();
					if (rowCount > 0) {
						ps.close();
						connection.close();// 修改成功
					}
				} else {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else {// 输入原密码有误
			return false;
		}
	}

	// 学生登陆后查找本人的所有信息
	public ArrayList<Student> findStuInformation(String studentID) {
		System.out.println("findStuInformation");
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("???????");
					Student n = new Student(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs
									.getString(13), rs.getString(14), rs
									.getString(15), rs.getDate(16), rs
									.getString(17), rs.getString(18), rs
									.getString(19), rs.getString(20));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("???????"+list);
		return list;
	}

	// 查找该学生相应的培养计划
	public ArrayList<Plan> findPlans(String major, String eduLevel) {
		System.out.println("findPlans");
		ArrayList<Plan> list = new ArrayList<Plan>();
		String boo = "1";
		String sql = "select * from plan where major = ? and eduLevel = ? ";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, major);
				ps.setString(2, eduLevel);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Plan n = new Plan(rs.getString(1), rs.getString(2), rs
							.getString(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getShort(9), rs.getDate(10), rs.getString(11), rs
							.getString(12));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			System.out.println("木有对应的培养计划");
			list = null;// 没有找到
		}
		return list;
	}

	// 查看某一培养计划下的所有课程
	public ArrayList<Course> findCoursesOfPlan(String planID) {
		System.out.println("findCoursesOfPlan");
		System.out.println(planID);
		ArrayList<Course> list = new ArrayList<Course>();
		String boo = "1";
		String sql = "select * from course where planID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, planID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Course n = new Course(rs.getString(1), rs.getString(2), rs
							.getShort(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getString(9), rs.getString(10), rs.getString(11),
							rs.getString(12), rs.getString(13), rs
									.getString(14), rs.getString(15), rs
									.getShort(16), rs.getString(17), rs
									.getString(18), rs.getString(19), rs
									.getString(20), rs.getString(21));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;// 该培养计划下暂无课程
		}
		return list;
	}

	// 管理员登陆
	public boolean adminLogin(String adminID, String password) {
		System.out.println("adminlogin");
		String aid = null;// 用来保存当前登陆的学号,并且进行判断
		String sql = "select * from admin where adminID = ? and password = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, adminID);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					aid = n;
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (aid == null) {
			System.out.println("false");
			return false;
		} else {
			System.out.println("true");
			return true;
		}
	}

	// 管理员密码找回
	public String findAdminPassword(String adminID, String adminEmail) {
		System.out.println("findAdminPassword");
		String password = null;// 用来保存当前登陆学号的密码
		String sql = "select password('password') from admin where adminID = ? and adminEmail = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, adminID);
				ps.setString(2, adminEmail);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					password = n;
				}
				rs.close();
				ps.close();
				connection.close();
				System.out.println(password);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (password == null) {// 输入的管理员账号或管理员邮箱有误
			System.out.println("输入的管理员账号或管理员邮箱有误");
			return null;
		} else {
			return password;
		}
	}

	// 更改管理员密码
	public boolean changeAdminPs(String aid, String oldpassword,
			String newpassword) {
		System.out.println("changeadminPassword");
		String password = null;
		String sql = "select password from admin where adminID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, aid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					password = n;// 保存数据库中的密码
				}
				rs.close();
				ps.close();
				System.out.println(password);
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (password.equals(oldpassword)) {// 数据库中的密码和输入的原密码一致
			System.out.println("匹配正确");
			String sql1 = "update admin set password = ? where adminID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setString(1, newpassword);
					ps.setString(2, aid);
					int rowCount = ps.executeUpdate();
					if (rowCount > 0) {
						ps.close();
						connection.close();// 修改成功
					}
				} else {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else {// 输入原密码有误
			return false;
		}
	}

	// 管理员查看当前所有培养计划
	public ArrayList<Plan> findAllPlans() {
		System.out.println("findAllPlans");
		ArrayList<Plan> list = new ArrayList<Plan>();
		String boo = "1";
		String sql = "select * from plan order by planID";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Plan n = new Plan(rs.getString(1), rs.getString(2), rs
							.getString(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getShort(9), rs.getDate(10), rs.getString(11), rs
							.getString(12));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			System.out.println("木有培养计划");
			list = null;// 没有找到
		}
		return list;
	}

	// 管理员添加培养计划
	public boolean addPlan(String planID, String planName, String type,
			String majID, String degree, String eduLevel, String direction,
			short minCredit, String date) {
		System.out.println("addPlan");
		String majorName = null;// 保存majorName
		String sql = "select majorName from major where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, majID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					majorName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将timeForPlan装换成java.sql.Date
		Date timeForPlan = java.sql.Date.valueOf(date);
		boolean boo = false;
		StringBuffer sql2 = new StringBuffer();
		sql2.append("insert into plan(planID,planName,type,major,majID,"
				+ "degree,eduLevel,direction,minCredit,timeForPlan)");
		sql2.append("values(?,?,?,?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {

				PreparedStatement ps = connection.prepareStatement(sql2
						.toString());
				ps.setString(1, planID);
				ps.setString(2, planName);
				ps.setString(3, type);
				ps.setString(4, majorName);
				ps.setString(5, majID);
				ps.setString(6, degree);
				ps.setString(7, eduLevel);
				ps.setString(8, direction);
				ps.setShort(9, minCredit);
				ps.setDate(10, timeForPlan);

				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();
					boo = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// admin修改培养计划
	public boolean updatePlan(Plan plan, String date) {
		System.out.println("updatePlan");
		String majorName = null;// 保存majorName
		String sql = "select majorName from major where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, plan.getMajID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					majorName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo = false;
		Date timeForPlan = java.sql.Date.valueOf(date);
		String sql1 = "update plan set planName = ? , "
				+ "type = ? , major = ? , majID = ? , degree = ? , "
				+ "eduLevel = ? , direction = ? , minCredit = ? , "
				+ "timeForPlan = ? where planID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, plan.getPlanName());
				ps.setString(2, plan.getType());
				ps.setString(3, majorName);
				ps.setString(4, plan.getMajID());
				ps.setString(5, plan.getDegree());
				ps.setString(6, plan.getEduLevel());
				ps.setString(7, plan.getDirection());
				ps.setShort(8, plan.getMinCredit());
				ps.setDate(9, timeForPlan);
				ps.setString(10, plan.getPlanID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 修改成功
					boo = true;
				}
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return true;
		} else {// 修改失败
			return false;
		}
	}

	// admin删除培养计划
	public boolean deletePlan(String planid) {
		boolean boo = false;
		String courseName = null;
		String sql1 = "select courseName from course where planID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, planid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					courseName = name;
				}
				System.out.println("课程名称：：：" + courseName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (courseName == null) {
			String sql = "delete from plan where planID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, planid);
					int count = ps.executeUpdate();
					if (count > 0) {
						boo = true;
						System.out.println("操作成功");
					} else {
						boo = false;
						System.out.println("操作失败");
					}
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boo = true;
		} else {
			boo = false;
		}
		return boo;
	}

	// admin查找所有教师
	public ArrayList<Teacher> findALLTeacher() {
		System.out.println("findAllTeacher");
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String boo = "1";
		String sql = "select * from teacher order by teacherID";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Teacher n = new Teacher(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("出错拉");
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// admin添加课程
	public boolean addcourse(Course cou) {
		System.out.println("addcourse");
		String depName = null;// 保存学院名
		String teaName = null;// 保存教师姓名
		String teaEmail = null;// 保存教师邮箱
		String planName = null;// 保存培养方案名称
		String majorName = null;// 保存培养方案名称
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, cou.getOfferDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				System.out.println(depName);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "select majorName from major where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql3);
				ps.setString(1, cou.getMajID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					majorName = name;
				}
				System.out.println(majorName);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select teacherName,teaEmail from teacher where teacherID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, cou.getTeacherID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					teaName = name;
					String email = rs.getString(2);
					teaEmail = email;
				}
				System.out.println(teaName + "  " + teaEmail);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql4 = "select planName from plan where planID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql4);
				ps.setString(1, cou.getPlanID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					planName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean boo = false;
		StringBuffer sql2 = new StringBuffer();
		System.out.println("cou.getMax()=======" + cou.getMax());
		System.out.println("cou.getCredit()=====" + cou.getCredit());
		sql2.append("insert into course(courseID, "
				+ "courseName, credit, classification, property, "
				+ "period, offerDepID, offerDepart, "
				+ "timeForCourse, location, teacherID, "
				+ "teacherName, teaEmail, majID," + "majorName, max, "
				+ "planID , planName, grade, eduLevel, weekday )");
		sql2.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2
						.toString());
				ps.setString(1, cou.getCourseID());
				ps.setString(2, cou.getCourseName());
				ps.setShort(3, cou.getCredit());
				ps.setString(4, cou.getClassification());
				ps.setString(5, cou.getProperty());
				ps.setString(6, cou.getPeriod());
				ps.setString(7, cou.getOfferDepID());
				ps.setString(8, depName);
				ps.setString(9, cou.getTimeForCourse());
				ps.setString(10, cou.getLocation());
				ps.setString(11, cou.getTeacherID());
				ps.setString(12, teaName);
				ps.setString(13, teaEmail);
				ps.setString(14, cou.getMajID());
				ps.setString(15, majorName);
				ps.setShort(16, cou.getMax());
				ps.setString(17, cou.getPlanID());
				ps.setString(18, planName);
				ps.setString(19, cou.getGrade());
				ps.setString(20, cou.getEduLevel());
				ps.setString(21, cou.getWeekday());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
					System.out.println("boo------" + boo);
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin修改课程信息
	public boolean updateCourse(Course cou) {
		System.out.println("updateCourse");
		System.out.println(cou.getTimeForCourse() + "    "
				+ "98889989898989898");
		String depName = null;// 保存学院名
		String teaName = null;// 保存教师姓名
		String teaEmail = null;// 保存教师邮箱
		String planName = null;// 保存培养方案名称
		String majorName = null;// 保存培养方案名称
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, cou.getOfferDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select teacherName,teaEmail from teacher where teacherID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, cou.getTeacherID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					teaName = name;
					String email = rs.getString(2);
					teaEmail = email;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "select planName from plan where planID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql3);
				ps.setString(1, cou.getPlanID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					planName = name;
				}
				System.out.println(teaName + "  " + teaEmail);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql4 = "select majorName from major where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql4);
				ps.setString(1, cou.getMajID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					majorName = name;
				}
				System.out.println(majorName);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo = false;
		String sql2 = "update course set courseName = ? , "
				+ "credit = ? , classification = ? , property = ? , "
				+ "period = ? , offerDepID = ? , offerDepart = ? , "
				+ "timeForCourse = ? , location = ? , teacherID = ? , "
				+ "teacherName = ? , teaEmail = ? ,majID = ?, majorName = ?, max = ? , "
				+ "planID = ? ,planName = ?, grade = ?,eduLevel = ?,weekday = ? where courseID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2);
				ps.setString(1, cou.getCourseName());
				ps.setShort(2, cou.getCredit());
				ps.setString(3, cou.getClassification());
				ps.setString(4, cou.getProperty());
				ps.setString(5, cou.getPeriod());
				ps.setString(6, cou.getOfferDepID());
				ps.setString(7, depName);
				ps.setString(8, cou.getTimeForCourse());
				ps.setString(9, cou.getLocation());
				ps.setString(10, cou.getTeacherID());
				ps.setString(11, teaName);
				ps.setString(12, teaEmail);
				ps.setString(13, cou.getMajID());
				ps.setString(14, majorName);
				ps.setShort(15, cou.getMax());
				ps.setString(16, cou.getPlanID());
				ps.setString(17, planName);
				ps.setString(18, cou.getGrade());
				ps.setString(19, cou.getEduLevel());
				ps.setString(20, cou.getEduLevel());
				ps.setString(21, cou.getCourseID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 修改成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return true;
		} else {// 修改失败
			return false;
		}
	}

	// admin删除课程
	public boolean deleteCourse(String courseid) {
		boolean boo = false;
		String sql = "delete from course where courseID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, courseid);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	// admin查找所有学生
	public ArrayList<Student> findAllStudnets() {
		System.out.println("adminfindAllStudnets");
		ArrayList<Student> list = new ArrayList<Student>();
		String boo = "1";
		String sql = "select * from student";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Student n = new Student(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs
									.getString(13), rs.getString(14), rs
									.getString(15), rs.getDate(16), rs
									.getString(17), rs.getString(18), rs
									.getString(19), rs.getString(20));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// admin删除学生
	public boolean deleteStudent(String studentid) {
		boolean boo = false;
		String sql = "delete from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentid);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	// 学生修改个人信息
	public boolean updateStudent(Student stu) {
		System.out.println("updateStudent");
		String depName = null;
		String majName = null;
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, stu.getDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql1 = "select majorName from major where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, stu.getMajID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					majName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo = false;
		String sql2 = "update student set studentName = ? , "
				+ "sex = ? , department = ? , depID = ? , "
				+ "major = ? , majID = ? , yearEnter = ? , "
				+ "classes = ? , direction = ? , qq = ? , "
				+ "stuTeleNum = ? , stuEmail = ? , idCardNum = ? , "
				+ "birthday = ? , eduLevel = ? where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2);
				ps.setString(1, stu.getStudentName());
				ps.setString(2, stu.getSex());
				ps.setString(3, depName);
				ps.setString(4, stu.getDepID());
				ps.setString(5, majName);
				ps.setString(6, stu.getMajID());
				ps.setString(7, stu.getYearEnter());
				ps.setString(8, stu.getClasses());
				ps.setString(9, stu.getDirection());
				ps.setString(10, stu.getQq());
				ps.setString(11, stu.getStuTeleNum());
				ps.setString(12, stu.getStuEmail());
				ps.setString(13, stu.getIdCardNum());
				ps.setDate(14, stu.getBirthday());
				ps.setString(15, stu.getEduLevel());
				ps.setString(16, stu.getStudentID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 修改成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return true;
		} else {// 修改失败
			return false;
		}
	}

	// admin 添加教师
	public boolean addTeacher(Teacher teacher) {
		System.out.println("addTeacher");
		String depName = null;// 保存学院名
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, teacher.getDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				System.out.println(depName);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean boo = false;
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into teacher(teacherID, "
				+ "teacherName, sex, department, depID, "
				+ "position, teaTeleNum, teaEmail)");
		sql1.append("values(?,?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1
						.toString());
				ps.setString(1, teacher.getTeacherID());
				ps.setString(2, teacher.getTeacherName());
				ps.setString(3, teacher.getSex());
				ps.setString(4, depName);
				ps.setString(5, teacher.getDepID());
				ps.setString(6, teacher.getPosition());
				ps.setString(7, teacher.getTeaTeleNum());
				ps.setString(8, teacher.getTeaEmail());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin 修改教师信息
	public boolean updateTeacher(Teacher teacher) {
		System.out.println("updateTeacher");
		String depName = null;
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, teacher.getDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean boo = false;
		String sql1 = "update teacher set teacherName = ? , "
				+ "sex = ? , department = ? , depID = ? , "
				+ "position = ? , teaTeleNum = ? , teaEmail = ? "
				+ "where teacherID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, teacher.getTeacherName());
				ps.setString(2, teacher.getSex());
				ps.setString(3, depName);
				ps.setString(4, teacher.getDepID());
				ps.setString(5, teacher.getPosition());
				ps.setString(6, teacher.getTeaTeleNum());
				ps.setString(7, teacher.getTeaEmail());
				ps.setString(8, teacher.getTeacherID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 修改成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return true;
		} else {// 修改失败
			return false;
		}
	}

	// admin 删除教师信息
	public boolean deleteTeacher(String teacherid) {
		String courseid = null;
		boolean boo = false;
		String sql1 = "select courseID from course where teacherID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, teacherid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					courseid = name;
				}
				System.out.println("教师ID：：：" + courseid);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (courseid == null) {// 该教师没有任课
			String sql = "delete from teacher where teacherID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, teacherid);
					int count = ps.executeUpdate();
					if (count > 0) {
						boo = true;
						System.out.println("操作成功");
					} else {
						boo = false;
						System.out.println("操作失败");
					}
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boo = true;
		} else {// 该教师有任课记录，请先删除该课程，再删除该教师
			boo = false;
		}
		return boo;
	}

	// admin添加学院
	public boolean addDep(Department depart) {
		boolean boo = false;
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into department(depID,depName)");
		sql1.append("values(?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1
						.toString());
				ps.setString(1, depart.getDepID());
				ps.setString(2, depart.getDepName());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin 修改学院信息
	public boolean updateDep(Department depart) {
		boolean boo = false;
		String sql1 = "update department set depName = ? where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, depart.getDepName());
				ps.setString(2, depart.getDepID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 修改成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return true;
		} else {// 修改失败
			return false;
		}
	}

	// admin 删除学院
	public boolean deleteDep(String depid) {
		String teacherName = null;
		String majorName = null;
		String studentName = null;
		boolean boo = false;
		String sql1 = "select teacherName from teacher where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, depid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					teacherName = name;
				}
				System.out.println("教师姓名：：：" + teacherName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "select majorName from major where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2);
				ps.setString(1, depid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					majorName = name;
				}
				System.out.println("专业名称：：：" + majorName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "select studentName from student where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql3);
				ps.setString(1, depid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					studentName = name;
				}
				System.out.println("学生姓名：：：" + studentName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (studentName == null && majorName == null && teacherName == null) {// 该学院下无信息，可删除
			String sql = "delete from department where depID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, depid);
					int count = ps.executeUpdate();
					if (count > 0) {
						boo = true;
						System.out.println("操作成功");
					} else {
						boo = false;
						System.out.println("操作失败");
					}
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boo = true;
		} else {// 有学生，老师，专业属于该学院，暂时不能删除！
			boo = false;
		}

		return boo;
	}

	// admin 添加专业
	public boolean addMaj(Major major) {
		String depName = null;
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, major.getDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				System.out.println(depName);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean boo = false;
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into major(majID, " + "majorName, depID, depName)");
		sql1.append("values(?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1
						.toString());
				ps.setString(1, major.getMajID());
				ps.setString(2, major.getMajorName());
				ps.setString(3, major.getDepID());
				ps.setString(4, depName);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin删除专业
	public boolean deleteMaj(String majid) {
		boolean boo = false;
		String studentName = null;
		String planName = null;
		String courseName = null;
		String sql3 = "select studentName from student where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql3);
				ps.setString(1, majid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					studentName = name;
				}
				System.out.println("学生姓名：：：" + studentName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "select planName from plan where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2);
				ps.setString(1, majid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					planName = name;
				}
				System.out.println("培养计划名称：：：" + planName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select courseName from course where majID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, majid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					courseName = name;
				}
				System.out.println("课程名称：：：" + courseName);
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (studentName == null && planName == null && courseName == null) {// 该专业下无学生和培养计划和课程，可以删除
			String sql = "delete from major where majID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, majid);
					int count = ps.executeUpdate();
					if (count > 0) {
						boo = true;
						System.out.println("操作成功");
					} else {
						boo = false;
						System.out.println("操作失败");
					}
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boo = true;
		} else {
			boo = false;
		}
		return boo;
	}

	// admin 修改专业
	public boolean updateMaj(Major major) {
		String depName = null;
		String sql = "select depName from department where depID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, major.getDepID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					depName = name;
				}
				System.out.println(depName);
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo = false;
		String sql1 = "update major set majorName = ?, depID = ?, depName = ? where majID = ?";

		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1
						.toString());
				ps.setString(1, major.getMajorName());
				ps.setString(2, major.getDepID());
				ps.setString(3, depName);
				ps.setString(4, major.getMajID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin 删除公告
	public boolean deleteNot(String notid) {
		boolean boo = false;
		String sql = "delete from notice where noticeID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, notid);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	// admin添加公告
	public boolean addNotice(Notice notice) {
		boolean boo = false;
		System.out.println("addNotice");
		StringBuffer sql = new StringBuffer();
		sql.append("insert into notice(noticeID,title,content,timeOfNotice)");
		sql.append("values(?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql
						.toString());
				ps.setString(1, notice.getNoticeID());
				ps.setString(2, notice.getTitle());
				ps.setString(3, notice.getContent());
				ps.setString(4, notice.getTimeOfNotice());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin修改公告信息
	public boolean updateNotice(Notice notice) {
		boolean boo = false;
		System.out.println("addNotice");
		String sql = "update notice set title = ?, content = ?, timeOfNotice = ? where noticeID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, notice.getTitle());
				ps.setString(2, notice.getContent());
				ps.setString(3, notice.getTimeOfNotice());
				ps.setString(4, notice.getNoticeID());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 修改失败
			return false;
		}
	}

	// admin 查看所有学生反馈
	public ArrayList<Suggestion> adminFindAllSuggs() {
		System.out.println("adminFindAllSuggs");
		ArrayList<Suggestion> list = new ArrayList<Suggestion>();
		String boo = "1";
		String sql = "select * from suggestion order by suggestionID Desc";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Suggestion n = new Suggestion(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6), rs.getString(7), rs
							.getString(8), rs.getString(9), rs.getString(10));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// student 提交反馈
	public boolean studentSendSugg(Suggestion sugg) {
		System.out.println("studentSendSugg");
		boolean boo = false;
		StringBuffer sql = new StringBuffer();
		sql
				.append("insert into suggestion(suggestionID, studentID, studentName, timeOfSugg, title, suggContent)");
		sql.append("values(?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql
						.toString());
				ps.setString(1, sugg.getSuggestionID());
				ps.setString(2, sugg.getStudentID());
				ps.setString(3, sugg.getStudentName());
				ps.setString(4, sugg.getTimeOfSugg());
				ps.setString(5, sugg.getTitle());
				ps.setString(6, sugg.getSuggContent());
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 提交成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 提交失败
			return false;
		}
	}

	// admin删除学生反馈
	public boolean deleteSugg(String suggid) {
		boolean boo = false;
		String sql = "delete from suggestion where suggestionID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, suggid);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	// admin查找某一个反馈的信息
	public ArrayList<Suggestion> searchSugg(String suggid) {
		System.out.println("searchSugg");
		System.out.println(suggid + "    " + "00000000000000000");
		ArrayList<Suggestion> list = new ArrayList<Suggestion>();
		String boo = "1";
		String sql = "select * from suggestion where suggestionID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, suggid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Suggestion n = new Suggestion(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6), rs.getString(7), rs
							.getString(8), rs.getString(9), rs.getString(10));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// admin 回复反馈
	public boolean replySugg(String replyContent, String replyTime,
			String suggestionID) {
		boolean boo = false;
		System.out.println("replySugg");
		String sql = "update suggestion set replyContent = ?, replyTime = ? where suggestionID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, replyContent);
				ps.setString(2, replyTime);
				ps.setString(3, suggestionID);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 回复成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {// 回复失败
			return false;
		}
	}

	// student查看反馈回复
	public ArrayList<Suggestion> checkReplySugg(String studentID) {
		ArrayList<Suggestion> list = new ArrayList<Suggestion>();
		String boo = "1";
		String sql = "select * from suggestion where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Suggestion n = new Suggestion(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6), rs.getString(7), rs
							.getString(8), rs.getString(9), rs.getString(10));
					list.add(n);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			list = null;
		}
		return list;
	}

	// student通过培养层次，专业，年级进行课程筛选
	public ArrayList<Course> findCoursebystu(String major, String grade,
			String eduLevel) {
		System.out.println("findCoursebystu");
		System.out.println(major);
		System.out.println(grade);
		System.out.println(eduLevel);

		ArrayList<Course> list = new ArrayList<Course>();
		String sql = "select * from course where majorName = ? and grade = ? and eduLevel = ?";
		String boo = "1";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, major);
				ps.setString(2, grade);
				ps.setString(3, eduLevel);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Course n = new Course(rs.getString(1), rs.getString(2), rs
							.getShort(3), rs.getString(4), rs.getString(5), rs
							.getString(6), rs.getString(7), rs.getString(8), rs
							.getString(9), rs.getString(10), rs.getString(11),
							rs.getString(12), rs.getString(13), rs
									.getString(14), rs.getString(15), rs
									.getShort(16), rs.getString(17), rs
									.getString(18), rs.getString(19), rs
									.getString(20), rs.getString(21));
					list.add(n);
				}
				System.out.println("54424343");
				rs.close();
				ps.close();
				connection.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			System.out.println("1");
			list = null;
		}
		System.out.println("2");
		return list;
	}

	// student 选课前检查该课程是否已被选
	public boolean checkSeletced(String courseid, String studentID) {
		System.out.println("checkSeletced");
		String sql = "select conseID from conofselcou where studentID = ? and courseID = ?";
		String boo = "1";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ps.setString(2, courseid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";// 选了
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("2")) {
			System.out.println("选了");
			return false;
		} else {
			System.out.println("没选");
			return true;
		}
	}

	// stdent 进行选课
	public boolean addCourseID(String conseID, String Courseid,
			String studentID, String pickuptime) {
		System.out.println("addCourseID");
		String courseName = null;
		Short credit = 0;
		String classification = null;
		String property = null;
		String period = null;
		String offerDepID = null;
		String offerDepart = null;
		String timeForCourse = null;
		String location = null;
		String teacherID = null;
		String teacherName = null;
		String teaEmail = null;
		String weekday = null;
		String sql = "select courseName,credit,classification,property,period,offerDepID,offerDepart,timeForCourse,location,teacherID,teacherName,"
				+ "teaEmail,weekday from course where courseID = ?";
		try {
			if (!this.connection.isClosed()) {
				System.out.println("...................");
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, Courseid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String cname = rs.getString(1);
					courseName = cname;

					Short coname = rs.getShort(2);
					credit = coname;

					String courname = rs.getString(3);
					classification = courname;

					String name = rs.getString(4);
					property = name;

					String name1 = rs.getString(5);
					period = name1;

					String name2 = rs.getString(6);
					offerDepID = name2;

					String name3 = rs.getString(7);
					offerDepart = name3;

					String name4 = rs.getString(8);
					timeForCourse = name4;

					String name5 = rs.getString(9);
					location = name5;

					String name6 = rs.getString(10);
					teacherID = name6;

					String name7 = rs.getString(11);
					teacherName = name7;

					String name8 = rs.getString(12);
					teaEmail = name8;

					String name9 = rs.getString(13);
					weekday = name9;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("0000000000...........");
		String sql1 = "select teaTeleNum from teacher where teacherID = ?";
		String teaTeleNum = null;
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, teacherID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String cname = rs.getString(1);
					teaTeleNum = cname;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "select studentName,department,majID,major,yearEnter,classes,stuTeleNum from student where studentID = ?";
		String studentName = null;
		String department = null;
		String majID = null;
		String major = null;
		String yearEnter = null;
		String classes = null;
		String stuTeleNum = null;
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String cname = rs.getString(1);
					studentName = cname;

					String cname1 = rs.getString(2);
					department = cname1;

					String cname2 = rs.getString(3);
					majID = cname2;

					String cname3 = rs.getString(4);
					major = cname3;

					String cname4 = rs.getString(5);
					yearEnter = cname4;

					String cname5 = rs.getString(6);
					classes = cname5;

					String cname6 = rs.getString(7);
					stuTeleNum = cname6;
				}
				rs.close();
				ps.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte pickUp = 1;// 选课时先置1，统计时在更改
		boolean b = false;
		StringBuffer sql3 = new StringBuffer();
		sql3
				.append("insert into conofselcou(conseID,courseID,courseName,credit,"
						+ "classification,property,period,offerDepID,offerDepart,timeForCourse,"
						+ "location,teacherID,teacherName,teaEmail,teaTeleNum,"
						+ "studentID,studentName,department,stumajID,stumajorName,stugrade," +
								"classes,stuTeleNum,pickUp,pickUpTime,weekday)");
		sql3
				.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql3
						.toString());
				ps.setString(1, conseID);
				ps.setString(2, Courseid);
				ps.setString(3, courseName);
				ps.setShort(4, credit);
				ps.setString(5, classification);
				ps.setString(6, property);
				ps.setString(7, period);
				ps.setString(8, offerDepID);
				ps.setString(9, offerDepart);
				ps.setString(10, timeForCourse);
				ps.setString(11, location);
				ps.setString(12, teacherID);
				ps.setString(13, teacherName);
				ps.setString(14, teaEmail);
				ps.setString(15, teaTeleNum);
				ps.setString(16, studentID);
				ps.setString(17, studentName);
				ps.setString(18, department);
				ps.setString(19, majID);
				ps.setString(20, major);
				ps.setString(21, yearEnter);
				ps.setString(22, classes);
				ps.setString(23, stuTeleNum);
				ps.setShort(24, pickUp);
				ps.setString(25, pickuptime);
				ps.setString(26, weekday);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();
					b = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == true) {
			System.out.println("选课成功");
			return true;
		} else {
			System.out.println("选课失败");
			return false;
		}
	}

	// 判断上课时间是否冲突
	public boolean checkTime(String time, String studentID) {
		System.out.println("checkTime");
		System.out.println(time);
		System.out.println(studentID);
		ArrayList<String> list = new ArrayList<String>();
		String boo = "1";
		String sql = "select timeForCourse from conofselcou where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					String coursetime = rs.getString(1);
					list.add(coursetime);
				}
				rs.close();
				ps.close();
				connection.close();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("该学生已选所有课程的时间：=----" + list.get(i));
		}
		boolean j = true;// 不冲突
		if (boo.equals("1")) {
			// 当前没有选课记录
			j = true;// 不冲突
		} else {// 有选课记录
			System.out.println("当前有选课记录");
			System.out.println("正在选的课的时间:----" + time);
			for (int i = 0; i < list.size(); i++) {
				System.out.println("正在比较。。。");
				if (list.get(i).toString().equals(time.trim())) {// 冲突
					System.out.println("冲突！");
					j = false;// false 表示 时间冲突
					break;
				} else {
					System.out.println("不冲突！");
				}
			}
		}
		System.out.println("j::::" + j);
		return j;
	}

	// student选课前系统查看所有课程的当前已选人数
	public Map<String, Short> findCurrentNum() {
		System.out.println("findCurrentNum");
		Map<String, Short> list = new HashMap<String, Short>();
		String courseid = null;
		Short currentNum = 0;
		String boo = "1";
		String sql1 = "select courseID,count(*) from conofselcou group by courseID";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					String cname = rs.getString(1);
					courseid = cname;
					Short c = rs.getShort(2);
					currentNum = c;
					list.put(courseid, currentNum);
				}
				rs.close();
				ps.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			Short i = 0;
			list.put(null, i);
		}
		System.out.println(list);
		return list;
	}

	// student 退课
	public boolean deleteCourseID(String courseid, String studentID) {
		System.out.println("deleteCourseID");
		boolean boo = false;
		String sql = "delete from conofselcou where courseID = ? and studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, courseid);
				ps.setString(2, studentID);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	// student查找所有已选课程
	public ArrayList<Conofselcou> checkSelected(String studentID) {
		System.out.println("checkSelected");
		ArrayList<Conofselcou> conse = new ArrayList<Conofselcou>();
		String boo = "1";
		String sql = "select * from conse_view where studentID = ? and pickUp = '1'";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Conofselcou c = new Conofselcou(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6), rs.getString(7), rs
							.getString(8), rs.getShort(9), rs.getString(10), rs
							.getShort(11), rs.getString(12));
					conse.add(c);
					System.out.println("444477777");
				}
				rs.close();
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			System.out.println("无记录");
			conse = null;
		}
		return conse;
	}

	// admin 按选课时间统计第一阶段选课结果
	public ArrayList<ArrayList<Conofselcou>> byTime() {
		System.out.println("byTime");
		// 创建一个按课程id存放结果的list
		ArrayList<ArrayList<Conofselcou>> cc = new ArrayList<ArrayList<Conofselcou>>();
		// 创建一个用来存储每门课选课人数的map集合key:课程id，value：课程人数
		Map<String, Short> numandcourseid = new HashMap<String, Short>();
		String boo = "1";
		String aaa = "1";
		Short num = 0;
		String courseid = null;
		// 查询当前结果中各门课程所选人数
		String sql = "select count(*),courseID from conofselcou group by courseID order by conseID ASC";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Short cname = rs.getShort(1);
					num = cname;
					String c = rs.getString(2);
					courseid = c;
					numandcourseid.put(courseid, num);
					System.out.println("有选课结果");
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {// 没有选课结果
			return null;
		} else {// 有选课结果
			// 获取已选人数大于max的课程id,若小于max，则放入list
			ArrayList<String> courseid1 = new ArrayList<String>();// 保存当前选课人数大于max的课程id
			for (String s : numandcourseid.keySet()) {
				System.out.println("课程id:--" + s + "----" + "人数:--"
						+ numandcourseid.get(s));
				// 循环查询每一个课程的最大人数
				Short num1 = 0;// 本次循环的最大人数
				String sql1 = "select max from course where courseID = ?";
				try {
					if (!this.connection.isClosed()) {
						PreparedStatement ps = connection
								.prepareStatement(sql1);
						ps.setString(1, s);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							Short a = rs.getShort(1);
							num1 = a;// 获得当前课程的max
							System.out.println("课程id为：---" + s + "  的max为：--"
									+ num1);
						}
						rs.close();
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (num1 < numandcourseid.get(s)) {// 当前课程人数 大于 max
					aaa = "2";
					System.out.println("超过max的课程id为：---" + s);
					courseid1.add(s);
				} else {// 将人数小于max的课程的结果放入list
					// 查询该课程的结果
					ArrayList<Conofselcou> bbb = new ArrayList<Conofselcou>();
					System.out.println("已到达查询小于max课程的结果");
					String sql3 = "select courseID,courseName,timeForCourse,location,"
							+ "teacherName,teaEmail,studentID,studentName,pickUp,pickUpTime,"
							+ "credit,weekday from conofselcou where courseID = ?";
					try {
						if (!this.connection.isClosed()) {
							PreparedStatement ps = connection
									.prepareStatement(sql3);
							ps.setString(1, s);
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								System.out.println("准备进入CC");
								Conofselcou ccc = new Conofselcou(rs
										.getString(1), rs.getString(2), rs
										.getString(3), rs.getString(4), rs
										.getString(5), rs.getString(6), rs
										.getString(7), rs.getString(8), rs
										.getShort(9), rs.getString(10), rs
										.getShort(11), rs.getString(12));
								bbb.add(ccc);
							}
							cc.add(bbb);
							rs.close();
							ps.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}// for循环结束
			if (aaa.equals("1")) {// 没有人数超过max的课
				System.out.println("没有超过max的课程！");
				return cc;
			} else {
				// 循环查询人数大于max的课程
				System.out.println("有超过max的课程！");
				for (int i = 0; i < courseid1.size(); i++) {
					// 先查询当前课程的max
					Short max = 0;
					String sql2 = "select max from course where courseID = ?";
					try {
						if (!this.connection.isClosed()) {
							PreparedStatement ps = connection
									.prepareStatement(sql2);
							ps.setString(1, courseid1.get(i));
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								boo = "2";
								Short a = rs.getShort(1);
								max = a;// 获得当前课程的max
								System.out
										.println("课程id为：---" + courseid1.get(i)
												+ "  的max为：--" + max);
							}
							rs.close();
							ps.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ArrayList<Conofselcou> c = new ArrayList<Conofselcou>();
					String sql3 = "select courseID,courseName,timeForCourse,location,"
							+ "teacherName,teaEmail,studentID,studentName,pickUp,pickUpTime,"
							+ "credit,weekday from conofselcou where courseID = ?"
							+ " order by conseID ASC limit 0,?";
					try {
						if (!this.connection.isClosed()) {
							System.out.println("超过max的课程id----"
									+ courseid1.get(i) + "  max-----" + max);
							PreparedStatement ps = connection
									.prepareStatement(sql3);
							ps.setString(1, courseid1.get(i));
							ps.setShort(2, max);
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								boo = "2";
								Conofselcou ccc = new Conofselcou(rs
										.getString(1), rs.getString(2), rs
										.getString(3), rs.getString(4), rs
										.getString(5), rs.getString(6), rs
										.getString(7), rs.getString(8), rs
										.getShort(9), rs.getString(10), rs
										.getShort(11), rs.getString(12));
								c.add(ccc);
								System.out.println("只选中前" + max + "个人");
							}
							cc.add(c);
							rs.close();
							ps.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}// for循环结束
				// 已得到cc
				// 写回数据库
				for (int i = 0; i < courseid1.size(); i++) {// 循环删除没有选上课的记录
					Short max = 0;
					String sql2 = "select max from course where courseID = ?";
					try {
						if (!this.connection.isClosed()) {
							PreparedStatement ps = connection
									.prepareStatement(sql2);
							ps.setString(1, courseid1.get(i));
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								boo = "2";
								Short a = rs.getShort(1);
								max = a;// 获得当前课程的max
								System.out
										.println("课程id为：---" + courseid1.get(i)
												+ "  的max为：--" + max);
							}
							rs.close();
							ps.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String sql4 = "delete from conofselcou where courseID = ? order by conseID DESC limit ?";
					try {
						if (!this.connection.isClosed()) {

							PreparedStatement ps = connection
									.prepareStatement(sql4);
							ps.setString(1, courseid1.get(i));
							ps.setShort(2, max);
							int count = ps.executeUpdate();
							if (count > 0) {
								System.out.println("删除操作成功");
							} else {
								System.out.println("删除操作失败");
							}
							ps.close();
							connection.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}// 有超过max的课的记录处理部分结束
			}
		}
		return cc;
	}

	// admin 查询当前所有选课记录
	public ArrayList<Conofselcou> findAllConse() {
		System.out.println("findAllConse");
		ArrayList<Conofselcou> conse = new ArrayList<Conofselcou>();
		String boo = "1";
		String sql = "select * from conse_view";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Conofselcou c = new Conofselcou(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6), rs.getString(7), rs
							.getString(8), rs.getShort(9), rs.getString(10), rs
							.getShort(11), rs.getString(12));
					conse.add(c);
				}
				rs.close();
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {
			System.out.println("无记录");
			conse = null;
		}
		return conse;
	}

	// admin 随机计算选课结果
	public boolean byRandom() {
		System.out.println("byRandom");
		Map<String, Short> numandcourseid = new HashMap<String, Short>();
		String boo = "1";
		Short num = 0;
		String courseid = null;
		// 查询当前结果中各门课程所选人数
		String sql = "select count(*),courseID from conofselcou group by courseID order by conseID ASC";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Short cname = rs.getShort(1);
					num = cname;
					String c = rs.getString(2);
					courseid = c;
					numandcourseid.put(courseid, num);
					System.out.println("有选课结果");
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boo.equals("1")) {// 没有选课结果
			return false;
		} else {// 有选课结果
			// 获取已选人数大于max的课程id
			for (String s : numandcourseid.keySet()) {
				System.out.println("课程id:--" + s + "----" + "人数:--"
						+ numandcourseid.get(s));
				// 循环查询每一个课程的最大人数
				Short num1 = 0;// 本次循环的最大人数
				String sql1 = "select max from course where courseID = ?";
				try {
					if (!this.connection.isClosed()) {
						PreparedStatement ps = connection
								.prepareStatement(sql1);
						ps.setString(1, s);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							Short a = rs.getShort(1);
							num1 = a;// 获得当前课程的max
							System.out.println("课程id为：---" + s + "  的max为：--"
									+ num1);
						}
						rs.close();
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Short current = numandcourseid.get(s);
				Short max = num1;
				while(max < current) {// 当前课程人数 大于 max
					System.out.println("超过max的课程id为：---" + s);
					     checkBigMax(s, numandcourseid.get(s));  
					       //继续查询人数
					     System.out.println("出来到这。。。。");
							String sql2 = "select count(*) from conofselcou where courseID = ? and pickUp = 1";
							try {
								System.out.println("不走了？？？？");
								if (!this.connection.isClosed()) {
									System.out.println("继续");
									PreparedStatement ps = connection.prepareStatement(sql2);
									ps.setString(1, s);
									ResultSet rs = ps.executeQuery();
									while (rs.next()) {
										boo = "2";
										Short ssssss = rs.getShort(1);
										current = ssssss;
										System.out.println(current);
									}
									rs.close();
									ps.close();

								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}			
	     }
		//删除pickup = 0的记录
		boolean boob = false;
		String sql3 = "delete from conofselcou where pickUp = 0";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql3);
				int count = ps.executeUpdate();
				if (count > 0) {
					boob = true;
					System.out.println("操作成功");
				} else {
					boob = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return boob;
		
	}
	
	//admin 人数大于max时的处理函数(随机方法)
     public boolean checkBigMax(String courseid, Short personnum){
		System.out.println("checkBigMax");
		System.out.println(personnum);
 		for (int i = 0; i < personnum; i++) {// 循环选课人数次
 			// 生成一个随机数
 			String sss = (Math.random() * 100000) + "";
 			System.out.println(sss.trim().substring(0,2));
 			int iii = Integer.parseInt(sss.trim().substring(0,2));
 			Short pickup = 0;// 未选上
 			if (iii <= 50) {
 				pickup = 1;// 选上
 			} else {
 				pickup = 0;// 未选上
 			}
 			System.out.println(pickup);
 			String sql2 = "update conofselcou set pickUp = ? where courseID = ?";
 			try {
 				if (!this.connection.isClosed()) {
 					PreparedStatement ps = connection.prepareStatement(sql2);
 					ps.setShort(1, pickup);
 					ps.setString(2, courseid);
 				    int rowCount = ps.executeUpdate();
 					if (rowCount > 0) {
 					ps.close();
 					}
 				}
 				} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 				System.out.println("结束");
 		}
 		System.out.println("出来、、、");
    	 return true;
	}

    // student查找所有留言
	public ArrayList<Stumess> findAllMyMessage(String studentID) {
		System.out.println("findAllMyMessage");
		String boo = "1";
		ArrayList<Stumess> list = new ArrayList<Stumess>();
		String sql = "select * from stumess where tostudentID = ? and confirmMessage is null";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Stumess s = new Stumess(rs.getString(1), rs.getString(2), rs.getString(3),
							 rs.getString(4),  rs.getString(5),  rs.getString(6),
							 rs.getShort(7),rs.getShort(8), rs.getString(9));
					list.add(s);
					System.out.println("有留言");
				}
				rs.close();
				ps.close();
                connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo.endsWith("1")){
			System.out.println("message为空");
			list = null;
		}
		return list;
	}

	// student查找所有好友
	public ArrayList<Friend> findAllMyFriend(String studentID) {
		System.out.println("findAllMyFriend");
		String boo = "1";
		ArrayList<Friend> list = new ArrayList<Friend>();
		String sql = "select studentID,friendID,friendName from friend where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Friend f = new Friend(rs.getString(1), rs.getString(2), rs.getString(3));
					list.add(f);
				}
				rs.close();
				ps.close();
                connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo.endsWith("1")){
			list = null;
		}
		return list;
	}

	// student 删除留言
	public boolean deleteMess(String messageID) {
		System.out.println("deleteMess");
		boolean boo = false;
		String sql = "delete from stumess where messageID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, messageID);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return boo;
	   }

	// student 发送添加好友申请
	public boolean addFriendRequest(String messageID, String fromid,
			String toid, String time) {
		System.out.println("addFriendRequest");
		String toStudentName = null;
		String fromStudentName = null;
		String sql = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, toid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					toStudentName = name;
					System.out.println(toStudentName);
				}
				rs.close();
				ps.close();  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, fromid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					fromStudentName = name;
					System.out.println(fromStudentName);
				}
				rs.close();
				ps.close();  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fromid);
		boolean boo = false;
		StringBuffer sql2 = new StringBuffer();
		sql2.append("insert into stumess(messageID,fromStudentID,toStudentID,toStudentName,timeOfLeaMes,confirmMessage,fromStudentName)");
		sql2.append("values(?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql2
						.toString());
				ps.setString(1, messageID);
				ps.setString(2, fromid);
				ps.setString(3, toid);
				ps.setString(4, toStudentName);
				ps.setString(5, time);
				ps.setString(6, "0");
				ps.setString(7, fromStudentName );
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 添加成功
					boo = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (boo == true) {
			return boo;
		} else {//发送
			return false;
		}
	}

	// student查找未读好友申请
	public ArrayList<Stumess> findAllrequest(String studentID) {
		System.out.println("findAllrequest");
		String boo = "1";
		ArrayList<Stumess> list = new ArrayList<Stumess>();
		String sql = "select * from stumess where tostudentID = ? and confirmMessage = '0'";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					System.out.println("有好友申请");
					Stumess s = new Stumess(rs.getString(1), rs.getString(2), rs.getString(3),
							 rs.getString(4), rs.getString(5),  rs.getString(6),
							 rs.getShort(7),rs.getShort(8),rs.getString(9));
					list.add(s);
				}
				rs.close();
				ps.close();  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo.equals("1")){
			System.out.println("暂时没有未读好友申请！");
			list = null;
		}
		return list;
	}
	
	// student 同意添加好友
	public boolean agreeToAdd(String messageID) {
		System.out.println("agreeToAdd");
		String boo = "1";
		String sql = "update stumess set confirmMessage = '1' where messageID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, messageID);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					boo = "2";
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo.equals("1")){
			System.out.println("修改失败！");
		    return false;
		}else{//写入朋友表
			System.out.println("修改成功");
			String toStudentID = null;
			String toStudentName = null;
			String fromStudentID = null;
			String fromStudentName = null;
			System.out.println("messageID---"+messageID);
			String sql2 = "select toStudentID,toStudentName,fromStudentID,fromStudentName from stumess where messageID = ?";
			try {
				if (!this.connection.isClosed()) {
					System.out.println("将来了、、、、、、");
					PreparedStatement ps = connection.prepareStatement(sql2);
					ps.setString(1, messageID);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						boo = "2";
						
						String name = rs.getString(1);
						toStudentID = name;
						System.out.println("toStudentID----"+toStudentID);
						
						String name2 = rs.getString(2);
						toStudentName = name2;
						System.out.println("toStudentName----"+toStudentName);
						
						
						
						String name3 = rs.getString(3);
						fromStudentID = name3;
						System.out.println("fromStudentID----"+fromStudentID);
						
						
						String name4 = rs.getString(4);
						fromStudentName = name4;
						System.out.println("fromStudentName-----"+fromStudentName);
					}
					rs.close();
					ps.close();  
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("到这了~~~");
			String ssss = UUID.randomUUID().toString().substring(0, 14);
			boolean boob = false;
			StringBuffer sql1 = new StringBuffer();
			sql1.append("insert into friend(recordID,studentID, friendID, friendName)");
			sql1.append("values(?,?,?,?)");
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql1
							.toString());
					ps.setString(1, ssss);
					ps.setString(2, toStudentID);
					ps.setString(3, fromStudentID);
					ps.setString(4, fromStudentName);
					int rowCount = ps.executeUpdate();
					if (rowCount > 0) {
						ps.close();
						boob = true;
					}
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sssss = UUID.randomUUID().toString().substring(0, 14);
	     	StringBuffer sql4 = new StringBuffer();
			sql4.append("insert into friend(recordID, studentID, friendID, friendName)");
			sql4.append("values(?,?,?,?)");
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql4
							.toString());
					ps.setString(1, sssss);
					ps.setString(2, fromStudentID);
					ps.setString(3, toStudentID);
					ps.setString(4, toStudentName);
					int rowCount = ps.executeUpdate();
					if (rowCount > 0) {
						ps.close();
						connection.close();
						boob = true;
					}
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (boob == true) {
				System.out.println(boob);
				return boob;
			} else {//发送
				return false;
			}
		}

	}

	// student 拒绝好友请求
	public boolean refuseToAdd(String messageID) {
		System.out.println("refuseToAdd");
		String boo = "1";
		String sql = "update stumess set confirmMessage = '2' where messageID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, messageID);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
				    connection.close();
					boo = "2";
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo.equals("1")){
			System.out.println("修改失败！");
		    return false;
		}else{//写入朋友表
	        return true;
		}
	}

	// student访问好友主页 查找好友个人信息
	public Student findPersonnalMessage(String sID) {
		System.out.println("findPersonnalMessage");
		Student s = new Student();
		String sql = "select * from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, sID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Student n = new Student(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs
									.getString(13), rs.getString(14), rs
									.getString(15), rs.getDate(16), rs
									.getString(17), rs.getString(18), rs
									.getString(19), rs.getString(20));
					s = n;
				}
				rs.close();
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	// student 访问好友个人主页  查找好友课程
	public ArrayList<Conofselcou> findPersonnalCourse(String sID) {
		System.out.println("findPersonnalMessage");
		ArrayList<Conofselcou> list = new ArrayList<Conofselcou>();
		String boo = "1";
		String sql = "select * from conse_view where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, sID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					boo = "2";
					Conofselcou c = new Conofselcou(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), rs
							.getString(5), rs.getString(6), rs.getString(7), rs
							.getString(8), rs.getShort(9), rs.getString(10), rs
							.getShort(11), rs.getString(12));
					list.add(c);
				}
				rs.close();
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo.equals("1")){
			list = null;
		}
		return list;
	}

	// student删除好友
	public boolean deleteFriend(String beiID, String yaoID) {
		System.out.println("deleteFriend");
		boolean boo = false;
		String sql = "delete from friend where studentID = ? and friendID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, yaoID);
				ps.setString(2, beiID);
				int count = ps.executeUpdate();
				if (count > 0) {
					boo = true;
					System.out.println("操作成功");
				} else {
					boo = false;
					System.out.println("操作失败");
				}
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boo == true){
			String sql1 = "delete from friend where studentID = ? and friendID = ?";
			try {
				if (!this.connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setString(1, beiID);
					ps.setString(2, yaoID);
					int count = ps.executeUpdate();
					if (count > 0) {
						boo = true;
						System.out.println("操作成功");
					} else {
						boo = false;
						System.out.println("操作失败");
					}
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(boo == false){
				return false;
			}
		}else{
			return false;
		}
	     return boo;
	   }

	//给好友留言
	public boolean leaveMessage(String beiID, String yaoID, String mid, String time, String content) {
		System.out.println("leaveMessage");
		String fromStudentName = null;
		String toStudentName = null;
		String sql = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, yaoID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					fromStudentName = n;
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, beiID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					toStudentName = n;
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boob = false;
     	StringBuffer sql4 = new StringBuffer();
		sql4.append("insert into stumess(messageID, fromStudentID, toStudentID, toStudentName, timeOfLeaMes, content, haveBeenRead, fromStudentName)");
		sql4.append("values(?,?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql4
						.toString());
				ps.setString(1, mid);
				ps.setString(2, yaoID);
				ps.setString(3, beiID);
				ps.setString(4, toStudentName);
				ps.setString(5, time);
				ps.setString(6, content);
				ps.setString(7, "0");
				ps.setString(8, fromStudentName);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();
					boob = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boob;
	}

	// student 查找与某一个好友的聊天记录
	public ArrayList<Stumess> findAllSPMyMessage(String beiID, String yaoID) {
		System.out.println("findAllSPMyMessage");
		ArrayList<Stumess> list = new ArrayList<Stumess>();
		String sql1 = "select * from stumess where fromStudentID = ? and toStudentID = ? and confirmMessage is null";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, yaoID);
				ps.setString(2, beiID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Stumess s = new Stumess(rs.getString(1), rs.getString(2), rs.getString(3),
							 rs.getString(4), rs.getString(5),  rs.getString(6),
							 rs.getShort(7),rs.getShort(8),rs.getString(9));
					list.add(s);
				}
				rs.close();
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//写回复
	public boolean writeReply(String mid, String yaoID, String beiID,
			String time, String content) {
		System.out.println("writeReply");
		String fromStudentName = null;
		String toStudentName = null;
		String sql = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, yaoID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					fromStudentName = n;
					System.out.println("fromStudentName---"+fromStudentName);
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select studentName from student where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setString(1, beiID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String n = rs.getString(1);
					toStudentName = n;
					System.out.println("toStudentName---"+toStudentName);
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boob = false;
     	StringBuffer sql4 = new StringBuffer();
		sql4.append("insert into stumess(messageID, fromStudentID, toStudentID, toStudentName, timeOfLeaMes, content, haveBeenRead, fromStudentName)");
		sql4.append("values(?,?,?,?,?,?,?,?)");
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql4
						.toString());
				ps.setString(1, mid);
				ps.setString(2, yaoID);
				ps.setString(3, beiID);
				ps.setString(4, toStudentName);
				ps.setString(5, time);
				ps.setString(6, content);
				ps.setString(7, "0");
				ps.setString(8, fromStudentName);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();
					boob = true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boob;
	}

	// 上传头像
	public boolean upLoadImg(String sid, String location) {
		System.out.println("upLoadImg");
		String sql = "update student set photo = ? where studentID = ?";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, location);
				ps.setString(2, sid);
				int rowCount = ps.executeUpdate();
				if (rowCount > 0) {
					ps.close();
					connection.close();// 修改成功
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	// student 下载课表
	public boolean downloadCourseTable(String sid) {
		System.out.println("downloadCourseTable");
		String sql = "select courseID,courseName,weekday,timeForCourse,location,teacherName from conofselcou where studentID = ? into outfile 'E:\\coursetable.txt' fields terminated by ',' lines terminated by '\r\n'";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, sid);
				ps.executeQuery();		
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	// admin 下载选课结果
	public boolean downloadConse() {
		System.out.println("downloadConse");
		String sql = "select * from conofselcou into outfile 'E:\\consequence.txt' fields terminated by ',' lines terminated by '\r\n'";
		try {
			if (!this.connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.executeQuery();
				ps.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
     
    
}
