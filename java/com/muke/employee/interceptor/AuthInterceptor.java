package com.muke.employee.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//用户登录拦截器--废弃
//拦截器只能拦截方法，要拦截jsp使用过滤器。拦截器在struts.xml中配置，过滤器在web.xml中配置
public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object employee = ActionContext.getContext().getSession().get("existEmployee");
		if (employee != null) {
			return invocation.invoke();
		} else {
			ActionContext.getContext().put("msg", "请登录后操作");
			return Action.INPUT;
		}
	}

}
