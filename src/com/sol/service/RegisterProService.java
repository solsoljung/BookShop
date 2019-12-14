package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.MemberDao;
import com.sol.vo.MemberVo;

public class RegisterProService implements IBoardService {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		String mem_name = request.getParameter("mem_name");
		String mem_phone = request.getParameter("mem_phone");
		String mem_address = request.getParameter("mem_address");
		
		MemberVo vo = new MemberVo();
		vo.setMem_id(mem_id);
		vo.setMem_pw(mem_pw);
		vo.setMem_name(mem_name);
		vo.setMem_phone(mem_phone);
		vo.setMem_address(mem_address);
		
		boolean result = dao.register(vo);
		String msg = "register_fail";
		String redirectPage = "redirect:";
		if(result == true) {
			msg = "register_success";
			redirectPage += "main.sol?msg=" + msg;
		} else {
			redirectPage += "register.sol?msg=" + msg;
		}
		
		System.out.println("요청한 ㅍ이지는?????: "+redirectPage);
		
		return redirectPage;
	}

}
