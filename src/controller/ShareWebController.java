package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.ShareWebDao;
import dao_interface.IShareWebDao;
import entity.ShareWeb;

@Controller
@RequestMapping("/shareweb")
public class ShareWebController extends CommonController {

	ShareWeb sw = new ShareWeb();
	IShareWebDao swd = new ShareWebDao();

	String msg0 = null;
	String msg1 = null;
	String url0 = null;
	String url1 = null;
	String url = "redirect:/shareweb/allshareweb";

	// 所有分享出来的网址，进行展示
	@RequestMapping("/allshareweb")
	public String allshareweb(Model model) throws SQLException {
		List<ShareWeb> allsharelist = swd.shareweb();
		model.addAttribute("allshareweb", allsharelist);
		return "/frontend/allshareweb";
	}

	//查看用户自己分享的网址
	@RequestMapping("/myshareweb")
	public String myshareweb(Model model,HttpSession session) throws SQLException
	{
		String suid = (String)session.getAttribute("uid");
		sw.setSuid(suid);
		List<ShareWeb> mysharelist = swd.myshareweb(sw);
		model.addAttribute("mysharelist",mysharelist);
		return "/frontend/myshareweb";
	}
	
	// 用户进行网址分享
	@RequestMapping("/addshareweb")
	public String addshareweb(String sname, Model model) throws SQLException {
		boolean bool = swd.addshareweb(sw);
		msg0 = "分享失败";
		msg1 = "分享成功";
		return this.isbool2(bool, model, msg0, msg1, url);
	}

	// 进行用户分享的网址修改
	@RequestMapping("/updateshareweb")
	public String updateshareweb(Model model) throws SQLException {
		boolean bool = swd.updateshareweb(sw);

		msg0 = "修改失败";
		msg1 = "修改成功";

		return this.isbool2(bool, model, msg0, msg1, url);
	}

	// 进行删除分享的网址
	@RequestMapping("/delshareweb")
	public String delshareweb(Model model) throws SQLException {
		boolean bool = swd.delshareweb(sw);

		msg0 = "删除失败";
		msg1 = "删除成功";
		return this.isbool2(bool, model, msg0, msg1, url);
	}

}
