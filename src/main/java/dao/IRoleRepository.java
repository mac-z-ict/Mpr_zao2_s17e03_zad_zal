package dao;

import java.util.List;

import domain.Role;
import domain.User;

//interface dla rol repozytorium


public interface IRoleRepository  {
	
	public List<Role> byUser(User user);

}
