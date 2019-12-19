package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;

public class AdminProductPageService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<BookVo> list = dao.getCategory();
		
		request.setAttribute("list", list);
		
		return "/WEB-INF/views/board/admin_product_page.jsp";
	}

}
