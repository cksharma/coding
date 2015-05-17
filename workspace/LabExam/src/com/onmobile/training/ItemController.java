package com.onmobile.training;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemController
 */
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ItemDAO itemdao;
	
	SalesDAO salesdao;
	
	static int salesId = 1;
	
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
		itemdao = new ItemDAO();
		salesdao = new SalesDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = null;
		String action = request.getParameter("action");
		if(action.equals("update"))
		{
			int itemId = Integer.parseInt(request.getParameter("id"));
			int quantityToBeAdded = Integer.parseInt(request.getParameter("quantity"));
			boolean ok = itemdao.updateItem(itemId, quantityToBeAdded);
			if(ok)
			{
				dispatcher = request.getRequestDispatcher("/itemUpdated.jsp");
			}
			else
			{
				dispatcher = request.getRequestDispatcher("/itemNotFound.jsp");
			}
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("purchase"))
		{	
			int itemId = Integer.parseInt(request.getParameter("id"));
			int quantitySold = Integer.parseInt(request.getParameter("quantity"));
			salesId++; 
			boolean ok = salesdao.addSales(salesId, itemId, quantitySold);
			
			if(ok)
			{	
				dispatcher = request.getRequestDispatcher("/purchasedItem.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(action.equals("list"))
		{
			String str = request.getParameter("date");
			String[] ans = str.split("-");
			int year = Integer.parseInt(ans[0]);
			int month = Integer.parseInt(ans[1]);
			int date = Integer.parseInt(ans[2]);
			Date d = new Date(year, month, date);
			List <Sales> list = salesdao.getSalesByDate(d);
			
			request.setAttribute("itemList", list);
			if(list.size() == 0)
				dispatcher = request.getRequestDispatcher("/noItems.jsp");
			else 
				dispatcher = request.getRequestDispatcher("/showList.jsp");
			
			dispatcher.forward(request, response);
			
		}
	}

}
