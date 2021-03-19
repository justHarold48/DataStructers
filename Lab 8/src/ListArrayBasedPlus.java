
public class ListArrayBasedPlus extends ListArrayBased
{	
	public ListArrayBasedPlus()
	{
		super();
	}
	
	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException
	{
		if (isFull())
		{
			resize();
		}
		
		super.add(index, item);
	}
	
	public void resize()
	{
		
		Object [] biggerItems = new Object[2*items.length];
		
		for(int i = 0; i < items.length;i++)
		{
			biggerItems[i] = items[i];
		}
		
		items = biggerItems;
		
	}
	
	public void reverseList()
	{
		Object [] reverseItems = new Object[items.length];
		int t = 0;
		
		for(int i = 0; i < items.length;i++)
		{
			if (items[(items.length-1)-i] != null)
			{
				reverseItems[t] = items[(items.length-1)-i];
				t++;
			}
		}
		
		items = reverseItems;
	}
	
	private boolean isFull()
	{
		if (numItems == items.length)
			return true;
		
		return false;
	}
	
	public String toString()
	{
		String stringItems = " ";

		for(int i = 0;i<size();i++)
		{
			stringItems += (items[i] + " ");
		}
		
		return stringItems;

	}
	

}
