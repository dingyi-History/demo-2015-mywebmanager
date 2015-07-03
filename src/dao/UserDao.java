package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IUserDao;
import entity.User;

public class UserDao  extends BaseDao implements	IUserDao{

	String sql;
	
	//�û�ע��
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
	
	//�ж��û����Ƿ����
	private boolean isexit(User user) throws SQLException {
		sql="SELECT * FROM user where uname=?";
		return this.backbool(sql, new String[]{user.getUname()});
	}

	//�ж��û��Ƿ��¼
	@Override
	public User islogin(User user) throws SQLException {
		sql="SELECT * FROM user where uname=? AND upwd = ?";
		List<User> userlist = this.backuserlist(sql, new String[]{user.getUname(),user.getUpwd()});
		return backuser(userlist);
	}

	//��ȡ�û���Ϣ
	@Override
	public User userinfo(User user) throws SQLException {
		sql="SELECT * FROM user where uid=?";
		 List<User> userlist =   this.backuserlist(sql, new String[]{user.getUid()});
		return backuser(userlist);
		 
	}
	

	

	//�����û�����
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
	
	//��֤�û�������
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
		for(User user2 : userlist)//��ǿforѭ��for(part1 : part2){part3} 
		{
			user = user2;
		}
		return user;
	}

	//�����û���Ϣ
	@Override
	public boolean updateuserinfo(User user) throws SQLException {
		sql="UPDATE user SET unickname=?,uqq=?,uemail=? where uid=?";
		return this.backbool(sql, new String[]{user.getUnickname(),user.getUqq(),user.getUemail(),user.getUid()});
	}

	//�鿴�����û�
	@Override
	public List<User> alluser() throws SQLException {
		sql="SELECT * FROM user";
		return this.backuserlist(sql, null);
	}
	
}
