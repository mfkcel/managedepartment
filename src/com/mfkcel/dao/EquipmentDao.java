package com.mfkcel.dao;

import java.util.List;

import com.mfkcel.model.Equipment;

public interface EquipmentDao {
	public List<Equipment> getEquipments();
	public Equipment getEquipmentById(String id);
	public boolean add(Equipment equipment);
	public boolean deleteById(String id);
	public boolean update(Equipment equipment);
}
