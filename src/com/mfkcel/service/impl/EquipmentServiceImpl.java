package com.mfkcel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mfkcel.dao.EquipmentDao;
import com.mfkcel.model.Equipment;
import com.mfkcel.service.EquipmentService;

@Repository("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

	@Resource
	private EquipmentDao equipmentDao;
	
	@Override
	public List<Equipment> getEquipments() {
		// TODO Auto-generated method stub
		return equipmentDao.getEquipments();
	}

	@Override
	public Equipment getEquipmentById(String id) {
		// TODO Auto-generated method stub
		return equipmentDao.getEquipmentById(id);
	}

	@Override
	public boolean add(Equipment equipment) {
		// TODO Auto-generated method stub
		return equipmentDao.add(equipment);
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return equipmentDao.deleteById(id);
	}

	@Override
	public boolean update(Equipment equipment) {
		// TODO Auto-generated method stub
		return equipmentDao.update(equipment);
	}

}
