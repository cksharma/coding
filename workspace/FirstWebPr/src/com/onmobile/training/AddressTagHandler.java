package com.onmobile.training;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddressTagHandler extends SimpleTagSupport{

	private String branch;
	
	
	
	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();
		out.println("<pre>");
		out.println("On Mobile Solutions");
		
		out.println("</pre>");
		//out.close(); we should not try to close 
		if(branch.equals("Bangalore"))
		{
			out.println("JP Nagar 7th Phase");
			out.println("Bangalore");
		}
		else if(branch.equals("Mumbai"))
		{
			out.println("Nariman Point");
			out.println("Mumbai");
		}
		else if(branch.equals("Gurgaon"))
		{
			out.println("DLF Cyber City");
			out.println("Gurgaon");
		}
		out.println("</pre>");
	}
	
}
