package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BuyDao;
import com.sol.dao.CartDao;
import com.sol.dao.MemberDao;
import com.sol.vo.BuyVo;
import com.sol.vo.CartVo;
import com.sol.vo.MemberVo;

public class BuyListService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();
	MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//카트 목록 보이는 부분
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<CartVo> list = dao.getMyCartList(mem_id);
		
		//회원정보 보이는 부분
		MemberVo memberVo = memberDao.getMemberInfo(mem_id);
		
		//총가격 넘겨주는 부분
		int allPrice = 0;
		
		for(CartVo vo : list) {
			int book_amount = vo.getBook_amount();
			int book_price = vo.getBook_price();
			allPrice += book_price * book_amount;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("memberVo", memberVo);
		session.setAttribute("allPrice", allPrice);
		
		return "/WEB-INF/views/board/buy_list.jsp";
	}

}
