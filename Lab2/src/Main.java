import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main 
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
				String item;

				
				switch(request)
				{
					case 7: 
						System.out.println("Your session has ended");
						Main.exit = true;
						break;	
					case 1: 			
						System.out.println("You are now adding a new item to your List ");
						System.out.print("	Enter item: ");
						item = Main.keyboard.readLine();
						System.out.print(item);
						System.out.println();
						item.trim();
						
						System.out.print("	Enter position to insert item in: ");
						position = Integer.parseInt(Main.keyboard.readLine());
						System.out.print(position);
						System.out.println();
						
						items.add(position, item);
						
						System.out.println("Item "+ item + " inserted in position "+ position +" in the list.");		
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
							position = Integer.parseInt(Main.keyboard.readLine());
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
							position = Integer.parseInt(Main.keyboard.readLine());
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
							items.removeAll();				
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
					case 6:
						if( items.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							items.reverseList();				
							System.out.println("List reversed");
						}
						break;
				}
			}catch(Exception e)
			{
				System.out.println();
				System.out.println("Index out of Bounds Try Again");
			}
			
			System.out.println();
	
		}while(!exit);
	}

}
