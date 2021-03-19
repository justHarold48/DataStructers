import java.util.ArrayList;

public class ListArrayListBasedPlus extends ListArrayListBased
{
	public ListArrayListBasedPlus()
	{
		super();
	}
	
	public void reverseList()
	{
		ArrayList<Object> reverseItems = new ArrayList<Object>(items.size());
		
		for(int i = 1; i < items.size();i++)
		{
			reverseItems.add(items.get(items.size()-i));
		}
		
		items = reverseItems;
	}
	
	public String toString()
	{
		String stringItems = " ";

		if (items.isEmpty())
			return "No items in list";
		else
		{
			for(int i = 0;i<size();i++)
			{
				stringItems += (items.get(i) + " ");
			}
			
			return stringItems;
		}
	}

}
