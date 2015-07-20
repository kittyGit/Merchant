package com.canguang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse resq = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		System.out.println("-------------isLogin--------------------" + session.getAttribute("admin"));
		if (session.getAttribute("admin") != null
				|| httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/admin/loginInput.action")
				|| httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/admin/login.action")
				|| httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/customer/registerInput.action")
				|| httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/customer/register.action")) {
			filter.doFilter(request, response);
		} else {
			resq.sendRedirect(httpRequest.getContextPath() + "/admin/loginInput.action");

		}
	}

	@Override
	public void destroy() {

	}

}
