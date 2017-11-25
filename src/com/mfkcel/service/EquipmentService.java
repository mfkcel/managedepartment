package com.mfkcel.service;

import java.util.List;

import com.mfkcel.model.Equipment;

public interface EquipmentService {
	public List<Equipment> getEquipments();
	public Equipment getEquipmentById(String id);
	public boolean add(Equipment equipment);
	public boolean deleteById(String id);
	public boolean update(Equipment equipment);
}
