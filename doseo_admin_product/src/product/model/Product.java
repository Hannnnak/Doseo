package product.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Product {
	
	private Integer pNo;
	private String pName;
	private String category;
	private int pPrice;
	private int discount;
	private String writer;
	private String publishing;
	private String imageFileURL;
	private String pDate;
	private String detailContent;
	

	public Product(Integer newNum, String pName, String category, int pPrice, int discount, String writer,
			String publishing, String imageFileURL, String pDate, String detailContent) {
		this.pNo=newNum;
		this.pName=pName;
		this.category=category;
		this.pPrice=pPrice;
		this.discount=discount;
		this.writer=writer;
		this.publishing=publishing;
		this.imageFileURL=imageFileURL;
		this.pDate=pDate;
		this.detailContent=detailContent;
	}
	
	
	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
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
	public String getImageFileURL() {
		return imageFileURL;
	}
	public void setImageFileURL(String imageFileURL) {
		this.imageFileURL = imageFileURL;
	}
	public String getpDate() {
		return pDate;
	}
	
	public String getDetailContent() {
		return detailContent;
	}
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}



	
}
