package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BuyDao;
import com.sol.vo.BuyVo;

public class BuyListService implements IBoardService {
	
	BuyDao dao = BuyDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<BuyVo> list = dao.getBuyList(mem_id);
		
		request.setAttribute("list", list);
		
		return "/WEB-INF/views/board/buy_list.jsp";
	}

}
