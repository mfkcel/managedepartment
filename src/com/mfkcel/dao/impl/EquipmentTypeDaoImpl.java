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

import com.mfkcel.dao.EquipmentTypeDao;
import com.mfkcel.model.EquipmentType;

@Repository("equipmentTypeDao")
public class EquipmentTypeDaoImpl implements EquipmentTypeDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<EquipmentType> getEquipmentTypes() {
		String sql = "select * from t_equipmenttype";
		return jdbcTemplate.query(sql, new RowMapper<EquipmentType>() {

			@Override
			public EquipmentType mapRow(ResultSet rs, int arg1) throws SQLException {
				EquipmentType equipmentType = new EquipmentType();
				equipmentType.setId(rs.getInt("id"));
				equipmentType.setTypeName(rs.getString("typeName"));
				equipmentType.setRemark(rs.getString("remark"));
				return equipmentType;
			}
		});
	}

	@Override
	public EquipmentType getEquipmentType(String id) {
		String sql = "select * from t_equipmenttype where id=?";
		return jdbcTemplate.query(sql, new Object[]{id}, new ResultSetExtractor<EquipmentType>() {

			@Override
			public EquipmentType extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(!rs.next()) return null;
				EquipmentType equipmentType = new EquipmentType();
				equipmentType.setId(rs.getInt("id"));
				equipmentType.setTypeName(rs.getString("typeName"));
				equipmentType.setRemark(rs.getString("remark"));
				return equipmentType;
			}
		});
	}

	@Override
	public boolean add(EquipmentType equipmentType) {
		String sql = "insert into t_equipmenttype values(null, ?, ?)";
		int result = jdbcTemplate.update(sql, equipmentType.getTypeName(), equipmentType.getRemark());
		if(result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByid(String id) {
		String sql = "delete from t_equipmenttype where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(EquipmentType equipmentType) {
		String sql = "update t_equipmenttype set typeName=?, remark=? where id=?";
		int result = jdbcTemplate.update(sql, equipmentType.getTypeName(), equipmentType.getRemark(), equipmentType.getId());
		if(result == 0) {
			return false;
		}
		return true;
	}

}
