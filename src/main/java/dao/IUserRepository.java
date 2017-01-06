package dao;

import domain.User;

//interface dla repozytorium userow

public interface IUserRepository extends IRepository<User> {
	public User withLogin(String login);
	public User withLoginAndPassword(String login, String password);
	public void setupPermissions(User user);
}
