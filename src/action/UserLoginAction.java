package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;

public class UserLoginAction extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			//设置编码
			resp.setContentType("text/html");
			ServletContext ctx = super.getServletContext();
			String Encoding = ctx.getInitParameter("encoding");
			req.setCharacterEncoding(Encoding);
			resp.setCharacterEncoding(Encoding);
			

			String username = req.getParameter("username").trim();
			String password = req.getParameter("password");
			
			UserServiceImpl service = new UserServiceImpl();
			service.Login(username, password);
			//登陆成功
			req.setAttribute("username", username);
			RequestDispatcher dpc = req.getRequestDispatcher("/ok");
			dpc.forward(req, resp);
		} catch (Exception e) {
			//登录失败
			RequestDispatcher dpc = req.getRequestDispatcher("/no");
			dpc.forward(req, resp);
		}
		
		
		
	
	}

	}
