package controller;

import org.springframework.ui.Model;

//�����ķ���
public class CommonController {

	//�ж��������ͽ��,����������ֲ�ͬ����תʱ��
	public String  isbool(boolean bool,Model model,String msg0,String msg1,String url0,String url1)
	{
		String url;
		String msg;
		if(bool)
		{
			msg = msg1;
			url = url1;
		}else{
			msg = msg0;
			url = url0;
		}
		model.addAttribute("msg", msg);
		return url;
		
	}
	
	//�ж��������ͽ��,�������������ͬ����תʱ��
		public String  isbool2(boolean bool,Model model,String msg0,String msg1,String url)
		{
			String msg;
			if(bool)
			{
				msg = msg1;
			}else{
				msg = msg0;
			}
			model.addAttribute("msg", msg);
			return url;
			
		}
}
