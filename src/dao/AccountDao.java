package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IAccountDao;
import entity.Account;

public class AccountDao extends BaseDao implements IAccountDao{
	String sql;
	//��ѯ�û���¼���˺���Ϣ
	@Override
	public List<Account> myaccount(entity.Account ac) throws SQLException {
		sql="SELECT * FROM account where acuid=?";
		return this.backaclist(sql, new String[]{ac.getAcid()});
	}

	//����˺���Ϣ
	@Override
	public boolean addaccount(entity.Account ac) throws SQLException {
		sql="INSERT INTO account(actitle,acname,acpwd,acuid) VALUES(?,?,?,?)";
		return this.backbool(sql, new String[]{ac.getActitle(),ac.getAcname(),ac.getAcpwd(),ac.getAcuid()});
	}

	//������¼���˺���Ϣ
	@Override
	public boolean updateaccount(entity.Account ac) throws SQLException {
		sql="UPDATE account SET actitle=?,acname=?,acpwd=? where acid=?";
		return this.backbool(sql, new String[]{ac.getActitle(),ac.getAcname(),ac.getAcpwd(),ac.getAcid()});
	}

	//ɾ��һ����¼
	@Override
	public boolean delaccount(entity.Account ac) throws SQLException {
		sql="DELETE FROM account where acid=?";
		return this.backbool(sql, new String[]{ac.getAcid()});
	}

}
