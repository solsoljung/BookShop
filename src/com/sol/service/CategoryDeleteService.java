package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;

public class CategoryDeleteService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String category_code = request.getParameter("category_code");
		boolean result = dao.deleteCategory(category_code);
		String msg = "fail_category_delete";
		if(result == true) {
			msg = "success_category_delete";
		}

		request.setAttribute("data", msg);
		
		return "/WEB-INF/views/data.jsp";
	}

}
