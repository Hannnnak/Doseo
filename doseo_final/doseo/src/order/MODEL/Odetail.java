package order.MODEL;

public class Odetail {
	private int oNo;
	private int dpNo;
	private int pNo;
	private String dPrice;
	private int quantity;
	private String total;
	
	public Odetail(int oNo, int dpNo, int pNo, String dPrice, int quantity, String total) {
		this.oNo=oNo;
		this.dpNo=dpNo;
		this.pNo=pNo;
		this.dPrice=dPrice;
		this.quantity=quantity;
		this.total=total;
	}
	
	public int getoNo() {
		return oNo;
	}
	public void setoNo(int oNo) {
		this.oNo = oNo;
	}
	public int getDpNo() {
		return dpNo;
	}
	public void setDpNo(int dpNo) {
		this.dpNo = dpNo;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getdPrice() {
		return dPrice;
	}
	public void setdPrice(String dPrice) {
		this.dPrice = dPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
}
