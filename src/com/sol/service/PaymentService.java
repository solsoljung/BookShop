package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.MemberDao;
import com.sol.vo.MemberVo;

public class PaymentService implements IBoardService {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		String mem_phone = request.getParameter("mem_phone");
		String mem_address = request.getParameter("mem_address");
		
		MemberVo vo = new MemberVo();
		vo.setMem_id(mem_id);
		vo.setMem_phone(mem_phone);
		vo.setMem_address(mem_address);
		
		boolean memberInfoUpdateresult = dao.updateMemberInfo(vo);
		
		return "/WEB-INF/views/board/payment_result.jsp";
	}

}
