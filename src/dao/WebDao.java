package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IWebDao;
import entity.Web;

public class WebDao extends BaseDao implements IWebDao{
	String sql;


	//�û���¼��ַ
	@Override
	public boolean addweb(Web web) throws SQLException {
		sql="INSERT INTO web(wuid,wname,wurl) VALUES(?,?,?)";
		return this.backbool(sql, new String[]{web.getWuid(),web.getWname(),web.getWurl()});
	}
	
	//�û�ɾ����¼����ַ
	@Override
	public boolean delweb(Web web) throws SQLException {
		sql="DELETE FROM web where wid=?";
		return this.backbool(sql, new String[]{web.getWid()});
	}

	//������¼����ַ��Ϣ
	@Override
	public boolean updateweb(Web web) throws SQLException {
		sql="UPDATE web SET wname=?,wurl=? WHERE wid=?";
		return this.backbool(sql, new String[]{web.getWname(),web.getWurl(),web.getWid()});
	}

	
	//��ȡ�û��Լ���¼����ַ
	@Override
	public List<Web> myweb(Web web) throws SQLException {
		sql="SELECT * FROM web where wuid=?";
		return  this.backweblist(sql, new String[]{web.getWuid()});
	}
	
	//������ַID��ѯ��ַ����
	@Override
	public List<Web> oneweb(Web web) throws SQLException {
		sql="SELECT * FROM web where wid=?";
		return this.backweblist(sql, new String[]{web.getWid()});
	}

	//�鿴���е���¼����ַ
	@Override
	public List<Web> allweb() throws SQLException {
		sql="SELECT * FROM web";
		return this.backweblist(sql, null);
	}

	
}
