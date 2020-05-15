package member.MODEL;

//여기에서는 db의 member테이블과 관련한 데이터를 담는 클래스
//VO(Value Object)
//DTO(Data Transfer Object)
//MemeberVO
//MemberDTO
public class Member {
	//변수
	private String memberId;
	private String memberPw;
	private String name;
	private String gender;
	private String birth;
	private String enrollDate;
	private String phone;
	private String email;
	private String favorite;
	private String address;
	
	public Member(String memberId, String memberPw, String name, String gender, String birth, String enrollDate,
			String phone, String email, String favorite, String address) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.enrollDate = enrollDate;
		this.phone = phone;
		this.email = email;
		this.favorite = favorite;
		this.address = address;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
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
	public void setFavortie(String favorite) {
		this.favorite = favorite;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//비밀번호 일치여부 체크
	public boolean matchPassword(String pwd) {
		return  this.memberPw.equals(pwd);
	}

	//p619 20
	public void changePassword(String newPwd) {
		this.memberPw = newPwd;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", gender=" + gender
				+ ", birth=" + birth + ", enrollDate=" + enrollDate + ", phone=" + phone + ", email=" + email
				+ ", favortie=" + favorite + ", address=" + address + "]";
	}	
	
}