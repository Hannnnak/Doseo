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
				"/view/qna/newQnaForm.jsp";
		//Service
		private WriteQnaService writeService = 
				new WriteQnaService();
		
		@Override
		public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("WriteArticleHandler�쓽 process()吏꾩엯");

			if(request.getMethod().equalsIgnoreCase("GET")) {
				System.out.println("newArticleForm.jsp�쓽 method諛⑹떇="+request.getMethod());
				return processForm(request,response);
			}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST諛⑹떇�쑝濡� �슂泥��씠 �뱾�뼱�삤硫�
				System.out.println("newArticleForm.jsp�쓽 method諛⑹떇="+request.getMethod());
				return processSubmit(request,response);
			}else {
				//405�뿉�윭
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
				return   null;
			}
			
		}
		
		//GET諛⑹떇�쑝濡�  �슂泥��씠 �뱾�뼱�삤硫�  �뤌(/view/article/newArticleForm.jsp)�쓣 蹂댁뿬二쇨린
		private String processForm(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("WriteArticleHandler�쓽 processForm()�샇異�");
			return FORM_VIEW;
		}

		//P640 35
		//POST諛⑹떇�쑝濡� �슂泥��씠 �뱾�뼱�삤硫�
		private String processSubmit(HttpServletRequest request, 
				HttpServletResponse response) 
				throws Exception {
			System.out.println("WriteArticleHandler�쓽 processSubmit()�샇異�");
			
			Map<String, Boolean> errors = new HashMap();
			request.setAttribute("errors", errors);//3.Model(Request, session) 
			
			//1.�뙆�씪誘명꽣諛쏄린
			String title = request.getParameter("qTitle"); //�젣紐�
			String content = request.getParameter("qContents");//�궡�슜
			System.out.println("qTitle = "+title+"\nqContents = "+content);
			//2.鍮꾩쫰�땲�뒪濡쒖쭅(<->Service<->DAO<->DB) p640 39
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("AUTHUSER2");
			System.out.println("writer �꽭�뀡 user = "+user);
			/*new User(member.getId(), member.getName())*/	
			
			//湲��벑濡� p641 40
			WriteRequest writeReq = createWriteRequest(user,title,content);
			writeReq.validate(errors);
			
			//�쑀�슚�꽦寃��궗瑜� 遺덊넻�븯�뿬 湲��벑濡앺뤌�쑝濡� �씠�룞
			if( !errors.isEmpty() ) {
				return FORM_VIEW;
			}
			
			//db�뿉 insert�꽦怨듭떆�쓽  �빐�떦湲�踰덊샇媛� newArticleNo�뿉 由ы꽩
			int newArticleNo = 
				writeService.write(writeReq); //p641 47
			
			//3.Model(Request, session)
			request.setAttribute("newArticleNo", newArticleNo);
			
			//4.View
			return "/view/qna/newQnaAccess.jsp";
		}

		//p641 53
		private WriteRequest createWriteRequest(User user,String title, String content 	) {
			System.out.println("content="+content);
			WriteRequest wr = new WriteRequest(
					new Writer(user.getId()),
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



