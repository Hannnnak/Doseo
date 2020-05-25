package auth.service;

//p604
//LoginService에서 로그인성공시
//로그인한 회원의  정보를 담기위한 클래스
public class Find {
	private String id; 		//memberid
	private String email;		
	private String name;	//회원명
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Find(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Find(String id,String email, String name) {
		this.id=id;
		this.email   = email;
		this.name = name;
	}
	
	public Find(String id, String email, String name, String password) {
		this.id=id;
		this.email   = email;
		this.name = name;
		this.password = password;
		
	}
	

	public String getEmail() {
		return email;
	}

	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Findpw [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
}
