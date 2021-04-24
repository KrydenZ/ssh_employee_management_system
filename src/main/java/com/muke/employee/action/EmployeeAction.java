package com.muke.employee.action;

import java.util.List;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理用action
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;

	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		return employee;
	}

	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 分页查询员工的方法
	 * 
	 * @return String
	 */
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	/**
	 * 跳转到添加员工页面的方法
	 * 
	 * @return String
	 */
	public String saveUI() {
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}

	/**
	 * 保存员工的执行方法
	 * 
	 * @return String
	 */
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}

	/**
	 * 编辑员工的执行方法
	 * 
	 * @return String
	 */
	public String edit() {
		// 根据员工id查询员工
		employee = employeeService.findById(employee.getEid());
		// 查询所有的部门
		List<Department> list = departmentService.findAll();
		// 模型驱动的对象employee本身就在栈里面，只需把list放进去就好了
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}

	/**
	 * 编辑员工的更新方法
	 * 
	 * @return String
	 */
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}

	/**
	 * 删除员工的方法
	 * 
	 * @return String
	 */
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
