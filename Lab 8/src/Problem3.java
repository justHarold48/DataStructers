import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem3 
{

	static BufferedReader keyboard;
	static boolean exit = false;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		Menu menu = new Menu();
		menu.setMenu("Select from the following menu:\n"
				+ "	1. Insert item to list.\n"
				+ "	2. Remove item from list.\n"
				+ "	3. Search for item in list. \n"
				+ "	4. Clear list.\n"
				+ "	5. Print size and content of list.\n"
				+ "	6. Exit.\n"
				+ "Make your selection now: ");
		
		AscendinglyOrderedStringList items = new AscendinglyOrderedStringList();
		
		do
		{
			System.out.print(menu.getMenu());
			
			try
			{
				int request = Integer.parseInt(keyboard.readLine());
				System.out.print(request);
				System.out.println();
				System.out.println();
				
				switch(request)
				{
					case 6: 
						System.out.println("Your session has ended");
						Problem3.exit = true;
						break;	
					case 1: 			
						System.out.println("You are now adding a new item to your List ");
						System.out.print("	Enter item: ");
						String item = keyboard.readLine().trim();
						System.out.print(item);
						System.out.println();
						
						items.add(item);						
						break;	
					case 2: 
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.println("You are now deleting a task from your TaskList.");
							System.out.print("	Enter postion to remove item from: ");
							int position = Integer.parseInt(keyboard.readLine());
							System.out.print(position);
							System.out.println();
							
			
							String tempItem = items.get(position).toString();
							items.remove(position);
							System.out.println("Item " + tempItem + " has been removed from position " + position + " in the list.");
						}
						break;
					case 3:
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.print("Enter key to be searched: ");
							String key = keyboard.readLine().trim();
							System.out.print(key);
							System.out.println();
							
							System.out.print("Item " + key + " found at position: " + items.search(key));
	
							System.out.println();
						}
						break;
					case 4: 
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							items.clear();				
							System.out.println("All items have been removed");
						}		
						break;	
					case 5: 
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.println("List of size " + items.size() + " have the folllowing items: " + items.toString());
						}
						break;
				}
			}catch(Exception e)
			{
				System.out.println();
				System.out.println("Error: " + e.getMessage());
			}
			
			System.out.println();
	
		}while(!exit);
	}

}
