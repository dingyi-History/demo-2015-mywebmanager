package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AccountDao;
import dao_interface.IAccountDao;
import entity.Account;

@Controller
@RequestMapping("/account")
public class AccountController   extends CommonController{
	Account ac = new Account();
	IAccountDao acd = new AccountDao();
	String msg0;
	String msg1;
	String url="redirect:/user/account";
	
	//�Ñ����˺���¼ҳ,���ɹ��������˵�δ��¼�����
	@RequestMapping("/myaccount")
	public String myaccount(Model model,HttpSession session) throws SQLException{
		String acuid = (String) session.getAttribute("uid");
		ac.setAcuid(acuid);
		List<Account>  myaccount = acd.myaccount(ac);
		model.addAttribute("myaccount", myaccount);
		return "/frontend/myaccount";//�������˵���ת
	}
	
	
	
	//��¼�˺�
	@RequestMapping("addacount")
	public String addacount(String actitle,String acname,String acpwd,Model model) throws SQLException
	{
		ac.setActitle(actitle);
		ac.setAcname(acname);
		ac.setAcpwd(acpwd);
		
		boolean bool = acd.addaccount(ac);
		msg1="��ӳɹ�";
		msg0="���ʧ��";
		return this.isbool2(bool, model, msg0, msg1, url);
	}
	
	//ɾ���˺�
	@RequestMapping("delaccount")
	public String delaccount(String id,Model model) throws SQLException
	{
		ac.setAcid(id);
		
		boolean bool = acd.delaccount(ac);
		msg1="ɾ���ɹ�";
		msg0="ɾ��ʧ��";
		return this.isbool2(bool, model, msg0, msg1, url);
		
	}
	
	//�����˺���Ϣ
	@RequestMapping("/updateaccount")
	public String updateaccount(String id,Model model) throws SQLException
	{
		ac.setAcid(id);
		boolean bool = acd.updateaccount(ac);
		msg1="���ĳɹ�";
		msg0="����ʧ��";
		return this.isbool2(bool, model, msg0, msg1, url);
		
	}
	
	
	
}
