package com.onmobile.training;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class StepTagHandler extends TagSupport{
	
	int start;
	int stop;
	int step;
	private JspWriter out;   
	
	String var;
	
	public void setVar(String var)
	{
		this.var = var;
	}
	
	public void setStart(int start)
	{
		this.start = start;
	}
	public void setStop(int stop)
	{
		this.stop = stop;
	}
	public void setStep(int step)
	{
		this.step = step;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		
		if(start > stop) 
		{
			return SKIP_BODY;
		}
		else 
		{
			pageContext.setAttribute(var, start);
			start = start + step;
			return EVAL_BODY_AGAIN;
		}
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		try
		{
			out.println("************************");
			out.println("</pre>");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		out = pageContext.getOut();
		pageContext.setAttribute(var, start);
		start = start + step;
		try
		{
			out.println("<pre>");
			out.println("*****************************");
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
}
