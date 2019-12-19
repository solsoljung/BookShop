package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;

public class CategoryBookListService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String category_code = request.getParameter("category_code");
		String category_code_explain = request.getParameter("category_code_explain");
		List<BookVo> list = dao.getCategoryBook(category_code);
		
		request.setAttribute("list", list);
		request.setAttribute("category_code_explain", category_code_explain);
		
		return "/WEB-INF/views/board/category_book_list.jsp";
	}

}
