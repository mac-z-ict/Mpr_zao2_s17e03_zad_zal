package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
//interface dla maperow
public interface IMapResultSetToEntity<TEntity> {
	public TEntity map(ResultSet rs) throws SQLException;
}
