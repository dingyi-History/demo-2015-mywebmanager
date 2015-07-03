package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet Filter implementation class IsUserFilter
 */
@WebFilter({ "/user/myweb", "/user/info" })
public class IsUserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IsUserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;//filter 请求类型为servletrequest ,强制转换为HttpServletRequest才能用session
		HttpSession session = req.getSession();
		Object uid =  session.getAttribute("uid");
		if(uid != null)
		{
			User user = new User();
			user.setUid((String)uid);
			chain.doFilter(request, response);
		}
		else{
		request.setAttribute("msg", "请登录后查看");	
		request.getRequestDispatcher("/user/login").forward(request, response); ;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
