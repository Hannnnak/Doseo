package article.service;

import article.MODEL.Article;
import article.MODEL.ArticleContent;

//p657
//article테이블과 article_content테이블의 결과를 
//하나의 객체로 묶어주는 클래스
public class ArticleData {

	private Article article;
	private ArticleContent content;
	
	public ArticleData(Article article,
			ArticleContent content) {
		this.article = article;
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleContent getContent() {
		return content;
	}

	public void setContent(ArticleContent content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ArticleData [article=" + article + ", content=" + content + "]";
	}
	
	
}









