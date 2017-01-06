package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;

public class UserMapper implements IMapResultSetToEntity<User> {
//mapa dla user/login & pwd
	@Override
	public User map(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setLogin(rs.getString("login"));
		u.setPassword(rs.getString("password"));
		return u;
	}

}
