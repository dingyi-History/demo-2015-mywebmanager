package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDao;
import dao_interface.IUserDao;
import entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	IUserDao userdao = new UserDao();
	User user = new User();
	String msg=null;
	String url =null;
	
//直接访问界面
	//登录界面
	@RequestMapping("/login")
	public String login(){
		return "/frontend/login";
	}
	//注册界面
	@RequestMapping("/register")
	public String register(){
		return "/frontend/register";
	}
	
//登录后访问的用户相关页面	

	//用户个人信息页
	@RequestMapping("/info")
	public String myinfo(Model model,HttpSession session) throws SQLException{
		String uid = (String) session.getAttribute("uid");
		user.setUid(uid);
		User user2 = userdao.userinfo(user);
		model.addAttribute("userinfo", user2);	
		return "/frontend/info";
		
	}
	
	
	//用户密码修改页
	@RequestMapping("/upwd")
	public String updatepwd(Model model,HttpSession session){
		return "/frontend/upwd";
	}
	
	
	//注销
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session){
		session.removeAttribute("uid");
		session.removeAttribute("uname");
		session.removeAttribute("unickname");
		model.addAttribute("msg", "注销成功");	
		return "redirect:/";
		
	}
	
	// 处理逻辑业务
		// 处理登录
		@RequestMapping("/islogin")
		public String islogin(String uname, String upwd,HttpServletRequest request, HttpSession session) throws SQLException {
			user.setUname(uname);
			user.setUpwd(upwd);
			User user2 = userdao.islogin(user);
			// ResultSet不要作为返回值类型
			if (user2 != null) {
				session.setAttribute("uid", user2.getUid());
				session.setAttribute("uname", uname);
				session.setAttribute("unickname", user2.getUnickname());
				msg = "恭喜你，登录成功！";
				url = "redirect:/web/myweb";
			} else {
				msg = "对不起，登录失败！";
				url = "redirect:/frontend/login";
			}
			request.setAttribute("msg", msg);
			return url;
		}
		
		// 处理注册
		@RequestMapping("/isregister")
		public String isuser(String uname, String unickname, String upwd1, String upwd2, Model model) throws SQLException {
			System.out.print(uname);
			user.setUname(uname);
			user.setUpwd(upwd2);
			user.setUnickname(unickname);

			boolean bool = userdao.isregister(user);
			if(bool)
			{
				msg = "恭喜你！注册成功，请登录。";
				url = "redirect:/user/login";
			}
			else{
				msg = "对不起，注册失败。";
				url = "redirect:/user/register";
			}
			model.addAttribute("msg", msg);
			return url;
		}

		// 修改用户密码
		@RequestMapping("/updatepwd")
		public String updatepwd(String oldpwd, String upwd1, String upwd2, Model model, HttpSession session) throws SQLException {
			String uid = (String)session.getAttribute("uid");
			user.setUid(uid);
			user.setUpwd(upwd2);
			boolean bool = userdao.updatepwd(user, oldpwd);
			if (!bool) {
				msg="修改失败";
				return "redirect:/user/upwd";
			}
			msg="修改成功";
			model.addAttribute("msg", msg);
			return "redirect:/web/myweb";

		}
		
		//更新用户信息的页面
		@RequestMapping("/upinfo")
		public String upinfo(Model model,HttpSession session) throws SQLException
		{
			String uid = (String) session.getAttribute("uid");
			user.setUid(uid);
			User user2 = userdao.userinfo(user);
			model.addAttribute("userinfo", user2);	
			return "/frontend/upinfo";
		}
		
		//更改用户信息的处理
		@RequestMapping("/updateinfo")
		public String updateinfo(String unickname,String uqq,String uemail,Model model,HttpSession session) throws SQLException
		{
			String uid = (String)session.getAttribute("uid");
			user.setUid(uid);
			user.setUnickname(unickname);
			user.setUqq(uqq);
			user.setUemail(uemail);
			boolean bool = userdao.updateuserinfo(user);
			if(bool)
			{
				msg="更改成功";
			}
			else{
				msg="更改失败";
			}
			model.addAttribute("msg", msg);
			return "redirect:/user/info";
		}
		
		

}
