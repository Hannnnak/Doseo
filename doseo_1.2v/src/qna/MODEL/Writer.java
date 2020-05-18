package qna.MODEL;

//p630
//WriteRequest 클래스에서 사용하는 데이터를 제공하는 용도의 클래스

public class Writer {
	
	private String memberID;				
	private  String name;
	
	public Writer(String memberID, String name) {
		this.memberID = memberID;
		this.name = name;
	}

	public String getmemberID() {
		return memberID;
	}

	public void setmemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
