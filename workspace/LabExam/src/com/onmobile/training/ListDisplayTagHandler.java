package com.onmobile.training;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListDisplayTagHandler extends SimpleTagSupport{

	private List list;
	
	public void setList (List list)
	{
		this.list = list;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();
		out.println("<table border = 2>");
		for(Object key : list)
		{
			Sales key1 = (Sales) key;
			out.println("<tr>");
			out.println("<td>" + key1.toString() + "</td>");
			out.println("</tr>");	
		}
		out.println("</table>");
	}
}
