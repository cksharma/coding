package com.onmobile.training;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MapDisplayTagHandler extends SimpleTagSupport {

	private Map map;

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();
		out.println("<table border = 2>");
		for (Object key : map.keySet()) {
			out.println("<tr>");
			out.println("<td>" + key + "</td>" + "<td>" + map.get(key) + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
