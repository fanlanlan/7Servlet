package dao;

import entity.User;

public interface UserDao {
	//通过名字查询
	public User queryByUsername(String username);
}
