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
	
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse resq = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		/*
		 * 如果商家已经登录，则放行
		 */
		String requestUri = httpRequest.getRequestURI();
		if (session.getAttribute("admin") != null
				|| requestUri.equals(
						httpRequest.getContextPath()
								+ "/admin/loginInput.action")
				|| requestUri.equals(
						httpRequest.getContextPath() + "/admin/login.action")
				|| requestUri.startsWith(
						httpRequest.getContextPath() + "/customer")
				|| requestUri.startsWith(
						httpRequest.getContextPath() + "/css/")
				|| requestUri.startsWith(
						httpRequest.getContextPath() + "/images/")
				|| requestUri.startsWith(
						httpRequest.getContextPath() + "/js/")) {
			filter.doFilter(request, response);
		} else {
			/*
			 * 否则转到商家登录界面
			 */
			resq.sendRedirect(httpRequest.getContextPath()
					+ "/admin/loginInput.action");

		}
	}

	@Override
	public void destroy() {

	}
}
