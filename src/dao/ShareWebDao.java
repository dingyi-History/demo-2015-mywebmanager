package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IShareWebDao;
import entity.ShareWeb;

public class ShareWebDao extends BaseDao implements IShareWebDao {
	String sql;
	int i;
	
	// 分享一个网址
	@Override
	public boolean  addshareweb(ShareWeb sw) throws SQLException {
		sql = "INSERT INTO shareweb(swid,suid) VALUES(?,?)";
		return this.backbool(sql, new String[] { sw.getSwid(), sw.getSuid() });
	}

	// 用户删除一个分享的网址
	@Override
	public boolean delshareweb(ShareWeb sw) throws SQLException {
		sql = "DELETE FROM shareweb where swid=?";
		return this.backbool(sql, new String[] { sw.getSwid() });
	}

	// 更改用户分享的网址
	@Override
	public boolean updateshareweb(ShareWeb sw) throws SQLException {
		sql = "UPDATE shareweb SET(swid=?) WHERE suid=?";
		return this.backbool(sql, new String[] { sw.getSwid(), sw.getSuid() });
	}
//------------------------------------------------------------------------------
	// 查看分享的网址ID
	@Override
	public List<ShareWeb> shareweb() throws SQLException {
		sql = "SELECT * FROM shareweb";
		List<ShareWeb> swlist = this.backswlist(sql, null);
		return swlist;
	}

	// 查看用户自己分享的网址
	@Override
	public List<ShareWeb> myshareweb(ShareWeb sw) throws SQLException {
		sql = "SELECT * FROM shareweb where suid=?";
		List<ShareWeb> myswlist = this.backswlist(sql, new String[] { sw.getSuid() });
		return myswlist;
	}

	
}
