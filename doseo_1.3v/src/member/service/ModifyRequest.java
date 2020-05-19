package member.service;

public class ModifyRequest {
	//ModifyRequest는 유저가 입력한 폼(joinForm.jsp)의 내용을
	//이 클래스의 객체로 담아서
	//JoinService전달
	private String mname;
	private String mgender;
	private String mbirth;
	private String mphone;
	private String memail;
	private String mfavorite;
	private String maddress;
	private String mid;
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMfavorite() {
		return mfavorite;
	}
	public void setMfavorite(String mfavorite) {
		this.mfavorite = mfavorite;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
	
	
}
