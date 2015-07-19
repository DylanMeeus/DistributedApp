package core;

public class TimeBasedGenerator implements PasswordGenerator
{
	public String generatePassword()
	{
		return Long.toString(System.currentTimeMillis());
	}
}
