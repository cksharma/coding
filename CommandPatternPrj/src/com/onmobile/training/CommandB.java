package com.onmobile.training;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandB implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("company", "On Mobile");
		//response.getWriter().println("response for request /B");
		response.getWriter().println("added attribute");
	}

	@Override
	public void undo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {  // request for undo should undo the request for the last request. so server should keeep track of the perviois request
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("company");
		response.getWriter().println("removed attributed");
	}
	
}
