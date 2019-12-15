package com.sol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sol.dao.CartDao;
import com.sol.vo.CartVo;


public class CartListService implements IBoardService {
	
	CartDao dao = CartDao.getInstance();

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<CartVo> list = dao.getMyCartList(mem_id);
		
		JSONArray jsonArray = new JSONArray();
		for(CartVo vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("book_num", vo.getBook_num());
			obj.put("book_name", vo.getBook_name());
			obj.put("book_image", vo.getBook_image());
			obj.put("book_price", vo.getBook_price());
			obj.put("book_amount", vo.getBook_amount());
			jsonArray.add(obj);
		}
		
		request.setAttribute("data", jsonArray.toJSONString());
		
		return "/WEB-INF/views/data.jsp";
	}

}
