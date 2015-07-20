package core;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateless
public class UserService implements RemoteService
{
	List<User> users;
	PasswordGenerator generator;
	public UserService()
	{
		users = new ArrayList<User>();
		generator = new TimeBasedGenerator();	
		User testUser = new User();
		testUser.setUsername("TestUser");
		testUser.setPassword(generator.generatePassword());
		users.add(testUser);
	}
	

	public List<User> getUsers()
	{
		return users;
	}
	
	// Gets username + generates password
	public void createUser(String username)
	{
		User u = new User();
		u.setUsername(username);
		u.setPassword(generator.generatePassword());
		users.add(u);
	}
}
