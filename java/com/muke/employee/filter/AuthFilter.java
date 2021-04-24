package com.muke.employee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;

public class AuthFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) servletResponse;

		Object employee = ActionContext.getContext().getSession().get("existEmployee");

		if (employee != null) {
			// 已通过验证，用户访问继续
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		} else {
			// 跳转到登录页面
			response.sendRedirect("/login_tolog");
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
