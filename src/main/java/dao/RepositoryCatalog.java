package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.AddressMapper;
import dao.mappers.PersonMapper;
import dao.mappers.RolesPermissionsMapper;
import dao.mappers.UserMapper;
import dao.mappers.UserRolesMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog {

	IPersonRepository peopleRepo;
	IAddressRepository addressRepo;
	
	IUserRepository userRepo;
	
	IUnitOfWork uow;
	Connection connection;
	
	//konstruktor z podawanym parameterm polaczenia
	public RepositoryCatalog(Connection connection) throws SQLException {
		this.connection = connection;
		uow = new UnitOfWork(connection);
	//mapery (dla odpowienich reposytoriów dla odpowiednich person/address/ czy users) jako parametry
	//dla repozytoriow.
		peopleRepo = new PersonRepository(connection, new PersonMapper(), uow);
		addressRepo = new AddressRepository(connection, new AddressMapper(), uow);
	//uzycie -stworzenie repozytoriow dla userow i ich uprawnien (calego mechanizmu uprawnien) (		
		userRepo = new UserRepository(connection, new UserMapper(), new UserRolesMapper(), new RolesPermissionsMapper(), uow);
	}

	public IPersonRepository people() {
		return peopleRepo;
	}

	public IAddressRepository addresses() {
		return addressRepo;
	}

	public IUserRepository users() {
		return userRepo;
	}

	public void saveAndClose() throws SQLException {
		uow.saveChanges();
		connection.close();
		connection=null;
		
	}

	@Override
	public IRoleRepository userroles() {
		// TODO Auto-generated method stub
		return null;
	}

}
