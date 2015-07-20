package core;

import java.io.Serializable;

import javax.enterprise.inject.Default;


@Default
public class TimeBasedGenerator implements PasswordGenerator, Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8884165477684738070L;

	public String generatePassword()
	{
		return Long.toString(System.currentTimeMillis());
	}
}
