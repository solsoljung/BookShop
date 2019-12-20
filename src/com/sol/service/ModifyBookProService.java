package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.BookDao;
import com.sol.vo.BookVo;

public class ModifyBookProService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		String book_name = request.getParameter("book_name");
		String book_writer = request.getParameter("book_writer");
		int book_stock = Integer.parseInt(request.getParameter("book_stock"));
		int book_price = Integer.parseInt(request.getParameter("book_price"));
		String category_code = request.getParameter("category_code");
		String book_explain = request.getParameter("book_explain");
		String book_image = request.getParameter("book_image");
		
		BookVo vo = new BookVo();
		vo.setBook_num(book_num);
		vo.setBook_name(book_name);
		vo.setBook_writer(book_writer);
		vo.setBook_stock(book_stock);
		vo.setBook_price(book_price);
		vo.setCategory_code(category_code);
		vo.setBook_explain(book_explain);
		vo.setBook_image(book_image);
		
		boolean result = dao.updateBookInfo(vo);
		
		return "redirect:book_info_modify.adm?book_num=" + book_num;
	}

}
