package core;

import java.io.Serializable;


// This needs to be serializable because it can be send through the 'remoteService' via internet etc.

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username,password;
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
