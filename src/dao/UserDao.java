package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IUserDao;
import entity.User;

public class UserDao  extends BaseDao implements	IUserDao{

	String sql;
	
	//用户注册
	@Override
	public boolean isregister(User user) throws SQLException {
		boolean bool = isexit(user);
		if(!bool)
		{		
			sql="INSERT INTO user (uname,upwd,unickname) VALUES (?,?,?)";
			return this.backbool(sql, new String[]{user.getUname(),user.getUpwd(),user.getUnickname()});
		}
		return false;
	}
	
	//判断用户名是否存在
	private boolean isexit(User user) throws SQLException {
		sql="SELECT * FROM user where uname=?";
		return this.backbool(sql, new String[]{user.getUname()});
	}

	//判断用户是否登录
	@Override
	public User islogin(User user) throws SQLException {
		sql="SELECT * FROM user where uname=? AND upwd = ?";
		List<User> userlist = this.backuserlist(sql, new String[]{user.getUname(),user.getUpwd()});
		return backuser(userlist);
	}

	//获取用户信息
	@Override
	public User userinfo(User user) throws SQLException {
		sql="SELECT * FROM user where uid=?";
		 List<User> userlist =   this.backuserlist(sql, new String[]{user.getUid()});
		return backuser(userlist);
		 
	}
	

	

	//更改用户密码
	@Override
	public boolean updatepwd(User user,String oldpwd) throws SQLException {
		boolean bool = this.useroldpwd(user,oldpwd);
		if(bool)
		{
		sql="UPDATE user SET upwd=? where uid=?";
		return this.backbool(sql, new String[]{user.getUpwd(),user.getUid()});
		}
		return false;
	}
	
	//验证用户旧密码
		private boolean useroldpwd(User user,String oldpwd) throws SQLException {
			sql="SELECT * FROM user where uid=? and upwd=?";
			List<User> userlist = this.backuserlist(sql, new String[]{user.getUid(),oldpwd});
			if(userlist!=null)
			{
				return true;
			}
			else{
				return false;
			}
		}

	
	private User backuser(List<User> userlist)
	{
		User user = new User();
		for(User user2 : userlist)//增强for循环for(part1 : part2){part3} 
		{
			user = user2;
		}
		return user;
	}

	//更改用户信息
	@Override
	public boolean updateuserinfo(User user) throws SQLException {
		sql="UPDATE user SET unickname=?,uqq=?,uemail=? where uid=?";
		return this.backbool(sql, new String[]{user.getUnickname(),user.getUqq(),user.getUemail(),user.getUid()});
	}

	//查看所有用户
	@Override
	public List<User> alluser() throws SQLException {
		sql="SELECT * FROM user";
		return this.backuserlist(sql, null);
	}
	
}
