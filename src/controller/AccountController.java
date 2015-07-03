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
	
	//用戶的账号收录页,先由过滤器过滤掉未登录的情况
	@RequestMapping("/myaccount")
	public String myaccount(Model model,HttpSession session) throws SQLException{
		String acuid = (String) session.getAttribute("uid");
		ac.setAcuid(acuid);
		List<Account>  myaccount = acd.myaccount(ac);
		model.addAttribute("myaccount", myaccount);
		return "/frontend/myaccount";//服务器端的跳转
	}
	
	
	
	//收录账号
	@RequestMapping("addacount")
	public String addacount(String actitle,String acname,String acpwd,Model model) throws SQLException
	{
		ac.setActitle(actitle);
		ac.setAcname(acname);
		ac.setAcpwd(acpwd);
		
		boolean bool = acd.addaccount(ac);
		msg1="添加成功";
		msg0="添加失败";
		return this.isbool2(bool, model, msg0, msg1, url);
	}
	
	//删除账号
	@RequestMapping("delaccount")
	public String delaccount(String id,Model model) throws SQLException
	{
		ac.setAcid(id);
		
		boolean bool = acd.delaccount(ac);
		msg1="删除成功";
		msg0="删除失败";
		return this.isbool2(bool, model, msg0, msg1, url);
		
	}
	
	//更改账号信息
	@RequestMapping("/updateaccount")
	public String updateaccount(String id,Model model) throws SQLException
	{
		ac.setAcid(id);
		boolean bool = acd.updateaccount(ac);
		msg1="更改成功";
		msg0="更改失败";
		return this.isbool2(bool, model, msg0, msg1, url);
		
	}
	
	
	
}
