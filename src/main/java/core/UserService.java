package core;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateful
public class UserService implements RemoteService
{
	List<User> users;
	PasswordGenerator generator;
	public UserService()
	{
		users = new ArrayList<User>();
		generator = new TimeBasedGenerator();	
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
