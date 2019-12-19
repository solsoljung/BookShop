package com.sol.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.service.IBoardService;


@WebServlet("*.adm")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, IBoardService> commandMap = new HashMap<>();
       
    public AdminFrontController() {
        super();
    }
    

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init 실행됨");
		loadProperties();
	}
	
	private void loadProperties() {
		ResourceBundle bundle = ResourceBundle.getBundle("com.sol.properties.AdminCommand");
		Enumeration<String> keys = bundle.getKeys(); // list.kh, write-form.kh, ....
		
		while (keys.hasMoreElements()) {
			String commandName = keys.nextElement();
			String className = bundle.getString(commandName);
			try {
				Class<?> commandClass = Class.forName(className);
				Object obj = commandClass.newInstance(); // new BoardContentService()
				commandMap.put(commandName, (IBoardService)obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // while
		
		System.out.println("commandMap:" + commandMap);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request); // list.kh
		System.out.println("command:" + command);
		
		IBoardService service = commandMap.get(command); // BoardListService
		System.out.println("서비스멸ㅇㄹ: "+service);
		try {
			String path = service.execute(request, response);
			System.out.println("path:" + path);
			if (path.startsWith("redirect:")) {
				String location = path.substring("redirect:".length());
				response.sendRedirect(location);
			} else {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
//		System.out.println("uri:" + uri); // /Model2/list.kh
		String contextPath = request.getContextPath();
//		System.out.println("contextPath:" + contextPath); // /Model2
		int beginIndex = contextPath.length() + 1;
		String command = uri.substring(beginIndex); // list.kh
//		System.out.println("command:" + command);
		return command;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
