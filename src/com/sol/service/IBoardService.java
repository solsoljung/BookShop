package com.sol.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {
	public String execute(HttpServletRequest request, 
			              HttpServletResponse response) throws Exception;
}
