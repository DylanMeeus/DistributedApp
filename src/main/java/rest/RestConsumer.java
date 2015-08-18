package rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





@Named
@ApplicationScoped
public class RestConsumer
{
	
	String APIKEY = "6481E70F-3710-2746-AACA-C6C20F397A4B6325C7BD-EE2E-4EC0-9FE6-483179A46C49";
	String url = "https://api.guildwars2.com/v2/account?access_token="+APIKEY;
	public RestConsumer()
	{
		getAccountData();
	}
	
	// Let's consume some GuildWars2 data.
	
	public String getAccountData()
	{
		List<String> data = new ArrayList<String>();
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();
		response.getStatusInfo().getReasonPhrase();
		client.close();
		return response.readEntity(String.class);
	}
}
