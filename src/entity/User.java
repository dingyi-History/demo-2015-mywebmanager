package entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class User {
	private String uid;
	private String uname;
	private String upwd;
	private String unickname;
	private String uqq;
	private String uemail;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@NotEmpty(message="�û�������Ϊ��")
	@Range(min=3,max=16,message="�û���������3��16λ֮��")
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@NotEmpty(message="���벻��Ϊ��")
	@Range(min=6,max=16,message="���볤�ȱ�����6��16λ֮��")
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	@NotEmpty(message="�ǳƲ���Ϊ��")
	public String getUnickname() {
		return unickname;
	}
	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}
	public String getUqq() {
		return uqq;
	}
	public void setUqq(String uqq) {
		this.uqq = uqq;
	}
	 @Email(message="�����ʽ����ȷ")
	 public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", unickname=" + unickname + ", uqq=" + uqq + ", uemail="
				+ uemail + ", getUid()=" + getUid() + ", getUname()="
				+ getUname() + ", getUpwd()=" + getUpwd() + ", getUnickname()="
				+ getUnickname() + ", getUqq()=" + getUqq() + ", getUemail()="
				+ getUemail() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
