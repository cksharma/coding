package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	private EmployeeDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new EmployeeDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = null;
		String action = request.getParameter("action");
		System.out.println(" action " + action);
		if(action.equals("add"))
		{
			int employeeId = Integer.parseInt(request.getParameter("id"));
			String empname = request.getParameter("name");
			String designation = request.getParameter("designation");
			System.out.println("Designaiton = " + designation);
			double salary = Double.parseDouble(request.getParameter("salary"));
			int accountNumber = Integer.parseInt(request.getParameter("accountnumber"));
			String accountType = request.getParameter("accounttype");
			double balance = Double.parseDouble(request.getParameter("balance"));
			
			Employee emp = new Employee(employeeId, empname, designation, salary);
			
			Account acc = new Account(accountNumber, accountType, balance);
			
			boolean ok = dao.addEmployee(emp, acc);
			
			if(!ok)
			{
				dispatcher = request.getRequestDispatcher("/employeeNotAdded.jsp");
			}
			else
			{
				dispatcher = request.getRequestDispatcher("/employeeAdded.jsp");
			}
			System.out.println("dispatching guys");
			
			dispatcher.forward(request, response);
			
		}
		
	}

}
