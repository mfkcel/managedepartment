package com.mfkcel.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.mfkcel.dao.DepartmentDao;
import com.mfkcel.model.Department;
import com.mfkcel.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	
	@Resource
	private DepartmentDao departmentDao;
	@Override
	public List<Department> getDepartments() {
		return departmentDao.getDepartments();
	}

	@Override
	public Department getDepartmentByDeptId(String deptId) {
		return departmentDao.getDepartmentByDeptId(deptId);
	}

	@Override
	public boolean add(Department department) {
		return departmentDao.add(department);
	}

	@Override
	public boolean deleteDepartmentByDeptId(String deptId) {
		return departmentDao.deleteDepartmentByDeptId(deptId);
	}

	@Override
	public boolean update(Department department) {
		return departmentDao.update(department);
	}

}
