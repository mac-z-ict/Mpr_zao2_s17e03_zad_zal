package domain;

import java.util.Set;

public class User extends Entity implements IHaveId {
	
	private int id;
	private String login;
	private String password;
	
	private Set<UserRoles> roles;
	private Set<RolesPermissions> rolesPermissions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

	public Set<RolesPermissions> getRolesPermissions() {
		return rolesPermissions;
	}

	public void setRolesPermissions(Set<RolesPermissions> rolesPermissions) {
		this.rolesPermissions = rolesPermissions;
	}

}
