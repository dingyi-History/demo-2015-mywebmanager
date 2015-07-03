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
	@NotEmpty(message="用户名不能为空")
	@Range(min=3,max=16,message="用户名必须在3到16位之间")
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@NotEmpty(message="密码不能为空")
	@Range(min=6,max=16,message="密码长度必须在6到16位之间")
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	@NotEmpty(message="昵称不能为空")
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
	 @Email(message="邮箱格式不正确")
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
