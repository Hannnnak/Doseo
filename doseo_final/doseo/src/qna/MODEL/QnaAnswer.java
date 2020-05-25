package qna.MODEL;

public class QnaAnswer {
	
		private int qNo;
		private String answer;
		
		public QnaAnswer(int qNo , String answer  ) {
			this.qNo = qNo ;
			this.answer = answer;
		}

		public int getqNo() {
			return qNo;
		}

		public void setqNo(int qNo) {
			this.qNo = qNo;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}
}
