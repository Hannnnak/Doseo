package order.MODEL;

public class OrderList {
	private int oNo;
	private String memberID;
	private int bNo;
	private String orderDate;
	private String address;
	private String requests;
	
	public OrderList(int oNo, String memberID, int bNo, String orderDate, String address, String requests) {
		this.oNo=oNo;
		this.memberID=memberID;
		this.bNo=bNo;
		this.address=address;
		this.requests=requests;
	}
	public OrderList() {
	}
	public int getoNo() {
		return oNo;
	}
	public void setoNo(int oNo) {
		this.oNo = oNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequests() {
		return requests;
	}
	public void setRequests(String requests) {
		this.requests = requests;
	}
	
	
}
