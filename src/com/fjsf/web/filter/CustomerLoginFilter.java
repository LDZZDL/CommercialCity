package com.fjsf.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CustomerLoginFilter
 */
public class CustomerLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CustomerLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		System.out.println("登录过滤器");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest tempReq = req;
		HttpServletResponse tempRes = res;
		System.out.println("登录拦截器开始");
		req.getSession().setAttribute("name", "name");
		req.getSession().setAttribute("req", request);
		req.getSession().setAttribute("res", response);
		req.getSession().setAttribute("chain", chain);
		req.getRequestDispatcher("test.jsp").forward(req, res);
		*/
		chain.doFilter(request, response);
		/*
		System.out.println("执行Servlet");
		chain.doFilter(request, response);
		System.out.println("登录拦截器结束");
		*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
