package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IAccountDao;
import entity.Account;

public class AccountDao extends BaseDao implements IAccountDao{
	String sql;
	//查询用户收录的账号信息
	@Override
	public List<Account> myaccount(entity.Account ac) throws SQLException {
		sql="SELECT * FROM account where acuid=?";
		return this.backaclist(sql, new String[]{ac.getAcid()});
	}

	//添加账号信息
	@Override
	public boolean addaccount(entity.Account ac) throws SQLException {
		sql="INSERT INTO account(actitle,acname,acpwd,acuid) VALUES(?,?,?,?)";
		return this.backbool(sql, new String[]{ac.getActitle(),ac.getAcname(),ac.getAcpwd(),ac.getAcuid()});
	}

	//更改收录的账号信息
	@Override
	public boolean updateaccount(entity.Account ac) throws SQLException {
		sql="UPDATE account SET actitle=?,acname=?,acpwd=? where acid=?";
		return this.backbool(sql, new String[]{ac.getActitle(),ac.getAcname(),ac.getAcpwd(),ac.getAcid()});
	}

	//删除一条收录
	@Override
	public boolean delaccount(entity.Account ac) throws SQLException {
		sql="DELETE FROM account where acid=?";
		return this.backbool(sql, new String[]{ac.getAcid()});
	}

}
