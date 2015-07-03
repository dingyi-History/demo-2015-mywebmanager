package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.Web;

public interface IWebDao {

	//�û�������ַ��¼
	public boolean addweb(Web web)throws SQLException;
	
	//ɾ����ַ
	public boolean delweb(Web web) throws SQLException;
	
	//�޸���ַ
	public boolean updateweb(Web web)throws SQLException;
	

	//��ȡ�û��ղص���ַ
	public List<Web> myweb(Web web)throws SQLException;
	
	//ͨ����ַID��ѯ��ַ
	public List<Web> oneweb(Web web)throws SQLException;

	//�鿴������¼����ַ
	public List<Web> allweb() throws SQLException;
}
