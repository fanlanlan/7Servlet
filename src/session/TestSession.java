package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestSession extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		resp.setContentType("text/html");
		ServletContext ctx = super.getServletContext();
		String encoding = ctx.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		//新建session
		String name=null;
		HttpSession session = req.getSession(true);
		String id = session.getId();
		//获取最大活跃时间
		int life = session.getMaxInactiveInterval();
		
		PrintWriter pw = resp.getWriter();
		pw.println("id:"+id);
		pw.println("life:"+life);
	}
}
