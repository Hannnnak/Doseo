package qna.MODEL;

public class QnaContent {
	
		private int qNo;
		private String qContents;
		
		public QnaContent(int qNo , String qContents  ) {
			this.qNo = qNo ;
			this.qContents = qContents; 
		}

		public int getqNo() {
			return qNo;
		}

		public void setqNo(int qNo) {
			this.qNo = qNo;
		}

		public String getqContents() {
			return qContents;
		}

		public void setqContents(String qContents) {
			this.qContents = qContents;
		}
}
