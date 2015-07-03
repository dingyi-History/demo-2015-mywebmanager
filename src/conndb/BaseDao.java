package conndb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.Admin;
import entity.ShareWeb;
import entity.User;
import entity.Web;

//basedao封装了对数据库操作可以返回的两种值，一个是有具体数据集合的，一种是直接判断有没有成功操作的,这样可以节约很多冗余代码
public class BaseDao {
	
	Connection conn = null;
	PreparedStatement ps;

	//统一的结果判断返回boolean
		public boolean backbool(String sql,String[] param) 
		{
			int i =this.num(sql, param);
			if(i==1)
			{
				return true;
			}
			else{
				return false;
			}
		}
		
		//返回数据实体类集合
		// 返回分享的网址的对象集合
			public  List<ShareWeb> backswlist(String sql, String[] param) throws SQLException {
				ResultSet rs = this.rs(sql, param);
				List<ShareWeb> swlist = new ArrayList<ShareWeb>();
				while (rs.next()) {
					ShareWeb sw = new ShareWeb();
					sw.setSid(rs.getString("sid"));
					sw.setSwid(rs.getString("swid"));
					sw.setSuid(rs.getString("suid"));
					swlist.add(sw);
				}
				return swlist;

				}
			
			// 返回网址的对象集合
			public List<Web> backweblist(String sql, String[] param) throws SQLException {
				ResultSet rs = this.rs(sql, param);
				List<Web> weblist = new ArrayList<Web>();
				while (rs.next()) {
					Web  web= new Web();
					web.setWid(rs.getString("wid"));
					web.setWname(rs.getString("wname"));
					web.setWurl(rs.getString("wurl"));
					web.setWuid(rs.getString("wuid"));
					weblist.add(web);
				}
				return weblist;

			}
			

			// 返回用户的对象集合
			public List<User> backuserlist(String sql, String[] param) throws SQLException {
				ResultSet rs = this.rs(sql, param);
				List<User> userlist = new ArrayList<User>();
				while (rs.next()) {
					User user = new User();
					user.setUid(rs.getString("uid"));
					user.setUname(rs.getString("uname"));
					user.setUnickname(rs.getString("unickname"));
					user.setUemail(rs.getString("uemail"));
					user.setUqq(rs.getString("uqq"));
					userlist.add(user);
				}
				return userlist;

			}
			

			// 返回账号的对象集合
			public List<Account> backaclist(String sql, String[] param) throws SQLException {
				ResultSet rs = this.rs(sql, param);
				List<Account> aclist = new ArrayList<Account>();
				while (rs.next()) {
					Account ac = new Account();
					ac.setAcid(rs.getString("acid"));
					ac.setActitle(rs.getString("actitle"));
					ac.setAcname(rs.getString("acname"));
					ac.setAcpwd(rs.getString("acpwd"));
					ac.setAcuid(rs.getString("acuid"));
					aclist.add(ac);
				}
				return aclist;

			}
			

			// 返回管理员的对象集合
			public List<Admin> backalist(String sql, String[] param) throws SQLException {
				ResultSet rs = this.rs(sql, param);
				List<Admin> alist = new ArrayList<Admin>();
				while (rs.next()) {
					Admin a = new Admin();
					a.setAid(rs.getString("aid"));
					a.setAname(rs.getString("aname"));
					a.setApwd("apwd");
					alist.add(a);
				}
				return alist;

			}
			
			
			
			
			
//-----------------------------------------------------------------------------------------------			
	// 返回值为结果集的数据库操作方法rs
	private ResultSet rs(String sql, String[] param) {

		conn = ConnectionFactory.getInstance().makeConnection();
		try {
			if (conn == null) {
				throw new SQLException("conn is null");
			}
			ps = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ps.setString(i + 1, param[i]);
				}
			}
			return ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();// 数据库事务回滚
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}

	// 不存在返回具体值的数据库操作，用int做返回值判断影响数据的的行数,即做增改删操作影响的行数
	// 用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
	private int num(String sql, String[] param) {

		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			if (conn == null) {
				throw new SQLException("conn is null");
			}
			ps = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ps.setString(i + 1, param[i]);
				}
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();// 数据库事务回滚
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return -1;
	}

	


	
	// 关闭数据库连接
	public void closeall() {
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}