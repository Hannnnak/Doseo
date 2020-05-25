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
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	private String favorite1;
	private String favorite2;
	private String favorite3;
//	private String[] favorite;
	private String address;
	
	
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


/*	public String[] getFavorite() {
		return favorite;
	}
	public void setFavorite(String[] favorite) {
		this.favorite = favorite;
	}
*/	
	
	public String getFavorite1() {
		return favorite1;
	}
	public void setFavorite1(String favorite1) {
		this.favorite1 = favorite1;
	}
	public String getFavorite2() {
		return favorite2;
	}
	public void setFavorite2(String favorite2) {
		this.favorite2 = favorite2;
	}
	public String getFavorite3() {
		return favorite3;
	}
	public void setFavorite3(String favorite3) {
		this.favorite3 = favorite3;
	}
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
		checkEmpty(errors, birth, "birth");
		checkEmpty(errors, phone1, "phone1");
		checkEmpty(errors, phone2, "phone2");
		checkEmpty(errors, phone3, "phone3");
		checkEmpty(errors, email, "email");
		checkEmpty(errors, address, "address");
		
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







