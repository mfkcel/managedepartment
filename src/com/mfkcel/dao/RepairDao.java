package com.mfkcel.dao;

import java.util.List;

import com.mfkcel.model.Repair;

public interface RepairDao {
	public List<Repair> getRepairs();
	public Repair getRepairById(String id);
	public boolean add(Repair repair);
	public boolean deleteById(String id);
	public boolean update(Repair repair);
}
