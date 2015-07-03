package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.Account;

public interface IAccountDao {

	//获取用户自己保存的账号信息
	public List<Account> myaccount(Account ac)throws SQLException;
	
	//添加账号的信息
	public boolean addaccount(Account ac) throws SQLException;
	
	//更改账号信息
	public boolean updateaccount(Account ac)throws SQLException;
	
	//删除保存的账号
	public boolean delaccount(Account ac) throws SQLException;
}
