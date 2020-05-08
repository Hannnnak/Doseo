package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class ListProductHandler implements CommandHandler {

	//view
	private static final String FORM_VIEW = "/view_admin/productList.html";
	
	//service(dao연결)
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ListProductHandler의 process()진입 ");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {	//GET방식으로 요청이 들어오는 경우
			System.out.println("ListProductHandler의 processForm()호출");
			return FORM_VIEW;
//			return	processForm(request, response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {	//post방식으로 요청이 들어오는 경우
			System.out.println("ListProductHandler의 processSubmit()호출");
			return FORM_VIEW;
//			return	processSubmit(request, response);
			
		}else {
			//405에러(요청한 파일이 있지만 접근할 수 없는 오류일 경우)
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//			return	null;
			return FORM_VIEW;
		}
	}


	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
}
