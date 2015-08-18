package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import rest.RestConsumer;

@Named
@RequestScoped
public class GuildWarsBean
{
	
	private String name = "Insanity";
	private String id = "";
	private String world = "";
	RestConsumer restConsumer = new RestConsumer();
	
	public GuildWarsBean()
	{
		getData();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getWorld()
	{
		return world;
	}
	
	public void setWorld(String world)
	{
		this.world = world;
	}
	
	private void getData()
	{
		String JSONString = restConsumer.getAccountData();
		JSONObject obj = (JSONObject) JSONValue.parse(JSONString);
		//JSONArray array = (JSONArray)obj;
		name = obj.get("name").toString();
		id = obj.get("id").toString();
		world = obj.get("world").toString();
	}
	
	
}
