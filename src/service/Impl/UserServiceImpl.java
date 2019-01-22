package service.Impl;

import org.apache.ibatis.session.SqlSession;

import service.UserService;
import util.MyBatiesUtil;
import dao.UserDao;
import entity.User;


public class UserServiceImpl implements UserService{
	@Override
	public void Login(String username, String password) {
		try {
			SqlSession session = MyBatiesUtil.getSession();
			UserDao dao = session.getMapper(UserDao.class);
			User user = dao.queryByUsername(username);
			//调用dao
			if(user==null || !user.getPassword().equals(password) || !user.getUsername().equals(username)){
				//登录失败
				throw new RuntimeException("用户名或密码不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//session.close();
			
		}
		
	}

}
