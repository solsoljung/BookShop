package com.sol.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;

import com.sol.vo.TempBuyVo;

public class BuyProService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String checked = request.getParameter("checked");
		String arrayParam = request.getParameter("arrayParam");
		String[] arrBookNum = checked.split(",");
		String[] arrBookAmount= arrayParam.split(",");
		
		/*
		 * 맵에 넣을 필요가 없는 것 같아서 일단 주석으로 막아둠
		 * Map<Object, Object> map = new HashMap<Object, Object>();
		 * 
		 * //책넘-수량을 맵에 넣음. for(int i=0;i<arrBookNum.length;i++) { for(int j=i;j<i+1;j++)
		 * { map.put(arrBookNum[i], arrBookAmount[j]); } }
		 */
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		List<TempBuyVo> list = new ArrayList<TempBuyVo>();
		
		for(int i=0;i<arrBookNum.length;i++) {
			TempBuyVo tempVo = new TempBuyVo();
			tempVo.setBook_num(Integer.parseInt(arrBookNum[i]));
			tempVo.setBook_amount(Integer.parseInt(arrBookAmount[i]));
			tempVo.setMem_id(mem_id);
			list.add(tempVo);
		}
		System.out.println("바이프로에서 보내는 리스트 길이~~: "+list.size());
		
		request.setAttribute("list", list);
		
		return "buy_list.mem";
	}

}
