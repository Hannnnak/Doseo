package qna.service;

import java.util.Map;


import qna.MODEL.Writer;

public class WriteRequest {
	
	private Writer writer;		//writer_id 컬럼용,writer_name 컬럼용
	private String qTitle;		//title컬럼용	 
	private String qContents;		//qContents컬럼용 

	public WriteRequest(Writer writer,String qTitle,String qContents) {
		this.writer		=writer;
		this.qTitle		=qTitle;
		this.qContents	=qContents;
		
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
	
//	@Override
//	public String toString() {
//		return "WriteRequest [writer=" + this.writer + ", qTitle=" + qTitle + ", qContentss=" + qContents + "]";
//	}

	//p638 31
	//title이 null인지에대한 체크=>유효성검사
	public void validate(Map<String, Boolean> errors) {
		if( qTitle==null || qTitle.trim().isEmpty() ) {
			errors.put("title",Boolean.TRUE);
		}
	}
}



