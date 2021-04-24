package com.muke.employee.service;

import java.util.List;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;

public interface DepartmentService {

	/**
	 * 分页查询部门方法
	 * 
	 * @param currPage
	 * @return PageBean<Department>
	 */
	PageBean<Department> findByPage(Integer currPage);

	/**
	 * 添加部门的方法
	 * 
	 * @param department
	 */
	void save(Department department);

	/**
	 * 查找部门信息
	 * 
	 * @param did
	 * @return Department
	 */
	Department findById(Integer did);

	/**
	 * 修改部门信息
	 * 
	 * @param department
	 */
	void update(Department department);

	/**
	 * 删除部门信息
	 * 
	 * @param department
	 */
	void delete(Department department);

	/**
	 * 查询所有部门信息
	 * 
	 * @param List<Department>
	 */
	List<Department> findAll();

}
