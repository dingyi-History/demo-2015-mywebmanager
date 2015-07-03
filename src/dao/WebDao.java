package dao;

import java.sql.SQLException;
import java.util.List;

import conndb.BaseDao;
import dao_interface.IWebDao;
import entity.Web;

public class WebDao extends BaseDao implements IWebDao{
	String sql;


	//用户收录网址
	@Override
	public boolean addweb(Web web) throws SQLException {
		sql="INSERT INTO web(wuid,wname,wurl) VALUES(?,?,?)";
		return this.backbool(sql, new String[]{web.getWuid(),web.getWname(),web.getWurl()});
	}
	
	//用户删除收录的网址
	@Override
	public boolean delweb(Web web) throws SQLException {
		sql="DELETE FROM web where wid=?";
		return this.backbool(sql, new String[]{web.getWid()});
	}

	//更改收录的网址信息
	@Override
	public boolean updateweb(Web web) throws SQLException {
		sql="UPDATE web SET wname=?,wurl=? WHERE wid=?";
		return this.backbool(sql, new String[]{web.getWname(),web.getWurl(),web.getWid()});
	}

	
	//获取用户自己收录的网址
	@Override
	public List<Web> myweb(Web web) throws SQLException {
		sql="SELECT * FROM web where wuid=?";
		return  this.backweblist(sql, new String[]{web.getWuid()});
	}
	
	//根据网址ID查询网址内容
	@Override
	public List<Web> oneweb(Web web) throws SQLException {
		sql="SELECT * FROM web where wid=?";
		return this.backweblist(sql, new String[]{web.getWid()});
	}

	//查看所有的收录的网址
	@Override
	public List<Web> allweb() throws SQLException {
		sql="SELECT * FROM web";
		return this.backweblist(sql, null);
	}

	
}
