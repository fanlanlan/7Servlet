package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TestListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		//创建监听引用
		@SuppressWarnings("unused")
		HttpSession session = e.getSession();
		System.out.println("=====开始监听=======");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("========监听停止========");
		
	}

	

}
