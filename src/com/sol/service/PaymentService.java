package com.sol.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.common.IConstants;
import com.sol.dao.BuyDao;
import com.sol.dao.CartDao;
import com.sol.dao.MemberDao;
import com.sol.vo.BookVo;
import com.sol.vo.BuyVo;
import com.sol.vo.CartVo;
import com.sol.vo.MemberVo;
import com.sol.vo.PointVo;

public class PaymentService implements IBoardService {
	
	MemberDao memberDao = MemberDao.getInstance();
	BuyDao buyDao = BuyDao.getInstance();
	CartDao cartDao = CartDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//멤버정보 업데이트
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		String mem_phone = request.getParameter("mem_phone");
		String mem_address = request.getParameter("mem_address");
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_id(mem_id);
		memberVo.setMem_phone(mem_phone);
		memberVo.setMem_address(mem_address);
		
		memberDao.updateMemberInfo(memberVo);
		
		//포인트 업데이트
		PointVo pointVo = new PointVo();
		pointVo.setMem_id(mem_id);
		pointVo.setPoint_code(IConstants.BUY_BOOK_CODE);
		int allPrice = Integer.parseInt(request.getParameter("allPrice"));
		int buy_point = (int)(allPrice*0.05);
		pointVo.setPoint_score(buy_point);
		
		session.setAttribute("now_buy_point", buy_point);
		
		//장바구니에서 삭제,
		//구매테이블에 추가
		@SuppressWarnings("unchecked")
		List<BookVo> bookTempList = (List<BookVo>) session.getAttribute("bookTempList");
		System.out.println("propayment에서 날랄ㅇ오오: "+bookTempList.size());
		List<BuyVo> newList = new ArrayList<BuyVo>();
		
		for(BookVo vo : bookTempList) {
			int book_num = vo.getBook_num();
			int book_amount = vo.getBook_amount();
			
			BuyVo newVo = new BuyVo();
			newVo.setBook_num(book_num);
			newVo.setBook_amount(book_amount);
			newVo.setMem_id(mem_id);
			newVo.setMem_phone(mem_phone);
			newVo.setMem_address(mem_address);
			newVo.setBuy_all_price(allPrice);
			newVo.setBuy_point(buy_point);

			newList.add(newVo);
		}
		boolean result = buyDao.buy(newList, pointVo, mem_id);
		String msg = "";
		String url = "";
		if(result == false) {
			msg = "buy_fail";
			url = "redirect:cart_form.mem?msg=" + msg;
		} else if(result == true) {
			msg = "buy_success";
			url = "redirect:my_buy_list.mem?msg=" + msg;
		}
		
		return url;
	}

}
