package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.CartDao;
import com.sol.vo.CartVo;

public class CartService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		int book_amount = Integer.parseInt(request.getParameter("book_amount"));
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		CartVo vo = new CartVo();
		vo.setBook_num(book_num);
		vo.setBook_amount(book_amount);
		vo.setMem_id(mem_id);
		
		boolean result = dao.addCart(vo);
		String msg = "";
		
		if(result == true) {
			msg = "cart_add";
		} else {
			msg = "cart_fail";
		}
		
		request.setAttribute("data", msg);
		
		return "/WEB-INF/views/data.jsp";
	}

}
