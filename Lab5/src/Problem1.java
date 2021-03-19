import java.io.BufferedReader;
import Lab6.*;
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
		
		Stack<Object> stack = new Stack<Object>();
		
		menu.setMenu("Select from the following menu:\n"
				+ "	1. Push item onto stack.\n"
				+ "	2. Pop item from stack.\n"
				+ "	3. Display top item from stack.\n"
				+ "	4. Display items in stack.\n"
				+ "	5. Clear stack.\n"
				+ "	6. Quit.\n"
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
						
						System.out.print("	Push item onto stack: ");
						Object item = keyboard.readLine().trim();
						System.out.print(item);System.out.println();
						
						stack.push(item);
						System.out.println("	\"" + item + "\" pushed onto stack ");
						
						break;
					case 2:	
						System.out.println("	\"" + stack.pop() + "\" popped from stack");
						break;
					case 3:
						System.out.println("	\"" + stack.peek() + "\" is on top of stack");
						break;
					case 4:
						if(stack.isEmpty())
							System.out.println("	No items in stack");
						else
						{
							System.out.println("	Items in stack: ");
							System.out.println("		" + stack.toString());
						}
						break;
					case 5:
						stack.popAll();
						System.out.println("	Items cleared from stack");
						break;
					case 6:
						exit = true;
						System.out.println("Your session has ended");
						break;
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println();
		}while(!exit);
	}

}
