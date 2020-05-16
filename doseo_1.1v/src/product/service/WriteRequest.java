package product.service;

import java.util.Date;
import java.util.Map;

//상품등록에 필요한 데이터를 제공하는 클래스
public class WriteRequest {
	
	private String pName;
	private String category;
	private int pPrice;
	private int discount;
	private String writer;
	private String publishing;
	private String imageFileURL;
	private String pDate;
	private String detailContent;
	
	public WriteRequest(String pName, String category, int pPrice, int discount, String writer,
			String publishing, String imageFileURL, String pDate, String detailContent) {
		
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




	public String getpName() {
		return pName;
	}

	public String getCategory() {
		return category;
	}

	public int getpPrice() {
		return pPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public String getWriter() {
		return writer;
	}

	public String getPublishing() {
		return publishing;
	}

	public String getImageFileURL() {
		return imageFileURL;
	}

	public String getbDate() {
		return pDate;
	}

	public String getDetailContent() {
		return detailContent;
	}


	
	public void validate(Map<String, Boolean> errors) {
		if(pName==null || pName.trim().isEmpty() ) {
			errors.put("pName", Boolean.TRUE);
		}
	}

}
