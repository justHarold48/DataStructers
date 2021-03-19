import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 
{

	static BufferedReader keyboard;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		Menu menu = new Menu();
		boolean exit = false;
		
		DEQ<Object> queue = new DEQ<Object>();
		
		menu.setMenu("Select from the following menu:\n"
				+ "	1. Insert item at back of Deq.\n"
				+ "	2. Insert item at front of Deq. \n"
				+ "	3. Remove item from front of Deq.\n"
				+ "	4. Remove item from back of Deq.\n"
				+ "	5. Display front item of Deq.\n"
				+ "	6. Display last item of Deq.\n"
				+ "	7. Display content of Deq.\n"
				+ "	8. Clear Deq.\n"
				+ "	9. Exit.\n"
				+ "Make your selection now: ");
		
		do
		{
			try
			{
				System.out.print(menu.getMenu());
	
				int request = Integer.parseInt(keyboard.readLine().trim());
				System.out.print(request); System.out.println();
				System.out.println();
				
				Object item;
				
				switch(request)
				{
					case 1:
						
						System.out.print("	Enqueue item at back: ");
						item = keyboard.readLine().trim();
						System.out.print(item);System.out.println();
						
						queue.enqueue(item);
						System.out.println("	\"" + item + "\" enqueued ");
						
						break;
					case 2:

						System.out.print("	Enqueue item at front: ");
						item = keyboard.readLine().trim();
						System.out.print(item);System.out.println();
						
						queue.enqueueFirst(item);
						System.out.println("	\"" + item + "\" enqueued ");
						break;
					case 3:	
						System.out.println("	\"" + queue.dequeue() + "\" first item dequeued ");
						break;
					case 4:
						System.out.println("	\"" + queue.dequeueLast() + "\" last item dequeued ");
						break;
					case 5:
						System.out.println("	\"" + queue.peek() + "\" is at front of queue");
						break;
					case 6:
						System.out.println("	\"" + queue.peek() + "\" is at back of queue");
						break;
					case 7:
						if(queue.isEmpty())
							System.out.println("	No items in queue");
						else
						{
							System.out.println("	Items in queue: ");
							System.out.println("		" + queue.toString());
						}
						break;
					case 8:
						queue.dequeueAll();
						System.out.println("	Items cleared from queue");
						break;
					
					case 9:
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
