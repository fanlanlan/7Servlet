package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginNoView extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		try {
			resp.setContentType("text/html");
			ServletContext ctx = super.getServletContext();
			String Encoding = ctx.getInitParameter("encoding");
			req.setCharacterEncoding(Encoding);
			resp.setCharacterEncoding(Encoding);
			
			
			PrintWriter pw = resp.getWriter();
			pw.println("<h1>登陆失败</h1>");
		} catch (Exception e) {
			throw new RuntimeException("登陆失败出现异常");
		}
	}
}
