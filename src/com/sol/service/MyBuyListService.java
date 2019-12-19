package com.sol.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BuyDao;
import com.sol.vo.BuyVo;

public class MyBuyListService implements IBoardService {
	
	BuyDao dao = BuyDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<BuyVo> list = dao.getMyBuyList(mem_id);
		Map<Integer, Integer> map = dao.getCountBuyList(mem_id);
		
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		
		return "/WEB-INF/views/board/payment_result.jsp";
	}
}
