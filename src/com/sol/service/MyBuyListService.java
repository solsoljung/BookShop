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

		String msg = request.getParameter("msg");
		System.out.println("구매를 성공했나여?? 마이바이리스트입니다." + msg);
		
		//나의 포인트 총합
		int all_point = dao.getMyAllPoint(mem_id);
		
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		request.setAttribute("all_point", all_point);
		
		return "/WEB-INF/views/board/payment_result.jsp";
	}
}
