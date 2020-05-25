package qna.MODEL;

//p630
//WriteRequest �겢�옒�뒪�뿉�꽌 �궗�슜�븯�뒗 �뜲�씠�꽣瑜� �젣怨듯븯�뒗 �슜�룄�쓽 �겢�옒�뒪

public class Writer {
	
	private String memberID;				
//	private  String name;
	
	public Writer(String memberID) {
		this.memberID = memberID;
//		this.name = name;
	}

	public String getmemberID() {
		return memberID;
	}

	public void setmemberID(String memberID) {
		this.memberID = memberID;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	
}
