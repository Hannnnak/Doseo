package member.service;

import java.util.Map;

//p594
//JoinRequest는 유저가 입력한 폼(joinForm.jsp)의 내용을
//이 클래스의 객체로 담아서
//JoinService전달 
public class JoinRequest {

	//변수
	private String id;
	private String password;
	private String confirmPassword;
	private String name;
	private String gender;
	private String birth;
	private String phone;
	private String email;
	private String favorite;
//	private String[] favorite;
	private String address;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

/*	public String[] getFavorite() {
		return favorite;
	}
	public void setFavorite(String[] favorite) {
		this.favorite = favorite;
	}
*/	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public boolean isPasswordEqualToConfirm() {
		// TODO Auto-generated method stub
		return password != null && password.equals(confirmPassword);
	}
	
	
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}

	
	//생성자
	
	/*
	 * 
	 * public String getId() { return id; }
	 * 
	 * 
	 * public void setId(String id) { this.id = id; }
	 * 
	 * 
	 * public String getName() { return name; }
	 * 
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * 
	 * public String getConfirmPassword() { return confirmPassword; }
	 * 
	 * 
	 * public void setConfirmPassword(String confirmPassword) { this.confirmPassword
	 * = confirmPassword; }
	 */
	//함수
	//P594 44~595 끝
	
	
}







