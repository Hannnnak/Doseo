package member.service;

import member.MODEL.Member;

public class MemberData {

	private Member member;

	public MemberData(Member member) {
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "MemberData [member=" + member + "]";
	}
	
}
