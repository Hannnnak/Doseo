package cart.MODEL;

public class SelectAddress {
	private String memberID;
	private String name;
	private int phone;
	private String address;
	
	public SelectAddress(String memberID, String name, int phone, String address) {
		this.memberID=memberID;
		this.name=name;
		this.phone=phone;
		this.address=address;
	}
	
	public SelectAddress() {
	}

	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SelectAddress [memberID=" + memberID + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ "]";
	}
		
}
