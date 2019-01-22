package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *filter的登录拦截
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	/* 
	 * 拦截用户为登录不能访问资源
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		/*
		 * 判断用户是否登录
		 */
		Object o = request.getSession(true).getAttribute("login");
		if(o==null){
			//未登录
			response.sendRedirect("/login.html");
			return;
		}else{
			//放过请求
			filter.doFilter(req, resp);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

	

}
