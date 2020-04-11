package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourthServlet
 */
public class FourthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1><font color='blue'>Welcome</font></h1>");
		
		out.println("<br> Name: "+request.getParameter("name"));
		String date=request.getParameter("dob");
		out.println("<br>Date Of Birth: "+date);
		String[] d=date.split("-");
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DATE);
		int y1=Integer.parseInt(d[2]);
		int m1=Integer.parseInt(d[1]);
		int d1=Integer.parseInt(d[0]);		
		System.out.println(year);
		System.out.println(y1);
		System.out.println(month);
		System.out.println(m1);
		int y=(year-y1);
		int m=(month-m1);
		
		int da=(day-d1);
		if(da<0)
		{
			da=da+30;
			m=m-1;
			if(m<0)
		{
			m=m+12;
			y=y-1;
		}
		}
		
		System.out.println(y+" years "+m+"months "+da+" days ");
		out.println("<br>Age: "+y+" years "+m+"months "+da+" days ");
		String gender=request.getParameter("gender");
		out.println("<br>Sex: "+gender);
		
		
		out.println("<br>Marital Status: "+request.getParameter("marital"));
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
