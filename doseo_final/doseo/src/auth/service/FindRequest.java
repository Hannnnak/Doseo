package auth.service;

import java.util.Map;

//p594
//JoinRequest는 유저가 입력한 폼(joinForm.jsp)의 내용을
//이 클래스의 객체로 담아서
//JoinService전달 
public class FindRequest {

	//변수
	private String id;

	private String name;

	private String email;
	
	private String password;

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, email, "email");
		checkEmpty(errors, password, "password");
		
	}
	
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}

	
	
}







