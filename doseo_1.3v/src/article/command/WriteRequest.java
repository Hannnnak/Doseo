package article.command;

import java.util.Map;

import article.MODEL.Writer;

//p637
//글입력에 필요한 데이터를 제공
/*
insert into article(writer_id,writer_name,title,regdate,moddate,read_cnt)
values(writer_id?,writer_name?,title?,regdate?,moddate?,0);

insert into article_content(article_no,content)
values(article_no?,content?);
 */
public class WriteRequest {
	
	/*
	private String id;  	//writer_id 컬럼용
	private String name; 	//writer_name 컬럼용
	위의 2속성에 해당하는 부분을
	Wrtier클래스 변수로 코드를 교재에서 작성하였다  p637 9*/
	private Writer writer;		//writer_id 컬럼용,writer_name 컬럼용
	private String title;		//title컬럼용	 
	private String content;		//content컬럼용 
	
	
	//WriteRequest(String writer_id,String writer_name,String title,String content) {
	WriteRequest(Writer writer,String title,String content) {
		//this.writer_id	=writer_id;
		//this.writer_name=writer_name;
		this.writer		=writer;
		this.title		=title;
		this.content	=content;
	}
	
	
	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
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
	
	//p638 31
	//title이 null인지에대한 체크=>유효성검사
	public void validate(Map<String, Boolean> errors) {
		if( title==null || title.trim().isEmpty() ) {
			errors.put("title",Boolean.TRUE);
		}
	}
}







