package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sol.dao.BookDao;

public class BookDeleteService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		
		boolean result = dao.deleteBook(book_num);
		
		String msg = "";
		
		if(result == true) {
			msg = "book_delete_success";
		} else {
			msg = "delete_fail";
		}
		
		request.setAttribute("data", msg);
		
		return "/WEB-INF/views/data.jsp";
	}

}
