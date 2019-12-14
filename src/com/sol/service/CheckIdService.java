package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.dao.MemberDao;

public class CheckIdService implements IBoardService {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mem_id = request.getParameter("mem_id");
		
		boolean result = dao.checkId(mem_id);
		String msg = "";
		if(result == true) {
			msg = "used_id";
		} else {
			msg = "available_id";
		}
		
		request.setAttribute("data", msg);
		
		return "/WEB-INF/views/data.jsp";
	}

}
