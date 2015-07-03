package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.WebDao;
import dao_interface.IWebDao;
import entity.Web;

@Controller
@RequestMapping("/web")
public class WebController  extends CommonController{
	IWebDao wd = new WebDao();
	Web web = new Web();
	
	String msg0;
	String msg1;
	String url="redirect:/web/myweb";
	// �ҵ���ַ�ղ�
	@RequestMapping("/myweb")
	public String  myweb(Model model,HttpSession session) throws SQLException
	{
		String wuid = (String)session.getAttribute("uid");
		web.setWid(wuid);
		List<Web> weblist = wd.myweb(web);
		System.out.print(weblist);
		model.addAttribute("weblist", weblist);
		return "/frontend/myweb";
	}
	
	//��ַ�ղ�
	@RequestMapping("/addweb")
	public String addweb(String wname,String wurl,Model model,HttpSession session) throws SQLException
	{
		String wuid = (String) session.getAttribute("uid");
		web.setWuid(wuid);
		web.setWname(wname);
		web.setWurl(wurl);
		boolean bool = wd.addweb(web);
		msg0="�ղ�ʧ��";
		msg1="�ղسɹ�";
		return this.isbool2(bool, model, msg0, msg1, url);
	}
	
	
	//ɾ��һ���ղص���ַ
	@RequestMapping("/delweb")
	public String delweb(Model model,String id) throws SQLException
	{
		web.setWid(id);
		boolean bool = wd.delweb(web);
		msg0="ɾ��ʧ��";
		msg1="ɾ���ɹ�";
		return this.isbool2(bool, model, msg0, msg1, url);
	}
	
	//����һ���ղص���ַ
	@RequestMapping("/updateweb")
	public String updateweb(String id,Model model)throws SQLException
	{
		web.setWid(id);
		boolean bool = wd.updateweb(web);
		msg0 = "����ʧ��";
		msg1 = "���³ɹ�";
		return this.isbool2(bool, model, msg0, msg1, url);
		
	}
	

	
		
		
}
