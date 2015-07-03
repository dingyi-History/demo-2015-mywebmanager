package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.ShareWeb;

public interface IShareWebDao {

	// 进行网址分享
	public boolean addshareweb(ShareWeb sw) throws SQLException;

	// 删除分享的网址
	public boolean delshareweb(ShareWeb sw) throws SQLException;

	// 进行修改分享的网址内容
	public boolean updateshareweb(ShareWeb sw) throws SQLException;

	// 获取用户分享出来的网址ID
	public List<ShareWeb> shareweb() throws SQLException;

	// 用户查看自己分享的网址
	public List<ShareWeb> myshareweb(ShareWeb sw) throws SQLException;

}
