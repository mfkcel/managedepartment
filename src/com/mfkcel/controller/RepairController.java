package com.mfkcel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mfkcel.model.Repair;
import com.mfkcel.service.EquipmentService;
import com.mfkcel.service.RepairService;
import com.mfkcel.service.UserService;

@Controller
@RequestMapping("/repair")
public class RepairController {
	@Resource
	private RepairService repairService;
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		String mainPage ="./jsp/repair/list.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("repairs", repairService.getRepairs());
		
		return "main";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		repairService.deleteById(id);
		//这里一定要带do
		return "forward:/repair/list.do";
	}
	
	@RequestMapping("/pre")
	public String pre(HttpServletRequest request) {
		String id = request.getParameter("id");
		String mainPage ="./jsp/repair/pre.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("repair", repairService.getRepairById(id));
		request.setAttribute("users", userService.getUsersByRoleName("使用者"));
		request.setAttribute("rusers", userService.getUsersByRoleName("维修者"));
		request.setAttribute("equipments", equipmentService.getEquipments());
		//这里一定要带do
		return "main";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request, Repair repair) {
		if(repair.getId() == null) {
			repairService.add(repair);
		} else {
			repairService.update(repair);
		}
		return "forward:/repair/list.do";
	}
}
