package order.MODEL;

public class AddressList {
	private int aNo;
	private String memberID;
	private String wAddress;
	
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getwAddress() {
		return wAddress;
	}
	public void setwAddress(String wAddress) {
		this.wAddress = wAddress;
	}

	@Override
	public String toString() {
		return "AddressList [aNo=" + aNo + ", memberID=" + memberID + ", wAddress=" + wAddress + "]";
	}
	
	
}
