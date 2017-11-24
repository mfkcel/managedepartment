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

import com.mfkcel.dao.DepartmentDao;
import com.mfkcel.model.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Department> getDepartments() {
		String sql = "select * from t_department";
		return jdbcTemplate.query(sql, new RowMapper<Department>() {

			@Override
			public Department mapRow(ResultSet rs, int arg1) throws SQLException {
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setDepartName(rs.getString("deptName"));
				department.setRemark(rs.getString("remark"));
				return department;
			}
		});
	}

	@Override
	public Department getDepartmentByDeptId(String deptId) {
		String sql = "select * from t_department where id=?";
		//在mysql数据库中id 是整数，给jdbctemplate传入参数时可以是String类型，它自己会自动匹配类型
		return jdbcTemplate.query(sql, new Object[]{deptId}, new ResultSetExtractor<Department>() {

			@Override
			public Department extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Department department = new Department();
					department.setId(rs.getInt("id"));
					department.setDepartName(rs.getString("deptName"));
					department.setRemark(rs.getString("remark"));
					return department;
				}
				return null;
			}
		});
	}

	@Override
	public boolean add(Department department) {
		String sql = "insert into t_department values(null, ?, ?)";
		int result = jdbcTemplate.update(sql, department.getDepartName(), department.getRemark());
		if(result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDepartmentByDeptId(String deptId) {
		String sql = "delete from t_department where id=?";
		int result = jdbcTemplate.update(sql, deptId);
		if(result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Department department) {
		String sql = "update t_department set deptName=? ,remark=? where id=?";
		int result = jdbcTemplate.update(sql, department.getDepartName(), department.getRemark(), department.getId());
		if(result == 0) {
			return false;
		}
		return true;
	}

}
