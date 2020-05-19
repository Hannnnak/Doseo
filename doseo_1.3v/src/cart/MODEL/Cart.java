package cart.MODEL;

public class Cart {
	private int bNo;
	private String memberID;
	private int pNO;
	private int quantity;
	private int price;
	private int dPrice;
	private String pDate;
	
	public Cart(int bNo, String memberID, int pNO, int quantity, int price, int dPrice, String pDate) {
		this.bNo=bNo;
		this.memberID=memberID;
		this.pNO=pNO;
		this.quantity=quantity;
		this.price=price;
		this.dPrice=dPrice;
		this.pDate=pDate;		
	}
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getpNO() {
		return pNO;
	}
	public void setpNO(int pNO) {
		this.pNO = pNO;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getdPrice() {
		return dPrice;
	}
	public void setdPrice(int dPrice) {
		this.dPrice = dPrice;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public boolean matchBNo(int curQuantity) {
		return false;
	}

	public int changeQuantity(int newQuantity) {
		return newQuantity;
	}
	
	
}
