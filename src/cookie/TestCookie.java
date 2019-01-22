package cookie;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.ranges.RangeException;

public class TestCookie extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		resp.setContentType("text/html");
		ServletContext ctx = super.getServletContext();
		String encoding = ctx.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		//创建Cookie
		Cookie c = new Cookie("fanlanlan","lanlan");
		resp.addCookie(c);
		//获取cookie
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for(Cookie w:cookies){
				String name = w.getName();
				String value = w.getValue();
				System.out.println("name:"+name+"       value:"+value);
			}
		}else{
			System.out.println("此处有误");
			//throw new RuntimeException("有错误!!!!!!!");
		}
		
	}
	

}
