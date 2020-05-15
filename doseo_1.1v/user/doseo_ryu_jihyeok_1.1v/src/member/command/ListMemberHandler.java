package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.ListMemberService;
import member.service.MemberPage;
import mvc.command.CommandHandler;

//전체목록보기 요청 담당 컨트롤러
//P652
public class ListMemberHandler implements CommandHandler {

	//Service
	private ListMemberService listService =
			new ListMemberService();
	
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//할일
		//1.파라미터 받기
		String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
		int pageNo = 1;
		if( pageNoVal!=null ) { //보고싶은페이지가 넘어오면
			pageNo = Integer.parseInt(pageNoVal);
		}
				
		//2.비즈니스로직(<->Service<->DAO<->DB) p652 22
		MemberPage memberPage = 
				listService.getMemberPage(pageNo);
		
		//3.Model
		request.setAttribute("memberPAPE", memberPage);
				
		//4.View
		return "/view/member/listMember.jsp";
	}

}








