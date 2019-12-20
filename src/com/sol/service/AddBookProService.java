package com.sol.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.sol.dao.BookDao;
import com.sol.util.FileUploader;
import com.sol.vo.BookVo;

public class AddBookProService implements IBoardService {
	
	BookDao dao = BookDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartRequest multi = FileUploader.upload(request);
		
		String book_name = multi.getParameter("book_name");
		String book_writer = multi.getParameter("book_writer");
		int book_price = Integer.parseInt(multi.getParameter("book_price"));
		int book_stock = Integer.parseInt(multi.getParameter("book_stock"));
		String category_code = multi.getParameter("category_code");
		String book_explain = multi.getParameter("book_explain");
		
		Enumeration<?> enumer = multi.getFileNames(); 
		String filename = (String)enumer.nextElement();
		System.out.println("filename:" + filename);
		String book_image = multi.getFilesystemName(filename);
		
		BookVo vo = new BookVo();
		vo.setBook_name(book_name);
		vo.setBook_writer(book_writer);
		vo.setBook_price(book_price);
		vo.setBook_stock(book_stock);
		vo.setCategory_code(category_code);
		vo.setBook_explain(book_explain);
		vo.setBook_image(book_image);
		
		boolean result = dao.addBook(vo);
		String msg = "fail_add_book";
		if(result == true) {
			msg = "success_add_book";
		}
		
		request.setAttribute("msg", msg);
		//request.setAttribute("category_code", category_code);
		
		return "redirect:category_book_list.adm?category_code=" + category_code;
	}

}
