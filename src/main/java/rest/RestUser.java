package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import core.RemoteService;
import core.User;


@Path("/userservice")
public class RestUser
{

	@Inject
	private RemoteService userService;
	
	@Context
	private UriInfo context;
	
	public RestUser()
	{
		
	}
	
	/*
	@GET
	@Produces("text/html")
	public String getHtml()
	{
		return "<html><body><h1>Hello World</h1></body></html>";
	}
	*/
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getXmlUsers()
	{
		List<User> users = userService.getUsers();
		return UsersToXml(users);
	}
	
	private String UsersToXml(List<User> users)
	{
		StringBuilder xmlDoc = new StringBuilder();
		xmlDoc.append("<users>\n");
		for(User u : users)
		{
			xmlDoc.append("<user>\n");
			xmlDoc.append("<username>\n");
			xmlDoc.append(u.getUsername()+"\n");
			xmlDoc.append("</username>\n");
			xmlDoc.append("<password>\n");
			xmlDoc.append(u.getPassword()+"\n");
			xmlDoc.append("</password>\n");
			xmlDoc.append("</user>\n");
		}
		xmlDoc.append("</users>\n");
		//return "<users><user><name>Dylan</name></user><user><name>Sybren</name></user></users>";
		return xmlDoc.toString();
	}
	
	
	/*
	 * Just need to pass a string - as it's only one parameter.
	 */
	@POST
	@Consumes("text/plain")
	public void createUser(String username)
	{
		userService.createUser(username);
	}
	
	@DELETE
	@Consumes("text/plain")
	public void deleteUser(String username)
	{
		
	}
	
}
