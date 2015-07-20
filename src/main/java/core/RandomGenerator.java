package core;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.inject.Alternative;


@Alternative
public class RandomGenerator implements PasswordGenerator, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3426377272672327831L;

	@Override
	public String generatePassword()
	{
		String password = "";
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		for(int i = 0; i < 10; i++)
		{
			password+=alphabet.charAt(rand.nextInt(alphabet.length()));
		}
		return password;
	}

}
