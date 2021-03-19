import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 
{

	static BufferedReader keyboard;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		Menu menu = new Menu();
		boolean exit = false;
		
		Queue<Object> queue = new Queue<Object>();
		
		menu.setMenu("Select from the following menu:\n"
				+ "	1. Insert item at back of queue.\n"
				+ "	2. Remove item from front of queue.\n"
				+ "	3. Display content of queue.\n"
				+ "	5. Clear queue.\n"
				+ "	6. Exit.\n"
				+ "Make your selection now: ");
		
		do
		{
			try
			{
				System.out.print(menu.getMenu());
	
				int request = Integer.parseInt(keyboard.readLine().trim());
				System.out.print(request); System.out.println();
				System.out.println();
	
				switch(request)
				{
					case 1:
						
						System.out.print("	Enqueue item: ");
						Object item = keyboard.readLine().trim();
						System.out.print(item);System.out.println();
						
						queue.enqueue(item);
						System.out.println("	\"" + item + "\" enqueued ");
						
						break;
					case 2:	
						System.out.println("	\"" + queue.dequeue() + "\" dequeued ");
						break;
					case 3:
						System.out.println("	\"" + queue.peek() + "\" is at front of queue");
						break;
					case 4:
						if(queue.isEmpty())
							System.out.println("	No items in queue");
						else
						{
							System.out.println("	Items in queue: ");
							System.out.println("		" + queue.toString());
						}
						break;
					case 5:
						queue.dequeueAll();
						System.out.println("	Items cleared from queue");
						break;
					case 6:
						exit = true;
						System.out.println("Your session has ended");
						break;
				}
			}catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println();
		}while(!exit);
	}

}
