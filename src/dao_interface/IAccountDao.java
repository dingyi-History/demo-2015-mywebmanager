package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.Account;

public interface IAccountDao {

	//��ȡ�û��Լ�������˺���Ϣ
	public List<Account> myaccount(Account ac)throws SQLException;
	
	//����˺ŵ���Ϣ
	public boolean addaccount(Account ac) throws SQLException;
	
	//�����˺���Ϣ
	public boolean updateaccount(Account ac)throws SQLException;
	
	//ɾ��������˺�
	public boolean delaccount(Account ac) throws SQLException;
}
