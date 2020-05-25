package qna.service;

import java.util.Map;

public class DeleteQnaRequest {
	private String memberID;
	private int qNo;
	private String qTitle;
	private String qContents;
	
	public DeleteQnaRequest(
			String memberID, int qNo, String qTitle,String qContents){
		this.memberID = memberID;
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qContents = qContents;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
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

	public void validate(Map<String, Boolean> errors) {
		if (qTitle == null || qTitle.trim().isEmpty()) {
			errors.put("qTitle", Boolean.TRUE);
		}
	}
}
