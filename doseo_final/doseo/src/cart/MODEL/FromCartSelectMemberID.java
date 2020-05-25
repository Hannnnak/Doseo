package cart.MODEL;

public class FromCartSelectMemberID {
	private int bNo;
	private String memberID;
	private String pName;
	private int price;
	private int dPrice;
	private int quantity;
	
	public FromCartSelectMemberID(int bNo, String memberID, String pName, int price, int dPrice, int quantity) {
		this.bNo=bNo;
		this.memberID=memberID;
		this.pName=pName;
		this.price=price;
		this.dPrice=dPrice;
		this.quantity=quantity;
	}

	public FromCartSelectMemberID() {
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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FromCartSelectMemberID [memberID=" + memberID + ", pName=" + pName + ", price=" + price + ", dPrice="
				+ dPrice + ", quantity=" + quantity + "]";
	}

	
}
