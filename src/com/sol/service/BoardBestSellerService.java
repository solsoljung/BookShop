package com.sol.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;

public class BoardBestSellerService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int count = dao.allBookCount();
		Map<String, Integer> map = new HashMap<String, Integer>();
		double dbCount = count/10;
		count = (int) Math.ceil(dbCount);
		map.put("count", count);
		List<BookVo> list = dao.getBestSellerList();
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		
		return "/WEB-INF/views/board/best_seller.jsp";
	}

}
