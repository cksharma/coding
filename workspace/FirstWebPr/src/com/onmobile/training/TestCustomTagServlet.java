package com.onmobile.training;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCustomTagServlet
 */
public class TestCustomTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map <String, String> m = new HashMap <String, String> ();
		m.put("A", "Bangalore");
		m.put("B", "Mumbai");
		m.put("C", "Delhi");
		request.setAttribute("cityMap", m);
		RequestDispatcher disp = request.getRequestDispatcher("/showMap.jsp");
		disp.forward(request, response);
	}

}
