package core;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RemoteService
{
	public void createUser(String username);
	public List<User> getUsers();
}
