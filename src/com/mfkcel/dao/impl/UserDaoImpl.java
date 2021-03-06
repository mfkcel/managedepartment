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

import com.mfkcel.dao.UserDao;
import com.mfkcel.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public User login(User user) {
		String sql = "select * from t_user where userName = ? and password = ?";
		User rUser = jdbcTemplate.query(sql, new Object[]{user.getUserName(), user.getPassword()}, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(!rs.next()) return null;
				User tUser = new User();
				tUser.setId(rs.getInt("id"));
				tUser.setUserName(rs.getString("userName"));
				tUser.setPassword(rs.getString("password"));
				tUser.setTrueName(rs.getString("trueName"));
				tUser.setRoleName(rs.getString("roleName"));
				tUser.setDeptId(rs.getInt("deptId"));
				return tUser;
			}
		});
		if(rUser == null) return user;
		return rUser;
	}

	@Override
	public List<User> getUsersByRoleName(String roleName) {
		String sql = "select * from t_user where roleName=?";
		return jdbcTemplate.query(sql, new Object[] {roleName}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setUserName(rs.getString("userName"));
				return user;
			}
		});
	}

	
	
	@Override
	public List<User> getUsers() {
		String sql = "select * from t_user";
		return jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setTrueName(rs.getString("trueName"));
				user.setRoleName(rs.getString("roleName"));
				user.setDeptId(rs.getInt("deptId"));
				return user;
			}
		});
	}

	@Override
	public User getUserById(String id) {
		String sql = "select * from t_user where id=?";
		return jdbcTemplate.query(sql, new Object[] {id}, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setTrueName(rs.getString("trueName"));
				user.setRoleName(rs.getString("roleName"));
				user.setDeptId(rs.getInt("deptId"));
				return user;
			}
		});
	}

	@Override
	public boolean deleteById(String id) {
		String sql = "delete from t_user where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result == 0) return false;
		return true;
	}

	@Override
	public boolean add(User user) {
		String sql = "insert into t_user values(null, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, 
				user.getUserName(), user.getPassword(), user.getTrueName(), user.getRoleName(), user.getDeptId());
		if(result == 0) return false;
		return true;
	}

	@Override
	public boolean update(User user) {
		String sql = "update t_user set userName=?, password=?, trueName=?, roleName=?, deptId=? where id=?";
		int result = jdbcTemplate.update(sql, user.getUserName(), user.getPassword(), 
				user.getTrueName(), user.getRoleName(), user.getDeptId(), user.getId());
		if(result == 0) return false;
		return true;
	}
}
