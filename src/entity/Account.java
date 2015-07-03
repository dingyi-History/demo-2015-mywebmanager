package entity;

public class Account {
	private String acid;
	private String acname;
	private String acpwd;
	private String acuid;
	private String actitle;
	
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getAcpwd() {
		return acpwd;
	}
	public void setAcpwd(String acpwd) {
		this.acpwd = acpwd;
	}
	public String getAcuid() {
		return acuid;
	}
	public void setAcuid(String acuid) {
		this.acuid = acuid;
	}
	public String getActitle() {
		return actitle;
	}
	public void setActitle(String actitle) {
		this.actitle = actitle;
	}
	@Override
	public String toString() {
		return "Account [acid=" + acid + ", acname=" + acname + ", acpwd="
				+ acpwd + ", acuid=" + acuid + ", actitle=" + actitle
				+ ", getAcid()=" + getAcid() + ", getAcname()=" + getAcname()
				+ ", getAcpwd()=" + getAcpwd() + ", getAcuid()=" + getAcuid()
				+ ", getActitle()=" + getActitle() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
