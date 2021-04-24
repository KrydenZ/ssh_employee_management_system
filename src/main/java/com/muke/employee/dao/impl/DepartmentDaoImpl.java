package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	/**
	 * 查询部门总数
	 * 
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		// 注意from的是实体类，而不是表名
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		} else {
			return 0;
		}
	}

	/**
	 * 查询一页的部门数据
	 * 
	 * @param begin
	 * @param pageSize
	 * @return List<Department>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	/**
	 * 添加部门的方法
	 * 
	 * @param department
	 */
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	/**
	 * 查找部门信息
	 * 
	 * @param did
	 * @return Department
	 */
	@Override
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	/**
	 * 修改部门信息
	 * 
	 * @param department
	 */
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	/**
	 * 删除部门信息
	 * 
	 * @param department
	 */
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	/**
	 * 查询所有部门信息
	 * 
	 * @param List<Department>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("select D from Department D");
	}

}
