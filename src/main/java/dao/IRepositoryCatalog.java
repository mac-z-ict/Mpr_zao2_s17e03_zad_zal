package dao;

import java.sql.SQLException;

public interface IRepositoryCatalog {
//interface dla reposytoriow
	
	
	public IPersonRepository people();
	public IAddressRepository addresses();
	public IUserRepository users();
	public IRoleRepository userroles();
	public void saveAndClose() throws SQLException;
	
}
