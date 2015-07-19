package launcher;

import java.util.List;

import javax.naming.InitialContext;

import core.RemoteService;
import core.User;
import core.UserService;

public class Launcher
{

	public static void main(String[] args)
	{
		System.out.println("Starting service..");

		// Use JDNI to get the service.
		try
		{
			InitialContext context = new InitialContext();
			String jndiLookupString = "java:global/distributed-app/UserService!core.RemoteService";
			RemoteService remoteUserService = (RemoteService) context.lookup(jndiLookupString);
			remoteUserService.createUser("Dylan");
			for(User u : remoteUserService.getUsers())
			{
				System.out.println(u.getUsername() + " " + u.getPassword());
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
