package com.app.dao.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.modelo.login.UserInfo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List list() {
		String query = "select username from usuarios";

		List list = jdbcTemplate.query(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				List<UserInfo> list = new ArrayList<UserInfo>();

				UserInfo user = new UserInfo();
				user.setUsername(rs.getString("username"));
						
				list.add(user);

				return list;
			}
		});

		return list;
	}

	private SqlParameterSource getSqlParameterSource(String username, String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (username != null) {
			parameterSource.addValue("username", username);
		}
		if (password != null) {
			parameterSource.addValue("password", password);
		}

		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo user = new UserInfo();
			user.setUsername(rs.getString("username"));

			return user;
		}

	}

	public UserInfo findUserByUsername(String username) {
		String query = "select username from usuarios where username = '"+username+"'";

//		List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
		List list = jdbcTemplate.query(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				List<UserInfo> list = new ArrayList<UserInfo>();

				UserInfo user = new UserInfo();
				user.setUsername(rs.getString("username"));
						
				list.add(user);

				return list;
			}
		});
		
		for(Object user : list){
			return (UserInfo) user;
		}

		return null;
	}

	public void update(String username, String password) {
		String sql = "update usuarios set pass = ? where username = ?";

		jdbcTemplate.update(sql,				
				password,
				username);
	}

	public void add(String username, String password) {
		String sql = "insert into usuarios(username, pass) values(?, ?)";
//		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
		jdbcTemplate.update(sql,				
				username,
				password
				);

		sql = "insert into usuarios_has_roles(Usuarios_userName, Roles_idRoles) values(?, ?)";
//		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
		jdbcTemplate.update(sql,				
				username,
				4);
	}

	public boolean userExists(String username) {
		String query = "select * from usuarios where username = '"+username+"'";

//		List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());

		List list = jdbcTemplate.query(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				List<UserInfo> list = new ArrayList<UserInfo>();

				UserInfo user = new UserInfo();
				user.setUsername(rs.getString("username"));
						
				list.add(user);

				return list;
			}
		});
		
		for(Object user : list){
			return true;
		}
		

		return false;
	}

}
