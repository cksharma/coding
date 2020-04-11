package com.onmobile.training;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{

	private List <Command> list = new ArrayList <Command> ();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		if(path.equals("/undo")) {
			performUndo(req, resp);
		}
		else
		{
		Properties props = new Properties();
		ServletContext ctx = getServletContext();
		InputStream in = ctx.getResourceAsStream("commandConfig.properties");
		props.load(in);
		String cmd = props.getProperty(path);
		try {
			Class cls = Class.forName(cmd);
			Object obj = cls.newInstance();
			Command cmdObj = (Command)obj;
			cmdObj.execute(req, resp);
			list.add(cmdObj);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	private void performUndo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		Command lastCommand = list.get(list.size() - 1);
		lastCommand.undo(req, resp);
		list.remove(lastCommand);
	}
	
}
