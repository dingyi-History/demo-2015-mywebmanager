package dao_interface;

import java.sql.SQLException;
import java.util.List;

import entity.ShareWeb;

public interface IShareWebDao {

	// ������ַ����
	public boolean addshareweb(ShareWeb sw) throws SQLException;

	// ɾ���������ַ
	public boolean delshareweb(ShareWeb sw) throws SQLException;

	// �����޸ķ������ַ����
	public boolean updateshareweb(ShareWeb sw) throws SQLException;

	// ��ȡ�û������������ַID
	public List<ShareWeb> shareweb() throws SQLException;

	// �û��鿴�Լ��������ַ
	public List<ShareWeb> myshareweb(ShareWeb sw) throws SQLException;

}
