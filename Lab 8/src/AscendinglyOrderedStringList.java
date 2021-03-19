
public class AscendinglyOrderedStringList extends ListArrayBasedPlus implements AscendinglyOrderedStringListInterface
{

	@Override
	public void add(String item) throws ListIndexOutOfBoundsException 
	{
		super.add(search(item), item);	
	}

	@Override
	public String get(int index) throws ListIndexOutOfBoundsException 
	{
		return (String) super.get(index);
	}

	@Override
	public int search(String key)
	{
		Object midKey = 0;
		int midNum = 0;
		int range = numItems;
		int high = numItems-1;
		int low = 0;
		
		if(isEmpty())
		{
			return 0;
		}                   
		else
			while(range != 0)
			{
				midNum = (high + low)/2;
				midKey = items[midNum];
		
				if ( key.equals(midKey))
					return midNum;
				else if(Integer.parseInt(key) < Integer.parseInt((String) midKey))
				{
					high = midNum - 1;
					range = range/2;
				}
				else
				{
					low = midNum + 1;
					range = range/2;
					if((Integer.parseInt(key) > Integer.parseInt((String) midKey)) && range == 0)
						return midNum + 1;
				}
			}
		return midNum;
	}
	
	public boolean itemInList(Object item)
	{
		for(int i = 0;i < items.length;i++)
				if(items[i].equals(item))
					return true;
		
		return false;
	}
	
	@Override
	public void clear()
	{
		super.removeAll();
	}
}
