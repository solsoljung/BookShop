package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BookDao;
import com.sol.dao.CartDao;
import com.sol.dao.MemberDao;
import com.sol.vo.BookVo;
import com.sol.vo.CartVo;
import com.sol.vo.MemberVo;
import com.sol.vo.TempBuyVo;

public class BuyListService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();
	MemberDao memberDao = MemberDao.getInstance();
	BookDao bookDao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//카트 목록 보이는 부분
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		/* List<CartVo> list = dao.getMyCartList(mem_id); */
		
		//새롭게 만든 책 정보만 빼내 보기
		@SuppressWarnings("unchecked")
		List<TempBuyVo> tempList = (List<TempBuyVo>) request.getAttribute("list");
		System.out.println("바이List에서 보내는 리스트 길이~~: "+tempList.size());
		List<BookVo> bookTempList = bookDao.getTempList(tempList);
		//회원정보 보이는 부분
		MemberVo memberVo = memberDao.getMemberInfo(mem_id);
		
		//총가격 넘겨주는 부분
		int allPrice = 0;
		
		for(BookVo vo : bookTempList) {
			int book_amount = vo.getBook_amount();
			int book_price = vo.getBook_price();
			allPrice += book_price * book_amount;
		}
		
		//request.setAttribute("list", list);
		session.setAttribute("bookTempList", bookTempList);
		request.setAttribute("memberVo", memberVo);
		session.setAttribute("allPrice", allPrice);
		
		return "/WEB-INF/views/board/buy_list.jsp";
	}

}
