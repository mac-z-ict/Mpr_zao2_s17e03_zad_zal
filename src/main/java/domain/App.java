package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

import dao.IRepositoryCatalog;
import dao.PersonRepository;
import dao.AddressRepository;
import dao.RepositoryCatalog;
import dao.mappers.PersonMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

public class App 
{
	private static final String connectionString = "jdbc:hsqldb:hsql://localhost/workdb";
    public static void main( String[] args )
    {
    	try {
			Connection connection = DriverManager.getConnection(connectionString);
			
			IRepositoryCatalog catalogOf = new RepositoryCatalog(connection);

			Person janek = new Person();
			janek.setName("janek");
			janek.setSurname("kowalski");
			janek.setAge(30);
			
			
			//przykladowe operacje na userze
			
			User u = new User();
			u.setLogin("Adam");
			u.setPassword("ABC");
			u.setRoles(null);
			catalogOf.users().add(u);
			
			User u1 = new User();
			u1.setLogin("Robert");
			u1.setPassword("+++");
			u1.setRoles(null);
			
			catalogOf.users().add(u1);
			
			
			catalogOf.people().add(janek);
			
			
			
			
			// breakpointy dla mnie - sprawdzenie w tabeli
			//catalogOf.saveAndClose();
			
			
			
			u1.setId(2);
			u1.setLogin("Wanda");
			u1.setPassword("---");
			u1.setRoles(null);
			
			
			catalogOf.users().update(u1);
			
			//catalogOf.saveAndClose();
			User u2 = new User();
			u2.setId(2);
			catalogOf.users().delete(u2);
			
			
			//catalogOf.saveAndClose();
			System.out.println(catalogOf.users().getAll());
			
			
			catalogOf.saveAndClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "koniec!" );
    }
}
