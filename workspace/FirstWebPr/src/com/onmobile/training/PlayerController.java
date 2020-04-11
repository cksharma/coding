package com.onmobile.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PlayerDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new PlayerDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int playerId = Integer.parseInt(request.getParameter("pid"));
		Player player = null;
		RequestDispatcher dispatcher;
		
		player = dao.getPlayerDetails(playerId);
		 
		
		if(player == null)
		{
			dispatcher = request.getRequestDispatcher("/playerNotFound.jsp");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("/playerDetails.jsp");
			request.setAttribute("player", "ABCD");
		}
		dispatcher.forward(request, response);
	}
}
