package core;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// This needs to be serializable because it can be send through the 'remoteService' via internet etc.

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Username can not be null!")
	private String username;

	@Size(min=8,message="Password must be at least 8 characters long")
	private String password;
	
	public User()
	{
		
	}
	
	public void setUsername(String name)
	{
		username = name;
	}
	
	public void setPassword(String pw)
	{
		password = pw;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}

}
