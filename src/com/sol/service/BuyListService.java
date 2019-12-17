package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BuyDao;
import com.sol.dao.MemberDao;
import com.sol.vo.BuyVo;
import com.sol.vo.MemberVo;

public class BuyListService implements IBoardService {
	
	BuyDao dao = BuyDao.getInstance();
	MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<BuyVo> list = dao.getBuyList(mem_id);
		
		MemberVo memberVo = memberDao.getMemberInfo(mem_id);
		
		request.setAttribute("list", list);
		request.setAttribute("memberVo", memberVo);
		
		return "/WEB-INF/views/board/buy_list.jsp";
	}

}
