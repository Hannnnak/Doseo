package member.service;

//JoinRequest는 유저가 입력한 폼(joinForm.jsp)의 내용을
//이 클래스의 객체로 담아서
//JoinService전달
public class JoinRequest {

	private String jmemberId;
	private String jmemberPw;
	private String jname;
	private String jgender;
	private String jbirth;
	private String jenrollDate;
	private String jphone;
	private String jemail;
	private String jfavorite;
	private String jaddress;
	public String getJmemberId() {
		return jmemberId;
	}
	public void setJmemberId(String jmemberId) {
		this.jmemberId = jmemberId;
	}
	public String getJmemberPw() {
		return jmemberPw;
	}
	public void setJmemberPw(String jmemberPw) {
		this.jmemberPw = jmemberPw;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJgender() {
		return jgender;
	}
	public void setJgender(String jgender) {
		this.jgender = jgender;
	}
	public String getJbirth() {
		return jbirth;
	}
	public void setJbirth(String jbirth) {
		this.jbirth = jbirth;
	}
	public String getJenrollDate() {
		return jenrollDate;
	}
	public void setJenrollDate(String jenrollDate) {
		this.jenrollDate = jenrollDate;
	}
	public String getJphone() {
		return jphone;
	}
	public void setJphone(String jphone) {
		this.jphone = jphone;
	}
	public String getJemail() {
		return jemail;
	}
	public void setJemail(String jemail) {
		this.jemail = jemail;
	}
	public String getJfavorite() {
		return jfavorite;
	}
	public void setJfavorite(String jfavorite) {
		this.jfavorite = jfavorite;
	}
	public String getJaddress() {
		return jaddress;
	}
	public void setJaddress(String jaddress) {
		this.jaddress = jaddress;
	}
	

	
	
	
}







