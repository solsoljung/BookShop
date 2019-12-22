package com.sol.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;
import com.sol.vo.PagingVo;
import com.sol.vo.SearchVo;

public class BoardBestSellerService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String search_keyword = request.getParameter("search_keyword");
		SearchVo searchVo = new SearchVo();
		searchVo.setSearchKeyword(search_keyword);
		
		int count = dao.allBookCount(searchVo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		double dbCount = ((double)count)/10;
		count = (int) Math.ceil(dbCount);
		map.put("count", count);
		
		String str_now_page = request.getParameter("now_page");
		int now_page = 1;
		if(str_now_page != null) {
			now_page = Integer.parseInt(str_now_page);
		}
		
		int end_page = now_page * 10;
		int start_page = end_page - (10 -1);
		PagingVo pagingVo = new PagingVo();
		pagingVo.setStart_page(start_page);
		pagingVo.setEnd_page(end_page);
		
		int best_index = (now_page - 1) * 10 + 1;
		
		map.put("best_index", best_index);
		List<BookVo> list = dao.getBestSellerList(searchVo, pagingVo);
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		request.setAttribute("search_keyword", search_keyword);
		
		return "/WEB-INF/views/board/best_seller.jsp";
	}

}
