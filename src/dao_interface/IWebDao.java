package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.Web;

public interface IWebDao {

	//用户进行网址收录
	public boolean addweb(Web web)throws SQLException;
	
	//删除网址
	public boolean delweb(Web web) throws SQLException;
	
	//修改网址
	public boolean updateweb(Web web)throws SQLException;
	

	//获取用户收藏的网址
	public List<Web> myweb(Web web)throws SQLException;
	
	//通过网址ID查询网址
	public List<Web> oneweb(Web web)throws SQLException;

	//查看所有收录的网址
	public List<Web> allweb() throws SQLException;
}
