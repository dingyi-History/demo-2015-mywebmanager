package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IAdminDao;
import entity.Admin;

public class AdminDao extends BaseDao implements IAdminDao {

	String sql;
	
	//管理员登录
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

	//添加管理员
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
	
	//判断管理员是否重名
	private  boolean isexitadmin(Admin admin) throws SQLException{
		sql="SELECT * FROM admin where aname=?";
		List<Admin> alist = this.backalist(sql, new String[]{admin.getAname()});
		if(alist!=null)
		{
			return false;
		}
		return true;
		
	}

	//删除一个管理员
	@Override
	public boolean deladmin(Admin admin) throws SQLException {
		sql="DELETE FROM admin where aid=?hi";
		return this.backbool(sql, new String[]{admin.getAid()});
	}

	//查看所有管理员
	@Override
	public List<Admin> alladmin() throws SQLException {
		sql="SELECT * FROM admin";
		return this.backalist(sql, null);
	}

}
