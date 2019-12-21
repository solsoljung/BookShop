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

public class BestSellerPagingService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int count = dao.allBookCount();
		System.out.println("개굿객수ㅐ"+count);
		Map<String, Integer> map = new HashMap<String, Integer>();
		double dbCount = count/10;
		count = (int) Math.ceil(dbCount);
		map.put("count", count);
		System.out.println("개굿객수ㅐ2"+count);
		
		int now_page = Integer.parseInt(request.getParameter("now_page"));
		int end_page = now_page * 10;
		int start_page = end_page - (10 -1);
		PagingVo pagingVo = new PagingVo();
		pagingVo.setStart_page(start_page);
		pagingVo.setEnd_page(end_page);
		
		String searchKeyword = request.getParameter("search_keyword");
		SearchVo searchVo = new SearchVo();
		searchVo.setSearchKeyword(searchKeyword);
		
		List<BookVo> list = dao.getBestSellerList(searchVo, pagingVo);
		
		request.setAttribute("data", list);
		//request.setAttribute("map", map);
		
		return "/WEB-INF/views/data.jsp";
	}

}
