package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.dao.MemberDao;

public class LoginProService implements IBoardService {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		
		boolean result = dao.login(mem_id, mem_pw);
		String msg = "";
		if(result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("mem_id", mem_id);
			msg = "login_success";
		} else {
			msg = "login_fail";
		}
		
		return "redirect:main.sol?msg=" + msg;
	}

}
