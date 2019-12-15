package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.CartDao;
import com.sol.vo.CartVo;

public class CartFormService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");

		List<CartVo> list = dao.getMyCartList(mem_id);
		
		request.setAttribute("list", list);
		
		return "/WEB-INF/views/board/cart_page.jsp";
	}

}
