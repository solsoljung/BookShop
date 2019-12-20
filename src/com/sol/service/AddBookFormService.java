package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String category_code = request.getParameter("category_code");
		
		request.setAttribute("category_code", category_code);
		
		return "/WEB-INF/views/board/add_book.jsp";
	}

}
