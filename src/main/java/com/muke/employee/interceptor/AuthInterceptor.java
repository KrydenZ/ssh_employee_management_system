package com.muke.employee.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限拦截器--废弃 </br>
 * 拦截器只能拦截方法，依然可能访问一些静态资源。 使用过滤器拦截所有请求。</br>
 * 拦截器在struts.xml中配置，过滤器在web.xml中配置
 */
public class AuthInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

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
