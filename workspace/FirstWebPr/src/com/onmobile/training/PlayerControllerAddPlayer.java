package com.onmobile.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerControllerAddPlayer
 */
public class PlayerControllerAddPlayer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	private PlayerDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		// TODO Auto-generated method stub
		super.init(config);
		dao = new PlayerDAO();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int playerId = Integer.parseInt(request.getParameter("pid"));
		String playerName = request.getParameter("pname");
		String sportsCode = request.getParameter("sports");
		String countryCode = request.getParameter("country");
		Player p = new Player(playerId, playerName, sportsCode, countryCode);
		boolean ok = dao.successfulAddPlayer(playerId, playerName, sportsCode, countryCode);
		RequestDispatcher dispatcher;
		if(!ok)
		{
			dispatcher = request.getRequestDispatcher("/playerNotAdded.jsp");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("/playerAdded.jsp");
			request.setAttribute("playerAdded", p);
		}
		dispatcher.forward(request, response);
	}
}
