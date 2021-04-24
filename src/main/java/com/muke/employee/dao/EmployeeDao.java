package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Employee;

public interface EmployeeDao {

	/**
	 * 根据用户名密码查询用户是否存在
	 * 
	 * @param employee
	 * @return Employee
	 */
	Employee findByUsernameAndPassword(Employee employee);

	/**
	 * 查询员工总数
	 * 
	 * @return int
	 */
	int findCount();

	/**
	 * 查询一页显示的员工信息
	 * 
	 * @param begin
	 * @param pageSize
	 * @return List<Employee>
	 */
	List<Employee> findByPage(int begin, int pageSize);

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
