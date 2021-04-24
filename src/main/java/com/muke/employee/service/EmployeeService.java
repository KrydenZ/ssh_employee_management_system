package com.muke.employee.service;

import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;

public interface EmployeeService {

	/**
	 * 用户登录用方法
	 * 
	 * @param employee
	 * @return Employee
	 */
	Employee login(Employee employee);

	/**
	 * 分页查询员工的方法
	 * 
	 * @param currPage
	 * @return PageBean<Employee>
	 */
	PageBean<Employee> findByPage(Integer currPage);

	/**
	 * 保存员工的执行方法
	 * 
	 * @param employee
	 */
	void save(Employee employee);

	/**
	 * 根据员工id查询员工
	 * 
	 * @param eid
	 * @return Employee
	 */
	Employee findById(Integer eid);

	/**
	 * 编辑员工的更新方法
	 * 
	 * @param employee
	 */
	void update(Employee employee);

	/**
	 * 删除员工的方法
	 * 
	 * @param employee
	 */
	void delete(Employee employee);

}
