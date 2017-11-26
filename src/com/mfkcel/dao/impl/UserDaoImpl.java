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
				User tUser = new User(rs.getString("userName"), rs.getString("password"));
				tUser.setDeptId(rs.getInt("deptId"));
				tUser.setId(rs.getInt("id"));
				tUser.setRoleName(rs.getString("roleName"));
				tUser.setTrueName(rs.getString("trueName"));
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
	
}
