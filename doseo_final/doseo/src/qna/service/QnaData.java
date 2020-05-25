package qna.service;

import qna.MODEL.Qna;

public class QnaData {
	
		private Qna qna;
		
		public QnaData(Qna qna) {
			this.qna = qna;
		}

		public Qna getQna() {
			return qna;
		}

		public void setQna(Qna qna) {
			this.qna = qna;
		}
		
		

}
