package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface IUserDao {
	
	//判断是否注册
	public boolean isregister(User user)throws SQLException;

	//判断是否登录
	public User islogin(User user)throws SQLException;

	//获取用户信息存在实体类中
	public User userinfo(User user)throws SQLException;
	
	
	//更改用户密码
	public boolean updatepwd(User user,String oldpwd)throws SQLException;

	//更改用户信息
	public boolean updateuserinfo(User user)throws SQLException;
	
	//查看所有用户
	public List<User> alluser() throws SQLException;
	
	
}
