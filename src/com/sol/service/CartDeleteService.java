package com.sol.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.CartDao;
import com.sol.vo.CartVo;

public class CartDeleteService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		CartVo vo = new CartVo();
		vo.setBook_num(book_num);
		vo.setMem_id(mem_id);
		List<CartVo> list = new ArrayList<CartVo>();
		list.add(vo);
		
		boolean result = dao.deleteCart(list);
		String msg = "";
		
		if(result == true) {
			msg = "delete_success";
		} else {
			msg = "delete_fail";
		}
		
		request.setAttribute("data", msg);
		
		return "/WEB-INF/views/data.jsp";
	}

}
