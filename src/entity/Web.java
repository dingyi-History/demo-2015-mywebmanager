package entity;

public class Web {
	
	private String wid;
	private String wname;
	private String wurl;
	private String wuid;
	
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWurl() {
		return wurl;
	}
	public void setWurl(String wurl) {
		this.wurl = wurl;
	}
	public String getWuid() {
		return wuid;
	}
	public void setWuid(String wuid) {
		this.wuid = wuid;
	}
	@Override
	public String toString() {
		return "Web [wid=" + wid + ", wname=" + wname + ", wurl=" + wurl
				+ ", wuid=" + wuid + ", getWid()=" + getWid() + ", getWname()="
				+ getWname() + ", getWurl()=" + getWurl() + ", getWuid()="
				+ getWuid() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
