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
	
//ֱ�ӷ��ʽ���
	//��¼����
	@RequestMapping("/login")
	public String login(){
		return "/frontend/login";
	}
	//ע�����
	@RequestMapping("/register")
	public String register(){
		return "/frontend/register";
	}
	
//��¼����ʵ��û����ҳ��	

	//�û�������Ϣҳ
	@RequestMapping("/info")
	public String myinfo(Model model,HttpSession session) throws SQLException{
		String uid = (String) session.getAttribute("uid");
		user.setUid(uid);
		User user2 = userdao.userinfo(user);
		model.addAttribute("userinfo", user2);	
		return "/frontend/info";
		
	}
	
	
	//�û������޸�ҳ
	@RequestMapping("/upwd")
	public String updatepwd(Model model,HttpSession session){
		return "/frontend/upwd";
	}
	
	
	//ע��
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session){
		session.removeAttribute("uid");
		session.removeAttribute("uname");
		session.removeAttribute("unickname");
		model.addAttribute("msg", "ע���ɹ�");	
		return "redirect:/";
		
	}
	
	// �����߼�ҵ��
		// �����¼
		@RequestMapping("/islogin")
		public String islogin(String uname, String upwd,HttpServletRequest request, HttpSession session) throws SQLException {
			user.setUname(uname);
			user.setUpwd(upwd);
			User user2 = userdao.islogin(user);
			// ResultSet��Ҫ��Ϊ����ֵ����
			if (user2 != null) {
				session.setAttribute("uid", user2.getUid());
				session.setAttribute("uname", uname);
				session.setAttribute("unickname", user2.getUnickname());
				msg = "��ϲ�㣬��¼�ɹ���";
				url = "redirect:/web/myweb";
			} else {
				msg = "�Բ��𣬵�¼ʧ�ܣ�";
				url = "redirect:/frontend/login";
			}
			request.setAttribute("msg", msg);
			return url;
		}
		
		// ����ע��
		@RequestMapping("/isregister")
		public String isuser(String uname, String unickname, String upwd1, String upwd2, Model model) throws SQLException {
			System.out.print(uname);
			user.setUname(uname);
			user.setUpwd(upwd2);
			user.setUnickname(unickname);

			boolean bool = userdao.isregister(user);
			if(bool)
			{
				msg = "��ϲ�㣡ע��ɹ������¼��";
				url = "redirect:/user/login";
			}
			else{
				msg = "�Բ���ע��ʧ�ܡ�";
				url = "redirect:/user/register";
			}
			model.addAttribute("msg", msg);
			return url;
		}

		// �޸��û�����
		@RequestMapping("/updatepwd")
		public String updatepwd(String oldpwd, String upwd1, String upwd2, Model model, HttpSession session) throws SQLException {
			String uid = (String)session.getAttribute("uid");
			user.setUid(uid);
			user.setUpwd(upwd2);
			boolean bool = userdao.updatepwd(user, oldpwd);
			if (!bool) {
				msg="�޸�ʧ��";
				return "redirect:/user/upwd";
			}
			msg="�޸ĳɹ�";
			model.addAttribute("msg", msg);
			return "redirect:/web/myweb";

		}
		
		//�����û���Ϣ��ҳ��
		@RequestMapping("/upinfo")
		public String upinfo(Model model,HttpSession session) throws SQLException
		{
			String uid = (String) session.getAttribute("uid");
			user.setUid(uid);
			User user2 = userdao.userinfo(user);
			model.addAttribute("userinfo", user2);	
			return "/frontend/upinfo";
		}
		
		//�����û���Ϣ�Ĵ���
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
				msg="���ĳɹ�";
			}
			else{
				msg="����ʧ��";
			}
			model.addAttribute("msg", msg);
			return "redirect:/user/info";
		}
		
		

}
