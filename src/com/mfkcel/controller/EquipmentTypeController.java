package com.mfkcel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mfkcel.model.EquipmentType;
import com.mfkcel.service.EquipmentTypeService;

@Controller
@RequestMapping("/equipmenttype")
public class EquipmentTypeController {
	@Resource
	private EquipmentTypeService  equipmentTypeService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		String mainPage ="./jsp/equipmenttype/list.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("equipmentTypes", equipmentTypeService.getEquipmentTypes());
		return "main";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		equipmentTypeService.deleteByid(id);
		//这里一定要带do
		return "forward:/equipmenttype/list.do";
	}
	
	@RequestMapping("/pre")
	public String pre(HttpServletRequest request) {
		String id = request.getParameter("id");
		String mainPage ="./jsp/equipmenttype/pre.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("equipmentType", equipmentTypeService.getEquipmentType(id));
		//这里一定要带do
		return "main";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request, EquipmentType equipmentType) {
		if(equipmentType.getId() == null) {
			equipmentTypeService.add(equipmentType);
		} else {
			equipmentTypeService.update(equipmentType);
		}
		return "forward:/equipmenttype/list.do";
	}
}
