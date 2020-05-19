package order.MODEL;

//여기에서는 db의 orderlist테이블과 관련한 데이터를 담는 클래스
//VO(Value Object)
//DTO(Data Transfer Object)
//OrderVO
//OrderDTO
public class Order {
	private String oNo;
	private String memberId;
	private String bNo;
	private String orderDate;
	private String address;
	private String requests;
	
	public Order(String oNo, String memberId, String bNo, String orderDate, String address, String requests) {
		this.oNo = oNo;
		this.memberId = memberId;
		this.bNo = bNo;
		this.orderDate = orderDate;
		this.address = address;
		this.requests = requests;
	}
	
	public String getoNo() {
		return oNo;
	}
	public void setoNo(String oNo) {
		this.oNo = oNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
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
	@Override
	public String toString() {
		return "Order [oNo=" + oNo + ", memberId=" + memberId + ", bNo=" + bNo + ", orderDate=" + orderDate
				+ ", address=" + address + ", requests=" + requests + "]";
	}
	
	
	
}
