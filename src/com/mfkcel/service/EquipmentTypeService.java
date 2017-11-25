package com.mfkcel.service;

import java.util.List;

import com.mfkcel.model.EquipmentType;

public interface EquipmentTypeService {
	public List<EquipmentType> getEquipmentTypes();
	public EquipmentType getEquipmentType(String id);
	public boolean add(EquipmentType equipmentType);
	public boolean deleteByid(String id);
	public boolean update(EquipmentType equipmentType);
}
