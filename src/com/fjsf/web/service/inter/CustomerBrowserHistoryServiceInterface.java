package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerBrowserHistoryServiceInterface {
	
	/**
	 * 显示浏览历史
	 * @param request
	 * @param response
	 */
	void showBrowserHistory(HttpServletRequest request, HttpServletResponse response);
}
