package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Address;

public class AddressMapper implements IMapResultSetToEntity<Address> {
//mapowanie z setu rezultatow danego addresu
	public Address map(ResultSet rs) throws SQLException {
		Address a = new Address();
		a.setId(rs.getInt("id"));
		a.setStreetName(rs.getString("streetName"));
		a.setStreetNumber(rs.getInt("streetNumber"));
		a.setHouseNumber(rs.getString("houseNumber"));
		a.setCity(rs.getString("city"));
		a.setPostcode(rs.getString("postcode"));
		return a;
	}

}
