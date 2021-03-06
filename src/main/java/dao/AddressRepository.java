package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.mappers.IMapResultSetToEntity;
import dao.uow.IUnitOfWork;
import dao.uow.IUnitOfWorkRepository;
import domain.Address;
import domain.Person;

public class AddressRepository extends RepositoryBase<Address> implements IAddressRepository{

	//repozytorium adresow
	
	public AddressRepository(Connection connection,
			IMapResultSetToEntity<Address> mapper,
			IUnitOfWork uow) {
		super(connection, mapper, uow);
	}
	
	protected void setUpdateQuery(Address a) throws SQLException {
		update.setString(1, a.getStreetName());
		update.setInt(2, a.getStreetNumber());
		update.setString(3, a.getHouseNumber());
		update.setString(4, a.getCity());
		update.setString(5, a.getPostcode());
		update.setInt(6, a.getId());
	}
	
	protected void setInsertQuery(Address a) throws SQLException {
		insert.setString(1, a.getStreetName());
		insert.setInt(2, a.getStreetNumber());
		insert.setString(3, a.getHouseNumber());
		insert.setString(4, a.getCity());
		insert.setString(5, a.getPostcode());
	}
	
	@Override
	protected String tableName() {
		return "Address";
	}
	@Override
	protected String createTableSql() {
		return 
				"CREATE TABLE address("
						+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
						+ "streetName VARCHAR(50),"
						+ "streetNumber bigint,"
						+ "houseNumber VARCHAR(10),"
						+ "city VARCHAR(50),"
						+ "postcode VARCHAR(5)"			
						+ ")";
	}
	@Override
	protected String insertSql() {
		return 
				"INSERT INTO "
				+ "address(streetName, streetNumber, houseNumber, city, postcode)"
				+ " VALUES (?,?,?,?,?)";
	}
	@Override
	protected String updateSql() {
		return "UPDATE address SET streetName = ?, streetNumber = ?, houseNumber = ?, city = ?, postcode = ? WHERE id = ?";
		
	}

	public List<Address> byPerson(Person person) {
		//@formatter:off
		return getAll()
				.stream()
				.filter(a -> person.equals(a.getPerson()))
				.collect(Collectors
						.toCollection(ArrayList::new));
		//@formatter:on
	}
	
}
