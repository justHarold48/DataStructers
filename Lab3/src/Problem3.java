import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 
{

	public static void main(String[] args) throws IOException 
	{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		String one;
		String two;
		boolean quit = false;
		
		while(!quit)
		{
			System.out.println("Type 0 to quit");
			System.out.println("Enter two strings to compare.");
			System.out.print("String one: ");
			one = keyboard.readLine();
			System.out.print(one);
			System.out.println();
			if(one.equals("0"))
			{
				quit = true;
				System.out.println();
				System.out.println("Your session has ended");
			}
			else
			{
				System.out.print("String two: ");
				two = keyboard.readLine();
				System.out.print(two);
				System.out.println();
				System.out.println();
				System.out.println("The result is: " + one.compareTo(two));	
				System.out.println();
			}
		}

	}

}
