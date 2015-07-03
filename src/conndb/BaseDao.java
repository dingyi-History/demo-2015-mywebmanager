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

//basedao��װ�˶����ݿ�������Է��ص�����ֵ��һ�����о������ݼ��ϵģ�һ����ֱ���ж���û�гɹ�������,�������Խ�Լ�ܶ��������
public class BaseDao {
	
	Connection conn = null;
	PreparedStatement ps;

	//ͳһ�Ľ���жϷ���boolean
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
		
		//��������ʵ���༯��
		// ���ط������ַ�Ķ��󼯺�
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
			
			// ������ַ�Ķ��󼯺�
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
			

			// �����û��Ķ��󼯺�
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
			

			// �����˺ŵĶ��󼯺�
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
			

			// ���ع���Ա�Ķ��󼯺�
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
	// ����ֵΪ����������ݿ��������rs
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
				conn.rollback();// ���ݿ�����ع�
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}

	// �����ڷ��ؾ���ֵ�����ݿ��������int������ֵ�ж�Ӱ�����ݵĵ�����,��������ɾ����Ӱ�������
	// ����ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
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
				conn.rollback();// ���ݿ�����ع�
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return -1;
	}

	


	
	// �ر����ݿ�����
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