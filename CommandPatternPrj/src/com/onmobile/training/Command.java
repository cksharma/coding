package com.onmobile.training;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	public void execute(HttpServletRequest request, 
			    		HttpServletResponse response)throws IOException;
	public void undo(HttpServletRequest request, HttpServletResponse response) throws IOException;
}