package com.sol.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.BuyDao;
import com.sol.dao.CartDao;
import com.sol.vo.BuyVo;
import com.sol.vo.CartVo;

public class BuyProService implements IBoardService {
	
	CartDao cartDao = CartDao.getInstance();
	BuyDao buyDao = BuyDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<CartVo> list = cartDao.getMyCartList(mem_id);
		List<BuyVo> newList = new ArrayList<BuyVo>();
		int allPrice = 0;
		
		for(CartVo vo : list) {
			int book_num = vo.getBook_num();
			int book_amount = vo.getBook_amount();
			int book_price = vo.getBook_price();
			allPrice += book_price * book_amount;
			BuyVo newVo = new BuyVo();
			newVo.setBook_num(book_num);
			newVo.setBook_amount(book_amount);
			newVo.setMem_id(mem_id);
			//여기서 총액을 넘겨줘야 합니다.
			newList.add(newVo);
		}
		
		buyDao.addBuyList(newList, mem_id);
		session.setAttribute("allPrice", allPrice);
		
		return "redirect:buy_list.mem";
	}

}
