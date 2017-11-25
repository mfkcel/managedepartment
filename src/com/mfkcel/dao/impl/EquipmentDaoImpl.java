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

import com.mfkcel.dao.EquipmentDao;
import com.mfkcel.model.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl implements EquipmentDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Equipment> getEquipments() {
		String sql = "select * from t_equipment";
		return jdbcTemplate.query(sql, new RowMapper<Equipment>() {

			@Override
			public Equipment mapRow(ResultSet rs, int arg1) throws SQLException {
				Equipment equipment = new Equipment();
				equipment.setId(rs.getInt("id"));
				equipment.setName(rs.getString("name"));
				equipment.setNo(rs.getString("no"));
				equipment.setRemark(rs.getString("remark"));
				equipment.setState(rs.getInt("state"));
				equipment.setTypeId(rs.getInt("typeId"));
				return equipment;
			}
		});
	}

	@Override
	public Equipment getEquipmentById(String id) {
		String sql = "select * from t_equipment where id=?";
		return jdbcTemplate.query(sql, new Object[]{id}, new ResultSetExtractor<Equipment>() {

			@Override
			public Equipment extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(!rs.next()) return null;
				Equipment equipment = new Equipment();
				equipment.setId(rs.getInt("id"));
				equipment.setName(rs.getString("name"));
				equipment.setNo(rs.getString("no"));
				equipment.setRemark(rs.getString("remark"));
				equipment.setState(rs.getInt("state"));
				equipment.setTypeId(rs.getInt("typeId"));
				return equipment;
			}
		});
	}

	@Override
	public boolean add(Equipment equipment) {
		String sql = "insert into t_equipment values(null, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql,
				equipment.getName(), equipment.getNo(), equipment.getTypeId(), equipment.getState(), equipment.getRemark());
		if(result == 0) return false;
		return true;
	}

	@Override
	public boolean deleteById(String id) {
		String sql = "delete from t_equipment where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result == 0) return false;
		return true;
	}

	@Override
	public boolean update(Equipment equipment) {
		String sql = "update t_equipment set name=?, no=?, typeId=?, state=?, remark=? where id=?";
		int result = jdbcTemplate.update(sql,
				equipment.getName(), equipment.getNo(), 
				equipment.getTypeId(), equipment.getState(), equipment.getRemark(), equipment.getId());
		if(result == 0) return false;
		return true;
	}

}
