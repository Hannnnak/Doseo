package product.service;

import java.util.List;

import product.model.Product;


public class ProductPage {
	private int total;				//전체게시물수  
	private int currentPage;		//보고싶은페이지  3
	private List<Product> content;	//화면에 출력할 게시글 목록 10
	private int totalPages;			//전체 페이지수 10
	private int startPage;			//시작 페이지번호 [12345] [6789 10]
	private int endPage;			//끝 페이지번호

	//ProductPage(전체게시물수, 보고싶은페이지,한페이지당 게시글수, List<Product> content)
	public ProductPage(int total, int currentPage, int size, List<Product> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if (total == 0) { //등록된 게시글이 0건일경우
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else { //등록된 게시글이 1건이상 존재한다면 
			totalPages = total / size; // 10=109/10  9  
		    //전체 페이지수  = 전체게시물수 /한페이지당 게시글수;
			if (total % size > 0) {
				totalPages++;  //나머지 게시물을 출력하기위한 페이지를 추가
			}
			
			//아래의 5값은  한번에 출력하고 싶은 페이지개수를 뜻한다
			int modVal = currentPage % 5;   //보고싶은페이지10%5  1 2 3 4
			startPage = currentPage / 5 * 5 + 1; //시작페이지=10/5*5+1
		   //시작 페이지번호=   보고싶은페이지 / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5; //startPage=startPage-5
			
			endPage = startPage + 4;
		  //끝 페이지번호= 시작 페이지번호  + 4      

			//끝페이지번호가   실제총페이지수보다 크게 되면
			//끝페이지번호를  실제총페이수로 조정하여
			//비어있는 페이지가 발생되지 않도록 한다
			if (endPage > totalPages) endPage = totalPages;
		}
	}

	public int getTotal() {
		return total;
	}

	public boolean hasNoProducts() {
		return total == 0;
	}

	public boolean hasProducts() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<Product> getContent() {
		return content;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
}
