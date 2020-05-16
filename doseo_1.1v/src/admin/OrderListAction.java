package admin;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.OrderDAO;
import VO.OrderListVO;

//관리자 페이지에서 회원들의 주문 리스트를 출력하기 위한 액션 클래스
public class OrderListAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/order/orderList.jsp";
		String key = "";
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}

		OrderDAO orderDAO = OrderDAO.getInstance();
		ArrayList<OrderListVO> orderList = orderDAO.listOrder(key);

		request.setAttribute("orderList", orderList);

		request.getRequestDispatcher(url).forward(request, response);
	}
}
