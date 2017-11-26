package com.mfkcel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mfkcel.model.Equipment;
import com.mfkcel.service.EquipmentService;
import com.mfkcel.service.EquipmentTypeService;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	
	@Resource
	private EquipmentService equipmentService;
	
	@Resource
	private EquipmentTypeService equipmentTypeService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		String mainPage ="./jsp/equipment/list.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("equipments", equipmentService.getEquipments());
		request.setAttribute("equipmentTypes", equipmentTypeService.getEquipmentTypes());
		return "main";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		equipmentService.deleteById(id);
		//����һ��Ҫ��do
		return "forward:/equipment/list.do";
	}
	
	@RequestMapping("/pre")
	public String pre(HttpServletRequest request) {
		String id = request.getParameter("id");
		String mainPage ="./jsp/equipment/pre.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("equipment", equipmentService.getEquipmentById(id));
		request.setAttribute("equipmentTypes", equipmentTypeService.getEquipmentTypes());
		//����һ��Ҫ��do
		return "main";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request, Equipment equipment) {
		if(equipment.getId() == null) {
			equipmentService.add(equipment);
		} else {
			equipmentService.update(equipment);
		}
		return "forward:/equipment/list.do";
	}
}
