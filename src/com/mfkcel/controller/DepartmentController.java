package com.mfkcel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mfkcel.model.Department;
import com.mfkcel.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		String mainPage ="./jsp/department/list.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("departments", departmentService.getDepartments());
		return "main";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		departmentService.deleteDepartmentByDeptId(id);
		//这里一定要带do
		return "forward:/department/list.do";
	}
	
	@RequestMapping("/pre")
	public String pre(HttpServletRequest request) {
		String id = request.getParameter("id");
		String mainPage ="./jsp/department/pre.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("department", departmentService.getDepartmentByDeptId(id));
		//这里一定要带do
		return "main";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request, Department department) {
		if(department.getId() == null) {
			departmentService.add(department);
		} else {
			departmentService.update(department);
		}
		return "forward:/department/list.do";
	}
}
