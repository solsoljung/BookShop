package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;

public class ModifyCategoryPro implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String category_code = request.getParameter("category_code");
		String category_code_explain = request.getParameter("category_code_explain");
		
		dao.addCategory(category_code, category_code_explain);
		
		return "redirect:adminProductPage.adm";
	}

}
