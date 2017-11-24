package com.mfkcel.service;

import java.util.List;
import com.mfkcel.model.Department;

public interface DepartmentService {
	public List<Department> getDepartments();
	public Department getDepartmentByDeptId(String deptId);
	public boolean add(Department department);
	public boolean deleteDepartmentByDeptId(String deptId);
	public boolean update(Department department);
}
