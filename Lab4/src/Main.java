import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{

	static BufferedReader keyboard;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		Menu menu = new Menu();
		boolean exit = false;
		
		ListCDLSBased<Object> list = new ListCDLSBased<Object>();
		
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
					case 1:
						System.out.println("You are now inserting an item into the list.");
						System.out.print("	Enter item: ");
						item = keyboard.readLine();
						item = item.trim();
						System.out.print(item);
						System.out.println();
						System.out.print("	Enter position to insert item: ");
						position = Integer.parseInt(keyboard.readLine());
						System.out.print(position);
						System.out.println();
						
						list.add(position, item);
						System.out.println("Item " + item + " inserted in position " + position + " in the list.");
						break;
					case 2:
						if( list.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.print("	Enter position to remove item from: ");
							position = Integer.parseInt(keyboard.readLine());
							System.out.print(position);
							System.out.println();
							Object tempItem = list.get(position);
							list.remove(position);
							System.out.println();
							System.out.println("Item " + tempItem + " removed from " +position + " in the list.");
						}
						break;
					case 3:
						if( list.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.print("	Enter position to retrive item from: ");
							position = Integer.parseInt(keyboard.readLine());
							System.out.print(position);
							System.out.println();
							
							System.out.println("Item " + list.get(position) + " retrived from " +position + " in the list.");
						}
						break;
					case 4:
						list.removeAll();
						System.out.println("List has been cleared");
						break;
					case 5:
						if( list.isEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.println("List of size "+ list.size()+ " has the following items: " + list.toString());
						}
						break;
					
					case 6:
						exit = true;
						System.out.println("Your session has ended");
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
