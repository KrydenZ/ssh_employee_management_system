package com.muke.employee.action;

import com.muke.employee.domain.Employee;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//用户登录用的Action
public class LoginAction extends ActionSupport implements ModelDriven<Employee> {

	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		return employee;
	}

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 登录方法
	public String login() {
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码填写错误");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	// 跳转到登录页面
	public String tolog() {
		ActionContext.getContext().put("msg", "请登录后操作");
		return "tolog";
	}

	// 退出登录
	public String logout() {
		ActionContext.getContext().getSession().put("existEmployee", null);
		return "logout";
	}

}
