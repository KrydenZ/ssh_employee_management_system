package com.muke.employee.action;

import com.muke.employee.domain.Employee;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户登录Action
 */
public class LoginAction extends ActionSupport implements ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;

	// 模型驱动使用的对象
	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		return employee;
	}

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * 用户登录用方法
	 * 
	 * @return String
	 */
	public String login() {
		// 判断用户是否存在
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			// 登录失败
			this.addActionError("用户名或密码填写错误");
			return INPUT;
		} else {
			// 登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	/**
	 * 用户未登录，重定向到登录页面
	 * 
	 * @return String
	 */
	public String tolog() {
		ActionContext.getContext().put("msg", "请登录后操作");
		return "tolog";
	}

	/**
	 * 退出登录
	 * 
	 * @return String
	 */
	public String logout() {
		ActionContext.getContext().getSession().put("existEmployee", null);
		return "logout";
	}

}
