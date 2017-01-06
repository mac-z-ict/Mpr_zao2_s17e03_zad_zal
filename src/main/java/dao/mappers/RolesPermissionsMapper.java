package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.RolesPermissions;

public class RolesPermissionsMapper implements IMapResultSetToEntity<RolesPermissions> {
//maper dla roli
	@Override
	public RolesPermissions map(ResultSet rs) throws SQLException {
		RolesPermissions rp = new RolesPermissions();
		rp.setId(rs.getInt("id"));
		rp.setRoleId(rs.getInt("roleId"));
		rp.setPermissionId(rs.getInt("permissionId"));
		return rp;
	}

}
