package core;

import java.util.List;

import javax.ejb.Remote;
import javax.enterprise.inject.Default;

@Default
@Remote
public interface RemoteService
{
	public void createUser(String username);
	public List<User> getUsers();
}
