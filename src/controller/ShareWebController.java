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

	// ���з����������ַ������չʾ
	@RequestMapping("/allshareweb")
	public String allshareweb(Model model) throws SQLException {
		List<ShareWeb> allsharelist = swd.shareweb();
		model.addAttribute("allshareweb", allsharelist);
		return "/frontend/allshareweb";
	}

	//�鿴�û��Լ��������ַ
	@RequestMapping("/myshareweb")
	public String myshareweb(Model model,HttpSession session) throws SQLException
	{
		String suid = (String)session.getAttribute("uid");
		sw.setSuid(suid);
		List<ShareWeb> mysharelist = swd.myshareweb(sw);
		model.addAttribute("mysharelist",mysharelist);
		return "/frontend/myshareweb";
	}
	
	// �û�������ַ����
	@RequestMapping("/addshareweb")
	public String addshareweb(String sname, Model model) throws SQLException {
		boolean bool = swd.addshareweb(sw);
		msg0 = "����ʧ��";
		msg1 = "����ɹ�";
		return this.isbool2(bool, model, msg0, msg1, url);
	}

	// �����û��������ַ�޸�
	@RequestMapping("/updateshareweb")
	public String updateshareweb(Model model) throws SQLException {
		boolean bool = swd.updateshareweb(sw);

		msg0 = "�޸�ʧ��";
		msg1 = "�޸ĳɹ�";

		return this.isbool2(bool, model, msg0, msg1, url);
	}

	// ����ɾ���������ַ
	@RequestMapping("/delshareweb")
	public String delshareweb(Model model) throws SQLException {
		boolean bool = swd.delshareweb(sw);

		msg0 = "ɾ��ʧ��";
		msg1 = "ɾ���ɹ�";
		return this.isbool2(bool, model, msg0, msg1, url);
	}

}
