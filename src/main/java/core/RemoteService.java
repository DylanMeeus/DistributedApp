package core;

import java.util.List;

import javax.ejb.Remote;
import javax.enterprise.inject.Default;

@Default
@Remote
public interface RemoteService
{
	public void createUser(String username);
	public void deleteUser(String username);
	public void changePassword(String username, String newpass);
	public List<User> getUsers();
}
