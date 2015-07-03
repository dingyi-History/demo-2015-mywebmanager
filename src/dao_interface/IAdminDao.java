package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.Admin;

public interface IAdminDao {

	//管理员登录
	public boolean login(Admin admin) throws SQLException;

	//管理员添加
	public boolean addadmin(Admin admin) throws SQLException;
	
	//管理员删除
	public boolean deladmin(Admin admin) throws SQLException;
	
	//查看管理员
	public List<Admin> alladmin() throws SQLException;
	
}
