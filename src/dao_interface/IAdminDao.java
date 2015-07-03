package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.Admin;

public interface IAdminDao {

	//����Ա��¼
	public boolean login(Admin admin) throws SQLException;

	//����Ա���
	public boolean addadmin(Admin admin) throws SQLException;
	
	//����Աɾ��
	public boolean deladmin(Admin admin) throws SQLException;
	
	//�鿴����Ա
	public List<Admin> alladmin() throws SQLException;
	
}
