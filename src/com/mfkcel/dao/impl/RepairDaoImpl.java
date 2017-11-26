package com.mfkcel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mfkcel.dao.RepairDao;
import com.mfkcel.model.Repair;

@Repository("repairDao")
public class RepairDaoImpl implements RepairDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Repair> getRepairs() {
		String sql = "SELECT a.id, a.equipmentId, a.userman, a.repairman, a.repairTime, a.finishTime, a.state, a.finishState, b.name, c.typeName"
				+ " FROM t_repair AS a, t_equipment AS b, t_equipmenttype AS c " 
				+ "WHERE a.equipmentId = b.id AND b.typeId = c.id";
		return jdbcTemplate.query(sql, new RowMapper<Repair>() {

			@Override
			public Repair mapRow(ResultSet rs, int arg1) throws SQLException {
				Repair repair = new Repair();
				repair.setId(rs.getInt("id"));
				repair.setEquipmentId(rs.getInt("equipmentId"));
				repair.setUserman(rs.getString("userman"));
				repair.setEquiptName(rs.getString("name"));
				repair.setEquiptTypeName(rs.getString("typeName"));
				repair.setRepairmen(rs.getString("repairman"));
				repair.setRepairTime(rs.getDate("repairTime"));
				repair.setFinishTime(rs.getDate("finishTime"));
				repair.setFinishState(rs.getInt("finishState"));
				repair.setState(rs.getInt("state"));
				return repair;
			}
		});
	}

	@Override
	public Repair getRepairById(String id) {
		String sql = "SELECT a.id, a.equipmentId, a.userman, a.repairman, a.repairTime, a.finishTime, a.state, a.finishState, b.name, c.typeName"
				+ " FROM t_repair AS a, t_equipment AS b, t_equipmenttype AS c " 
				+ "WHERE a.id=? and a.equipmentId = b.id AND b.typeId = c.id";
		return jdbcTemplate.query(sql, new Object[]{id}, new ResultSetExtractor<Repair>() {

			@Override
			public Repair extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(!rs.next()) return null;
				Repair repair = new Repair();
				repair.setId(rs.getInt("id"));
				repair.setEquipmentId(rs.getInt("equipmentId"));
				repair.setEquiptName(rs.getString("name"));
				repair.setEquiptTypeName(rs.getString("typeName"));
				repair.setUserman(rs.getString("userman"));
				repair.setRepairmen(rs.getString("repairman"));
				repair.setRepairTime(rs.getDate("repairTime"));
				repair.setFinishTime(rs.getDate("finishTime"));
				repair.setFinishState(rs.getInt("finishState"));
				repair.setState(rs.getInt("state"));
				return repair;
			}
		});
	}

	@Override
	public boolean add(Repair repair) {
		String sql = "insert into t_repair values(null, ?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, repair.getEquipmentId(), repair.getUserman(),
				repair.getRepairmen(), repair.getRepairTime(), repair.getFinishTime(),
				repair.getFinishState(), repair.getState());
		if(result == 0) return false;
		else return true;
	}

	@Override
	public boolean deleteById(String id) {
		String sql = "delete from t_repair where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result == 0) return false;
		else return true;	}

	@Override
	public boolean update(Repair repair) {
		String sql = "update t_repair set equipmentId=?, userman=?, repairman=?,"
				+ "repairtime=?, finishtime=?, finishstate=?, state=? where id=?";
		int result = jdbcTemplate.update(sql, repair.getEquipmentId(), repair.getUserman(),
				repair.getRepairmen(), repair.getRepairTime(), repair.getFinishTime(),
				repair.getFinishState(), repair.getState(), repair.getId());
		if(result == 0) return false;
		else return true;
	}

}
