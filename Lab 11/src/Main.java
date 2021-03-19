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
		
		MyBinarySearchTreePlus<Data, String> mbstp = new MyBinarySearchTreePlus<Data, String>();
		
		do
		{
			System.out.print(menu.getMenu());
			
			try
			{
				int request = Integer.parseInt(keyboard.readLine());
				System.out.print(request);
				System.out.println();
				System.out.println();
				
				String item;
				
				switch(request)
				{
					case 1:
						System.out.println("You are now inserting an item into the list.");
						System.out.print("	Enter item: ");
						item = keyboard.readLine().trim();
						System.out.print(item);
						System.out.println();
						
						Data data = new Data(item);
						mbstp.insert(data);
						
						System.out.println("Item " + item + " has been inserted in the Tree");
						break;
					case 2:
						if( mbstp.isEmpty())
						{
							System.out.println("You have no items in your tree.");
						}
						else
						{
							System.out.print("	Enter item to remove from tree: ");
							item = keyboard.readLine().trim();
							System.out.print(item);
							System.out.println();
							
							mbstp.delete(item);
							
							System.out.println();
							System.out.println("Item " + item + " has been removed from the list.");
						}
						break;
					case 3:
						if( mbstp.isEmpty())
						{
							System.out.println("You have no items in your tree.");
						}
						else
						{
							System.out.print("	Enter item to search: ");
							item = keyboard.readLine();
							System.out.print(item);
							System.out.println();
							KeyedItem<String> it = mbstp.retrieve(item);
							if(it == null )
								System.out.println("Item not in tree");
							else
							{
								item = it.getKey();
								System.out.println("Item " + item + " found in tree");
							}
						}
						break;
					case 4:
						if(mbstp.isEmpty())
							System.out.println("No Tree No Height");
						else
							System.out.println("Height of tree is: " + mbstp.getHeight());
						break;
					case 5:
						if( mbstp.isEmpty())
							System.out.println("You have no items in your tree.");
						else
							System.out.println("List of size "+ mbstp.getSize());
						break;
					case 6:
						if( mbstp.isEmpty())
							System.out.println("You have no items in your tree.");
						else
							System.out.println("List of size "+ mbstp.getSize()+ " has the following items: " + mbstp.toStringInorder());
						break;
					case 7:
						if( mbstp.isEmpty())
							System.out.println("You have no items in your tree.");
						else
							System.out.println("List of size "+ mbstp.getSize()+ " has the following items: " + mbstp.toStringPreorder());
						break;
					case 8:
						if( mbstp.isEmpty())
							System.out.println("You have no items in your tree.");
						else
							System.out.println("List of size "+ mbstp.getSize()+ " has the following items: " + mbstp.toStringPostorder());
						break;
					case 9:
						System.out.println("Testing your Copy tree On: ");
						System.out.println("New Input data:  6 7 8 ");
						MyBinarySearchTreePlus<Data, String> mbstp2 = mbstp.getCopyOfTree();
						int x = 6;
						
						while(x<9)
						{
							mbstp2.insert(new Data(Integer.toString(x)));
							x++;
						}
						
						mbstp2.delete(Integer.toString(4));
						
						System.out.println("New Output data: " + mbstp2.toStringInorder());
						System.out.println("Old Output data: " + mbstp.toStringInorder());

						
						break;
					case 10:
						System.out.println("Your session has ended");
						exit = true;
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
