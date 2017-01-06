package dao;

import java.util.List;

import domain.Person;

//unterface dla Person repozytorium

public interface IPersonRepository extends IRepository<Person> {

	public List<Person> withName(String name);
}
