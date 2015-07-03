package entity;

public class ShareWeb {

	private String sid;
	private String swid;
	private String suid;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSwid() {
		return swid;
	}
	public void setSwid(String swid) {
		this.swid = swid;
	}
	public String getSuid() {
		return suid;
	}
	public void setSuid(String suid) {
		this.suid = suid;
	}
	@Override
	public String toString() {
		return "ShareWeb [sid=" + sid + ", swid=" + swid + ", suid=" + suid
				+ ", getSid()=" + getSid() + ", getSwid()=" + getSwid()
				+ ", getSuid()=" + getSuid() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
