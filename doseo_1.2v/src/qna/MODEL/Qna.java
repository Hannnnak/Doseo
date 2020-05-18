package qna.MODEL;

import java.util.Date;

public class Qna {
	
	private int qNo;
	private Writer writer;
	private String qTitle;
	private String qContents;
	private Date 	qDate;
	private int readCount;

	public Qna ( int qNo , Writer writer , String qTitle, String qContents, Date qDate, int readCount ) {
		this.qNo = qNo;
		this.writer = writer;
		this.qTitle = qTitle;
		this.qContents = qContents;
		this.qDate = qDate;
		this.readCount = readCount;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContents() {
		return qContents;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
	}

	public Date getqDate() {
		return qDate;
	}

	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Qna [qNo=" + qNo + ", writer=" + writer + ", qTitle=" + qTitle + ", qContents=" + qContents + ", qDate="
				+ qDate + ", readCount=" + readCount + "]";
	}

	
	
}
