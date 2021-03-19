
public class Stall 
{
	private String name;
	private Key key;

	public Stall(String name, Key key) 
	{
		this.name = name;
		this.key = key;
	}

	public String getName()
	{
		return name;
	}
	
	public Key getKey()
	{
		return key;
	}
	
	public String toString()
	{
		return name + " is using stall " + key.toString() ;
	}
}
