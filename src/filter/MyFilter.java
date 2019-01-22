package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;




public class MyFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("============filter的destory方法==========");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		System.out.println("============filter的doFilter方法==========");
		filter.doFilter(req, resp);//请求是否被执行
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("============filter的int方法==========");
	}
	}
