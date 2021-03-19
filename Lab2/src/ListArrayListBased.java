import java.util.ArrayList;

public class ListArrayListBased implements ListInterface
{
	protected ArrayList<Object> items;  // an array of list items
	
	public ListArrayListBased()
	{
		items = new ArrayList<Object>();
	}

	@Override
	public boolean isEmpty() 
	{	
		return items.isEmpty();
	}

	@Override
	public int size() 
	{		
		return items.size();
	}

	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException 
	{
		items.add(index,item);
	}

	@Override
	public Object get(int index) throws ListIndexOutOfBoundsException 
	{
		return items.get(index);
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException 
	{
		items.remove(index);
	}

	@Override
	public void removeAll() 
	{
		items.removeAll(items);
	}
	

}
