package com.mfkcel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mfkcel.dao.EquipmentTypeDao;
import com.mfkcel.model.EquipmentType;
import com.mfkcel.service.EquipmentTypeService;

@Service("equipmentTypeService")
public class EquipmentTypeServiceImpl implements EquipmentTypeService{
	
	@Resource
	private EquipmentTypeDao equipmentTypeDao;

	@Override
	public List<EquipmentType> getEquipmentTypes() {
		// TODO Auto-generated method stub
		return equipmentTypeDao.getEquipmentTypes();
	}

	@Override
	public EquipmentType getEquipmentType(String id) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.getEquipmentType(id);
	}

	@Override
	public boolean add(EquipmentType equipmentType) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.add(equipmentType);
	}

	@Override
	public boolean deleteByid(String id) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.deleteByid(id);
	}

	@Override
	public boolean update(EquipmentType equipmentType) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.update(equipmentType);
	}
	
}
