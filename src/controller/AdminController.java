package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminDao;
import dao.UserDao;
import dao_interface.IAdminDao;
import entity.Admin;
import entity.User;

//��̨����
@Controller
@RequestMapping("/admin")
public class AdminController extends CommonController {

	String url;
	Admin admin = new Admin();
	IAdminDao ad = new AdminDao();
	String msg0 = null;
	String msg1 = null;
	String url0 = null;
	String url1 = null;

	// ��̨��½����
	@RequestMapping("/admin")
	public String admin() {
		return "/backend/admin";
	}

	// �жϵ�¼
	@RequestMapping("/isadmin")
	public String isadmin(String aname, String apwd, Model model, HttpSession session) throws SQLException {
		admin.setAname(aname);
		admin.setApwd(apwd);
		boolean bool = ad.login(admin);
		msg0 = "��¼ʧ��";
		msg1 = "��¼�ɹ�";
		url0 = "redirect:/user/login";
		url1 = "/backend/adminhome";
		return this.isbool(bool, model, msg0, msg1, url0, url1);
	}

	// �鿴�����û�
	@RequestMapping("/alluser")
	public String alluser(Model model) throws SQLException {
		UserDao userdao = new UserDao();
		List<User> alluserlist = userdao.alluser();
		model.addAttribute("alluserlist", alluserlist);
		return "/backend/alluser";
	}

}
