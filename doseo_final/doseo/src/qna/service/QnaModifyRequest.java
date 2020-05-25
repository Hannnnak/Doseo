package qna.service;

import java.util.Map;


public class QnaModifyRequest {
	
	private String MemberID;
	private int 	qNo;
	private String qTitle;
	private String qContents;
	
	public QnaModifyRequest(String MemberID,int 	qNo, String qTitle, String qContents) {
		System.out.println("request들어옴");
		this.MemberID = MemberID;
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qContents = qContents;
		System.out.println("this.qNo = "+ qNo);
		System.out.println("this.qTitle = "+ qTitle);
		System.out.println("this.qContents = " +qContents );
	}
	
	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String memberID) {
		MemberID = memberID;
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
	
	public void vaildate(Map<String,Boolean> errors) {
		if(qTitle == null || qTitle.trim().isEmpty())	{
			errors.put("qTitle", Boolean.TRUE);
			
		}
	} 
	
}
