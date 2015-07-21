package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("user_api")
public class ApplicationConfig extends Application
{
	
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> resources = new HashSet<>();
		resources.add(RestUser.class);
		return resources;
	}
}
