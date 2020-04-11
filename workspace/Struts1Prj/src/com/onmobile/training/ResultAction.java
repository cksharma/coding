package com.onmobile.training;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ResultAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		Marks marks = (Marks) form;
		String result = FindResultUtility.getResult(marks);
		forward = mapping.findForward(result);
		return forward;
	}
}
