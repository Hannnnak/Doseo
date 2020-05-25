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
	private String phone1; 	//phone1 컬럼용
	private String phone2; 	//phone2 컬럼용
	private String phone3; 	//phone3 컬럼용
	private String email;	//email 컬럼용
	private String favorite1;//favorite 컬럼용
	private String favorite2;//favorite 컬럼용
	private String favorite3;//favorite 컬럼용
	private String address; //address 컬럼용
	
	//생성
	public Member() {}
	
	public Member(String id) {
		this.id = id;
	}
	
	public Member(String id, String password, String name, String gender, String birth,
			Date regDate, String phone1, String phone2, String phone3, String email,
			String favorite1, String favorite2, String favorite3, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.regDate = regDate;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email = email;
		this.favorite1 = favorite1;
		this.favorite2 = favorite2;
		this.favorite3 = favorite3;
		this.address = address;
	}

	
	public Member(String mname, String mgender, String mbirth, String mphone1, String mphone2, String mphone3,
			String memail, String mfavorite1, String mfavorite2, String mfavorite3, String maddress, String mid) {
		this.name = mname;
		this.gender = mgender;
		this.birth = mbirth;
		this.phone1 = mphone1;
		this.phone2 = mphone2;
		this.phone3 = mphone3;
		this.email = memail;
		this.favorite1 = mfavorite1;
		this.favorite2 = mfavorite2;
		this.favorite3 = mfavorite3;
		this.address = maddress;
		this.id = mid;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
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







