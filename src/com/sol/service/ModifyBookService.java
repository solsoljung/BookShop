package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;

public class ModifyBookService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		BookVo vo = dao.getOneBook(book_num);
		
		request.setAttribute("vo", vo);
		
		return "/WEB-INF/views/board/modify_book.jsp";
	}

}
