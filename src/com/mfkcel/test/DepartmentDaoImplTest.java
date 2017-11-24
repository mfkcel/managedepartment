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
		department.setDepartName("�з���");
		department.setRemark("�²�Ʒ�з�����в�Ʒά��");
		departmentDao.add(department);
	}

	@Test
	void testDeleteDepartmentByDeptId() {
		departmentDao.deleteDepartmentByDeptId("5");
	}

	@Test
	void testUpdate() {
		Department department = new Department();
		department.setDepartName("�з���");
		department.setRemark("�²�Ʒ�з�����в�Ʒά��,������滮��˾��Ʒ��ս��");
		department.setId(12);
		departmentDao.update(department);
	}

}
