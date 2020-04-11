package com.onmobile.training;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FirstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String msg = "Welcome to Spring MVC";
		ModelAndView mv = new ModelAndView("show", "message", msg);
		// view name is the logical name assigned to the url pattern
		// this show here is the logical name...here message is the name of the model and
		// msg is the value of the model..
		return mv;
	}
}