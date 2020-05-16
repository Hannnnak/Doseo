package qna.command;

import java.util.HashMap;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.MODEL.Writer;
import qna.service.WriteQnaService;
import qna.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class WirteQnaHandler implements CommandHandler {
	//View
		private static final String FORM_VIEW = 
				"/view/article/newArticleForm.jsp";
		//Service
		private WriteQnaService writeService = 
				new WriteQnaService();
		
		@Override
		public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("WriteArticleHandler의 process()진입");

			if(request.getMethod().equalsIgnoreCase("GET")) {
				System.out.println("newArticleForm.jsp의 method방식="+request.getMethod());
				return processForm(request,response);
			}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
				System.out.println("newArticleForm.jsp의 method방식="+request.getMethod());
				return processSubmit(request,response);
			}else {
				//405에러
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
				return   null;
			}
			
		}
		
		//GET방식으로  요청이 들어오면  폼(/view/article/newArticleForm.jsp)을 보여주기
		private String processForm(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("WriteArticleHandler의 processForm()호출");
			return FORM_VIEW;
		}

		//P640 35
		//POST방식으로 요청이 들어오면
		private String processSubmit(HttpServletRequest request, 
				HttpServletResponse response) 
				throws Exception {
			System.out.println("WriteArticleHandler의 processSubmit()호출");
			
			Map<String, Boolean> errors = new HashMap();
			request.setAttribute("errors", errors);//3.Model(Request, session) 
			
			//1.파라미터받기
			String title = request.getParameter("qTitle"); //제목
			String content = request.getParameter("qContents");//내용
			System.out.println("qTitle = "+title+"\nqContents = "+content);
			//2.비즈니스로직(<->Service<->DAO<->DB) p640 39
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("AUTHUSER");
			System.out.println("writer 세션 user = "+user);
			/*new User(member.getId(), member.getName())*/	
			
			//글등록 p641 40
			WriteRequest writeReq = createWriteRequest(user,title,content);
			writeReq.validate(errors);
			
			//유효성검사를 불통하여 글등록폼으로 이동
			if( !errors.isEmpty() ) {
				return FORM_VIEW;
			}
			
			//db에 insert성공시의  해당글번호가 newArticleNo에 리턴
			int newArticleNo = 
				writeService.write(writeReq); //p641 47
			
			//3.Model(Request, session)
			request.setAttribute("newArticleNo", newArticleNo);
			
			//4.View
			return "/view/article/newArticleAccess.jsp";
		}

		//p641 53
		private WriteRequest createWriteRequest(User user,String title, String content 	) {
			System.out.println("content="+content);
			WriteRequest wr = new WriteRequest(
					new Writer(user.getId(), user.getName()),
					title,
					content);
			
			System.out.println("wr ="+wr);
			 return wr;
		}//createWriteRequest
	}
	/*
	insert into article(writer_id,writer_name,title,regdate,moddate,read_cnt)
	values(writer_id?,writer_name?,title?,regdate?,moddate?,0);

	insert into article_content(article_no,content)
	values(article_no?,content?);
	 */



