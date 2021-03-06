package vo;

import java.util.Date;

public class ProductVO {

	private int pNo;
	private String pName;
	private String category;
	private int pPrice;
	private int discount;
	private String writer;
	private String publishing;
	private String imageFileURL;
	private Date bDate;
	private String detailContent;
	private boolean exp;
	
	
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public String getImageURL() {
		return imageFileURL;
	}
	public void setImageURL(String imageURL) {
		this.imageFileURL = imageURL;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getDetailCon() {
		return detailContent;
	}
	public void setDetailCon(String detailCon) {
		this.detailContent = detailCon;
	}
	public boolean isExp() {
		return exp;
	}
	public void setExp(boolean exp) {
		this.exp = exp;
	}
	
}
