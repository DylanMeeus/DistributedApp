package backingbeans;

import java.io.Serializable;
import java.util.List;





import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.naming.InitialContext;

import core.RemoteService;
import core.User;


@Named
@RequestScoped
public class OverviewBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4198654399375945623L;

	List<User> userList;
	
	@Inject
	@Singleton
	private RemoteService userService;
	
	public OverviewBean()
	{
		// Use JNDI to get the freakin' data!

	}
	
	public List<User> getUserList()
	{
		/*
		try
		{
			InitialContext context = new InitialContext();
			String JNDILookup = "java:global/distributed-app/UserService!core.RemoteService";
			userService = (RemoteService) context.lookup(JNDILookup);
			userList = userService.getUsers();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		*/
		
		
		userList = userService.getUsers();
		return userList;
	}
	
}
