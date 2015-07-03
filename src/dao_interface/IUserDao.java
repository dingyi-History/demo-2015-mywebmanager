package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface IUserDao {
	
	//�ж��Ƿ�ע��
	public boolean isregister(User user)throws SQLException;

	//�ж��Ƿ��¼
	public User islogin(User user)throws SQLException;

	//��ȡ�û���Ϣ����ʵ������
	public User userinfo(User user)throws SQLException;
	
	
	//�����û�����
	public boolean updatepwd(User user,String oldpwd)throws SQLException;

	//�����û���Ϣ
	public boolean updateuserinfo(User user)throws SQLException;
	
	//�鿴�����û�
	public List<User> alluser() throws SQLException;
	
	
}
