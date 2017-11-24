package com.mfkcel.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mfkcel.dao.DepartmentDao;
import com.mfkcel.model.Department;

class DepartmentDaoImplTest {

	private DepartmentDao departmentDao;
	
	@BeforeEach
	void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		departmentDao = ac.getBean("departmentDao", DepartmentDao.class);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetDepartments() {
		List<Department> lists = departmentDao.getDepartments();
		for(Department department : lists) {
			System.out.println(department);
		}
	}

	@Test
	void testGetDepartmentByDeptId() {
		Department department = departmentDao.getDepartmentByDeptId("3");
		System.out.println(department);
	}

	@Test
	void testAdd() {
		Department department = new Department();
		department.setDepartName("研发部");
		department.setRemark("新产品研发与旧有产品维护");
		departmentDao.add(department);
	}

	@Test
	void testDeleteDepartmentByDeptId() {
		departmentDao.deleteDepartmentByDeptId("5");
	}

	@Test
	void testUpdate() {
		Department department = new Department();
		department.setDepartName("研发部");
		department.setRemark("新产品研发与旧有产品维护,并负责规划公司的品牌战略");
		department.setId(12);
		departmentDao.update(department);
	}

}
