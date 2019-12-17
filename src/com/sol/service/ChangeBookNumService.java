package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.CartDao;
import com.sol.vo.BookVo;
import com.sol.vo.CartVo;

public class ChangeBookNumService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		int book_amount = Integer.parseInt(request.getParameter("book_amount"));
		
		CartVo vo = new CartVo();
		vo.setBook_num(book_num);
		vo.setBook_amount(book_amount);
		vo.setMem_id(mem_id);
		
		boolean result = dao.changeBookAmount(vo);
		String msg = "book_amount_change_fail";
		if(result == true) {
			msg = "book_amount_change_success";
		}
		
		request.setAttribute("data", msg);

		return "/WEB-INF/views/data.jsp";
	}

}
