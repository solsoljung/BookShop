package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;

public class SameWriterService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String book_writer = request.getParameter("book_writer");
		
		List<BookVo> list = dao.sameWriter(book_writer);
		request.setAttribute("list", list);
		
		return "/WEB-INF/views/board/writer_book.jsp";
	}

}
