package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.naming.InitialContext;

import core.RemoteService;



@Named
@RequestScoped
public class AddUserBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1537848923622293855L;
	private String userInput = "";
	
	@Inject
	@Singleton
	private RemoteService userService;
	
	public AddUserBean()
	{
		
	}
	
	public void setUserInput(String userInput)
	{
		this.userInput=userInput;
	}
	
	public String getUserInput()
	{
		return userInput;
	}
	
	public String create()
	{
		/*
		try
		{
			InitialContext context = new InitialContext();
			String JNDILookup = "java:global/distributed-app/UserService!core.RemoteService";
			RemoteService userService = (RemoteService) context.lookup(JNDILookup);
			userService.createUser(userInput);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		*/
		userService.createUser(userInput);
		return "overview.xhtml";
	}
}
