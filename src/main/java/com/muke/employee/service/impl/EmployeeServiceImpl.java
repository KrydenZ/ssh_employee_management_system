package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.EmployeeService;

@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * 用户登录用方法
	 * 
	 * @param employee
	 * @return Employee
	 */
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	/**
	 * 分页查询员工的方法
	 * 
	 * @param currPage
	 * @return PageBean<Employee>
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 保存员工的执行方法
	 * 
	 * @param employee
	 */
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	/**
	 * 根据员工id查询员工
	 * 
	 * @param eid
	 * @return Employee
	 */
	@Override
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}

	/**
	 * 编辑员工的更新方法
	 * 
	 * @param employee
	 */
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	/**
	 * 删除员工的方法
	 * 
	 * @param employee
	 */
	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

}
