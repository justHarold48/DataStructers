
public class Key 
{
	private int identifier;
	private String color;
	
	public Key(int identifier, String color) 
	{
		this.identifier = identifier;
		this.color = color;
	}
	
	public void setIdentifier(int identifier)
	{
		this.identifier = identifier;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public int getIdentifier()
	{
		return identifier;
	}
	
	public String getColor()
	{
		return color;
	}
        
	@Override
	public String toString()
	{
		return " " + identifier + "(" + color + ")";
	}

}
