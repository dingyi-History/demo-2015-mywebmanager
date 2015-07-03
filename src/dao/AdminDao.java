package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IAdminDao;
import entity.Admin;

public class AdminDao extends BaseDao implements IAdminDao {

	String sql;
	
	//����Ա��¼
	@Override
	public boolean login(Admin admin) throws SQLException {
		sql="SELECT * FROM admin where aname=? AND apwd=?";
		List<Admin> alist = this.backalist(sql, new String[]{admin.getAname(),admin.getApwd()});
		if(alist!=null)
		{
			return true;
		}
		return false;
	}

	//��ӹ���Ա
	@Override
	public boolean addadmin(Admin admin) throws SQLException {
		boolean bool = this.isexitadmin(admin);
		if(bool)
		{
			sql="INSERT INTO admin(aname,apwd)VALUES(?,?)";
			return this.backbool(sql, new String[]{admin.getAname(),admin.getApwd()});
		}
		return false;
	}
	
	//�жϹ���Ա�Ƿ�����
	private  boolean isexitadmin(Admin admin) throws SQLException{
		sql="SELECT * FROM admin where aname=?";
		List<Admin> alist = this.backalist(sql, new String[]{admin.getAname()});
		if(alist!=null)
		{
			return false;
		}
		return true;
		
	}

	//ɾ��һ������Ա
	@Override
	public boolean deladmin(Admin admin) throws SQLException {
		sql="DELETE FROM admin where aid=?hi";
		return this.backbool(sql, new String[]{admin.getAid()});
	}

	//�鿴���й���Ա
	@Override
	public List<Admin> alladmin() throws SQLException {
		sql="SELECT * FROM admin";
		return this.backalist(sql, null);
	}

}
