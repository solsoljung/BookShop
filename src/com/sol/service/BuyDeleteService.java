package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BuyDao;

public class BuyDeleteService implements IBoardService {
	
	BuyDao dao = BuyDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");

		boolean result = dao.deleteBuyList(book_num, mem_id);
		
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
