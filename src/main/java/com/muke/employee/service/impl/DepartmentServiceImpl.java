package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	/**
	 * 分页查询部门方法
	 * 
	 * @param currPage
	 * @return PageBean<Department>
	 */
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 添加部门的方法
	 * 
	 * @param department
	 */
	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}

	/**
	 * 查找部门信息
	 * 
	 * @param did
	 * @return Department
	 */
	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	/**
	 * 修改部门信息
	 * 
	 * @param department
	 */
	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	/**
	 * 删除部门信息
	 * 
	 * @param department
	 */
	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	/**
	 * 查询所有部门信息
	 * 
	 * @param List<Department>
	 */
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

}
