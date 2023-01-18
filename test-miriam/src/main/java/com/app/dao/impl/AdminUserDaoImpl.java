package com.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.app.dao.AdminUserDao;
import com.app.modelo.RoleUser;
import com.app.modelo.login.UserInfo;
import com.app.utils.MyStoredProcedure;
import com.spring.model.UserDetails;

@Component
public class AdminUserDaoImpl implements AdminUserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<UserDetails> findAllUsers() {
		List<UserDetails> listUsuarios = new ArrayList<UserDetails>();
		String query = "SELECT `usuario`.`idusuario`," + "    `usuario`.`nombre`, " + "    `usuario`.`rfc`, "
				+ "    `usuario`.`email`, " + "    `usuario`.`observaciones` " + "FROM `testmiriam`.`usuario`;";
		System.out.println("------>user]" + query);

		Collection users = jdbcTemplate.query(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				UserDetails user = new UserDetails();

				user.setId(rs.getInt("idusuario"));
				user.setNombre(rs.getString("nombre"));
				user.setRfc(rs.getString("rfc"));
				user.setObservaciones(rs.getString("observaciones"));
				user.setEmail(rs.getString("email"));

				return user;
			}
		});

		for (Object user : users) {
			UserDetails userA = (UserDetails) user;

			listUsuarios.add(userA);

		}

		return listUsuarios;

	}

	public void saveUser(UserDetails user) {
		
		String sql = "insert into usuario(nombre, rfc,email,observaciones) values(?, ?,?,?)";
		jdbcTemplate.update(sql,				
				user.getNombre(),
				user.getRfc(),
				user.getEmail(),
				user.getObservaciones()
				);


	}

}
