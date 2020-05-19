package article.service;

import java.util.Map;

//p666
//게시글 수정시 필요한
//수정할 게시글번호,사용자id,제목,내용 데이터가를 담는 클래스
public class ModifyRequest {

	private int articleNumber;	//게시글번호
	private String userId;	//사용자id
	private String title;//제목
	private String content;//내용
	
	public ModifyRequest(String id, int no, 
			String title, String content) {
		userId 		  = id;
		articleNumber = no;
		this.title    = title;
		this.content  = content;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ModifyRequest [articleNumber=" + articleNumber + ", userId=" + userId + ", title=" + title
				+ ", content=" + content + ", getArticleNumber()=" + getArticleNumber() + ", getUserId()=" + getUserId()
				+ ", getTitle()=" + getTitle() + ", getContent()=" + getContent() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	//P667 35
	//title데이터가 없으면 error
	public void validate(Map<String, Boolean> errors) {
		if( title==null || title.trim().isEmpty() ) {
			errors.put("title", Boolean.TRUE);
		}
	}
	
}
















