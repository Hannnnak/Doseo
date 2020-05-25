package qna.service;
import java.util.List;

import qna.MODEL.Qna;

public class QnaPage {

	private int total;				//�쟾泥닿쾶�떆臾쇱닔  100
	private int currentPage;		//蹂닿퀬�떢���럹�씠吏�  3
	private List<Qna> qContents;	//�솕硫댁뿉 異쒕젰�븷 寃뚯떆湲� 紐⑸줉 10
	private int totalPages;			//�쟾泥� �럹�씠吏��닔 10
	private int startPage;			//�떆�옉 �럹�씠吏�踰덊샇 [12345] [6789 10]
	private int endPage;			//�걹 �럹�씠吏�踰덊샇
	
	public QnaPage(int total, int currentPage, int size, List<Qna> qContents) {
		this.total = total;
		this.currentPage = currentPage;
		this.qContents = qContents;
		if (total == 0) { //�벑濡앸맂 寃뚯떆湲��씠 0嫄댁씪寃쎌슦  m506-292-40
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else { //�벑濡앸맂 寃뚯떆湲��씠 1嫄댁씠�긽 議댁옱�븳�떎硫� 
			totalPages = total / size; // 10=109/10  9  
		    //�쟾泥� �럹�씠吏��닔  = �쟾泥닿쾶�떆臾쇱닔 /�븳�럹�씠吏��떦 寃뚯떆湲��닔;
			if (total % size > 0) {
				totalPages++;  //�굹癒몄� 寃뚯떆臾쇱쓣 異쒕젰�븯湲곗쐞�븳 �럹�씠吏�瑜� 異붽�
			}
			
			//�븘�옒�쓽 5媛믪�  �븳踰덉뿉 異쒕젰�븯怨� �떢�� �럹�씠吏�媛쒖닔瑜� �쑜�븳�떎
			int modVal = currentPage % 5;   //蹂닿퀬�떢���럹�씠吏�10%5  1 2 3 4
			startPage = currentPage / 5 * 5 + 1; //�떆�옉�럹�씠吏�=10/5*5+1
		   //�떆�옉 �럹�씠吏�踰덊샇=   蹂닿퀬�떢���럹�씠吏� / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5; //startPage=startPage-5
			
			endPage = startPage + 4;
		  //�걹 �럹�씠吏�踰덊샇= �떆�옉 �럹�씠吏�踰덊샇  + 4      

			//�걹�럹�씠吏�踰덊샇媛�   �떎�젣珥앺럹�씠吏��닔蹂대떎 �겕寃� �릺硫�
			//�걹�럹�씠吏�踰덊샇瑜�  �떎�젣珥앺럹�씠�닔濡� 議곗젙�븯�뿬
			//鍮꾩뼱�엳�뒗 �럹�씠吏�媛� 諛쒖깮�릺吏� �븡�룄濡� �븳�떎
			if (endPage > totalPages) endPage = totalPages;
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Qna> getqContents() {
		return qContents;
	}

	public void setqContents(List<Qna> qContents) {
		this.qContents = qContents;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean hasNoQnas() {
		return total == 0;
	}

	public boolean hasQnas() {
		return total > 0;
	}
	

	@Override
	public String toString() {
		return "QnaPage [total=" + total + ", currentPage=" + currentPage + ", qContents=" + qContents + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
	
	
	
	
	
	
	
	
}