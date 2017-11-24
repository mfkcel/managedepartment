package com.mfkcel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mfkcel.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		String mainPage ="./jsp/departlist.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("departments", departmentService.getDepartments());
		return "main";
	}
}
