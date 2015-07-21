package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named
@SessionScoped
//@Stateless
public class UserService implements RemoteService, Serializable
{
	@Resource(name="mail/distributed")
	private javax.mail.Session session;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	
	@Inject
	private PasswordGenerator generator;
	
	
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
		
		String to = "meeusdylan@hotmail.com";
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Testje voor u.");
			String messageText = "Created new user in the DA application!";
			message.setText(messageText);
			Transport.send(message);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void deleteUser(String username)
	{
		// Just delete all users with that username. 
		List<User> temp = new ArrayList<User>();
		// Enable this labmda in case we are allowed to put it on JRE8
		// users.removeIf(u -> u.getUsername().equals(username));
		for(User u : users)
		{
			if(!u.getUsername().equals(username))
			{
				temp.add(u);
			}
		}
		users = temp;
	}


	@Override
	public void changePassword(String username, String newpass)
	{
		for(User u : users)
		{
			if(u.getUsername().equals(username))
			{
				u.setPassword(newpass);
			}
		}
	}
}
