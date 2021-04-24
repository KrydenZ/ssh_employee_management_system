package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	/**
	 * 根据用户名密码查询用户是否存在
	 * 
	 * @param employee
	 * @return Employee
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// 注意hql语句from的是对象
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 查询员工总数
	 * 
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		} else {
			return 0;
		}
	}

	/**
	 * 查询一页显示的员工信息
	 * 
	 * @param begin
	 * @param pageSize
	 * @return List<Employee>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	/**
	 * 保存员工的执行方法
	 * 
	 * @param employee
	 */
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	/**
	 * 根据员工id查询员工
	 * 
	 * @param eid
	 * @return Employee
	 */
	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	/**
	 * 编辑员工的更新方法
	 * 
	 * @param employee
	 */
	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	/**
	 * 删除员工的方法
	 * 
	 * @param employee
	 */
	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

}
