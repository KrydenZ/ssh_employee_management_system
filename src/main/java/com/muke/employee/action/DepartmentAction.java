package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门管理Action
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private static final long serialVersionUID = 1L;

	// 模型驱动使用的对象
	private Department department = new Department();

	@Override
	public Department getModel() {
		return department;
	}

	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 分页查询部门的方法
	 * 
	 * @return String
	 */
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	/**
	 * 跳转到添加部门的页面的方法
	 * 
	 * @return String
	 */
	public String saveUI() {
		return "saveUI";
	}

	/**
	 * 添加部门的方法
	 * 
	 * @return String
	 */
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}

	/**
	 * 跳转到修改部门的页面的方法
	 * 
	 * @return String
	 */
	public String edit() {
		// 将通过getModel将返回对象放在值栈中
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}

	/**
	 * 执行修改部门操作的方法
	 * 
	 * @return String
	 */
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}

	/**
	 * 执行删除部门操作的方法
	 * 
	 * @return String
	 */
	public String delete() {
		// 要实现级联删除必须先查询再删除
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
