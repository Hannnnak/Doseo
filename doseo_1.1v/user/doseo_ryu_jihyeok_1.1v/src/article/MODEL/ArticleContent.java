package article.MODEL;

//p632
//db의 article_content테이블관련 데이터를 관리하는 클래스
public class ArticleContent {
	 private Integer number;	//article_no컬럼용
	 private String  content;	//content컬럼용
	 
	 public ArticleContent(Integer number,String  content) {
		 this.number = number;
		 this.content= content;
	 }

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ArticleContent [number=" + number + ", content=" + content + "]";
	}
	 
	 
}












