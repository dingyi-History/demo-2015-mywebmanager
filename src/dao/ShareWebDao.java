package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IShareWebDao;
import entity.ShareWeb;

public class ShareWebDao extends BaseDao implements IShareWebDao {
	String sql;
	int i;
	
	// ����һ����ַ
	@Override
	public boolean  addshareweb(ShareWeb sw) throws SQLException {
		sql = "INSERT INTO shareweb(swid,suid) VALUES(?,?)";
		return this.backbool(sql, new String[] { sw.getSwid(), sw.getSuid() });
	}

	// �û�ɾ��һ���������ַ
	@Override
	public boolean delshareweb(ShareWeb sw) throws SQLException {
		sql = "DELETE FROM shareweb where swid=?";
		return this.backbool(sql, new String[] { sw.getSwid() });
	}

	// �����û��������ַ
	@Override
	public boolean updateshareweb(ShareWeb sw) throws SQLException {
		sql = "UPDATE shareweb SET(swid=?) WHERE suid=?";
		return this.backbool(sql, new String[] { sw.getSwid(), sw.getSuid() });
	}
//------------------------------------------------------------------------------
	// �鿴�������ַID
	@Override
	public List<ShareWeb> shareweb() throws SQLException {
		sql = "SELECT * FROM shareweb";
		List<ShareWeb> swlist = this.backswlist(sql, null);
		return swlist;
	}

	// �鿴�û��Լ��������ַ
	@Override
	public List<ShareWeb> myshareweb(ShareWeb sw) throws SQLException {
		sql = "SELECT * FROM shareweb where suid=?";
		List<ShareWeb> myswlist = this.backswlist(sql, new String[] { sw.getSuid() });
		return myswlist;
	}

	
}
