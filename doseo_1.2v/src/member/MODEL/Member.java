package member.MODEL;

import java.util.Date;

//p591
//여기에서는 db의 member테이블과 관련한 데이터를 담는 클래스
//VO(Value Object)
//DTO(Data Transfer Object)
//MemeberVO
//MemberDTO
public class Member {
	//변수
	private String id;		//memberID 컬럼용
	private String password;//memberPW 컬럼용
	private String name;	//name 컬럼용
	private String gender;	//gender 컬럼용
	private String birth;	//birth 컬럼용
	private Date   regDate; //enrolldate 컬럼용
	private String phone; 	//phone 컬럼용
	private String email;	//email 컬럼용
	private String favorite;//favorite 컬럼용
	private String address; //address 컬럼용
	
	//생성
	public Member() {}
	
	public Member(String id, String password, String name, String gender, String birth,
			Date regDate, String phone, String email, String favorite, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.regDate = regDate;
		this.phone = phone;
		this.email = email;
		this.favorite = favorite;
		this.address = address;
	}


	//setter & getter
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
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
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//p592 35~37
	//비밀번호 일치여부 체크
	public boolean matchPassword(String pwd) {
		return  this.password.equals(pwd);
	}

	//p619 20
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", regDate=" + regDate + "]";
	}
	
	
	
}







