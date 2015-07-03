package controller;

import org.springframework.ui.Model;

//公共的方法
public class CommonController {

	//判定布尔类型结果,处理存在两种不同的跳转时候
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
	
	//判定布尔类型结果,处理存在两种相同的跳转时候
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
