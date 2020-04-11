package com.onmobile.training;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LoopTagHandler extends TagSupport{
	
	int count;
	int cnt;
	private JspWriter out;   
	private int i;
	
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		i++;
		if(i > count) 
		{
			return SKIP_BODY;
		}
		else 
		{
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
		i = 1;
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
