package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Department;

public interface DepartmentDao {

	/**
	 * 查询部门总数
	 * 
	 * @return int
	 */
	int findCount();

	/**
	 * 查询一页的部门数据
	 * 
	 * @param begin
	 * @param pageSize
	 * @return List<Department>
	 */
	List<Department> findByPage(int begin, int pageSize);

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
