package com.mfkcel.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.mfkcel.dao.UserDao;
import com.mfkcel.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User login(User user) {
		String sql = "select count(*) from t_user";
		int count = jdbcTemplate.execute(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement(sql);
			}
		}, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement psmt) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				psmt.execute();
				ResultSet rs = psmt.getResultSet();
				rs.next();
				return rs.getInt(1);
			}
		});
		
		System.out.println("count: " + count);
		return null;
	}
	
	//Ԥ���������ֵ�ص�ʹ��, ֱ��ʹ��PreparedStatement, 1. new PreparedStatementCreator()
	//2.new PreparedStatementCallback()
	//���ض��ֵ�� login3(User user)
	//ȱ�������ж���Ҫ�Լ����з�װ
	//����ʹ��PreparedStatementCreator����һ��Ԥ������䣬
	//�����JdbcTemplateͨ��PreparedStatementCallback�ص����أ����û��������ִ�и�PreparedStatement
	//jdbcTemplate�ṩ�ķ������·�Ϊ����
	//һ���Ǿ����ṩ�ص��ӿ����û�������ʲô
	//����һ�ֿ�����Ϊ�Ǳ�����������queryForXXX����������Щ�Ƚϼ򵥵Ĳ���
	public User login2(User user) {
		String sql = "select * from t_user where userName = ? and password = ?";
		User ruser = jdbcTemplate.execute(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement(sql);
			}
		}, new PreparedStatementCallback<User>() {

			@Override
			public User doInPreparedStatement(PreparedStatement psmt) throws SQLException, DataAccessException {
				psmt.setString(1, user.getUserName());
				psmt.setString(2, user.getPassword());
				psmt.executeQuery();
				ResultSet rs = psmt.getResultSet();
				if(!rs.next()) {
					return null;
				}
				User tuser = new User(rs.getString("userName"), rs.getString("password"));
				return tuser;
			}
		});
		return ruser;
	}
	
	public List<User> login3(User user) {
		String sql = "select * from t_user ";
		List<User> userList = jdbcTemplate.execute(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement(sql);
			}
		}, new PreparedStatementCallback<List<User>>() {

			@Override
			public List<User> doInPreparedStatement(PreparedStatement psmt) throws SQLException, DataAccessException {
				
				psmt.executeQuery();
				ResultSet rs = psmt.getResultSet();
				List<User> users = new ArrayList<>();
				while(rs.next()) {
					User user = new User(rs.getString("userName"), rs.getString("password"));
					users.add(user);
				}
				return users;
			}
		});
		return userList;
	}
	
	//JdbcTemplate �� queryForObject ֻ���ص���ֵ���һ��Ҫע��,���Ƿ���һ������  ��Ҫ������������ƭ
	/*public User login4(User user) {
		String sql = "select * from t_user where userName=? and password=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {user.getUserName(), user.getPassword()}, User.class);
	}*/
	
	public User login5(User user) {
		String sql = "select * from t_user where userName = ? and password = ?";
		User rUser = jdbcTemplate.query(sql, new Object[]{user.getUserName(), user.getPassword()}, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(!rs.next()) return null;
				User tUser = new User(rs.getString("userName"), rs.getString("password"));
				return tUser;
			}
		});
		return rUser;
	}
	
	public User login6(User user) {
		String sql = "select * from t_user where userName = ? and password = ?";
		User tUser = new User();
		jdbcTemplate.query(sql, new Object[]{user.getUserName(), user.getPassword()}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				tUser.setUserName(rs.getString("userName"));
				tUser.setPassword(rs.getString("password"));
			}
		});
		return tUser;
	}
}
