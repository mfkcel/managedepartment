package com.mfkcel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.mfkcel.dao.RepairDao;
import com.mfkcel.model.Repair;
import com.mfkcel.service.RepairService;

@Repository("repairSerice")
public class RepairServiceImpl implements RepairService {

	@Resource
	private RepairDao repairDao;
	@Override
	public List<Repair> getRepairs() {
		// TODO Auto-generated method stub
		return repairDao.getRepairs();
	}

	@Override
	public Repair getRepairById(String id) {
		// TODO Auto-generated method stub
		return repairDao.getRepairById(id);
	}

	@Override
	public boolean add(Repair repair) {
		// TODO Auto-generated method stub
		return repairDao.add(repair);
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return repairDao.deleteById(id);
	}

	@Override
	public boolean update(Repair repair) {
		// TODO Auto-generated method stub
		return repairDao.update(repair);
	}

}
