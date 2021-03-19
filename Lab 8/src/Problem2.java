import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 
{

	static BufferedReader keyboard;
	static boolean exit = false;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		Menu menu = new Menu();
		
		ListArrayBasedPlus items = new ListArrayBasedPlus();
		
		do
		{
			System.out.print(menu.getMenu());
			
			try
			{
				int request = Integer.parseInt(keyboard.readLine());
				System.out.print(request);
				System.out.println();
				System.out.println();
				
				int position;
				int key;

				
				switch(request)
				{
					case 7: 
						System.out.println("Your session has ended");
						Problem2.exit = true;
						break;	
					case 1: 			
						System.out.println("You are now adding a new item to your List ");
						System.out.print("	Enter item: ");
						key = Integer.parseInt(keyboard.readLine().trim());
						System.out.print(key);
						System.out.println();
						
						if( items.isEmpty())
						{
							items.add(0, key);
							System.out.print("Item " + key + " inserted at position: " + 0);
						}else
						{
							String result = selectionSearch(items, key);
							StringTokenizer st = new StringTokenizer(result, " ");
							String token = st.nextToken();
							
							if(token.equals("S"))
							{
								position = Integer.parseInt(st.nextToken());
								items.add(position, key);
								System.out.println("Item " + key + " inserted at position: " + position);
							}
							else
							{
								int index = items.size()-1;
								items.add(index , key);
								System.out.println("Item " + key + " inserted at position: " + index);
							}
						}
						
						System.out.println();
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
							position = Integer.parseInt(keyboard.readLine());
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
							System.out.println("You are now getting a item from your TaskList. ");
							System.out.print("Enter the position of the item in list ");
							position = Integer.parseInt(keyboard.readLine());
							System.out.print(position);
							System.out.println();
							
							System.out.println("Item " + items.get(position).toString() + " retrived from position " + position + " in the list." );
						}
						break;
					case 4:
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.print("Enter key to be searched: ");
							key = Integer.parseInt(keyboard.readLine().trim());
							System.out.print(key);
							System.out.println();
							
							String result = selectionSearch(items, key);
							StringTokenizer st = new StringTokenizer(result, " ");
							String token = st.nextToken();
							
							if(token.equals("S"))
							{
								position = Integer.parseInt(st.nextToken());
								System.out.println("Item " + key + " found at position: " + position);
							}
							else
								System.out.println("Item " + key + " is not in this list");

						}
						break;
					case 5: 
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							items.removeAll();				
							System.out.println("All items have been removed");
						}		
						break;	
					case 6: 
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
	
	static String selectionSearch(ListArrayBasedPlus list, int key)
	{
		int currKey = 0;
		
		for(int i = 0;i < list.size();i++)
		{
			currKey = Integer.parseInt((String) list.get(i));
			if(key > currKey)
			{
				//advance
			}
			else if (key == currKey)//stop, return position, return S for successful
				return ("S " + currKey);
			else//stop
				i = list.size();
		}
		//return U for unsuccesful
		return ("U " + currKey);
	}
	

}
