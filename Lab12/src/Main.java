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
		boolean exit = false;
		
		Menu menu = new Menu();
		menu.setMenu("Select from the following menu:\n"
				+ "	1. Insert a symbol key with an associated value in the table.\n"
				+ "	2. Delete a symbol from the table\n"
				+ "	3. Retrieve and display the value associated with a symbol key in the table. \n"
				+ "	4. Display the hash index of a symbol key.\n"
				+ "	5. Exit.\n"
				+ "Make your selection now: ");
		
		HashTable<String, Integer> symbolTable = new HashTable<String, Integer>();
		String key;
		
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
					case 5: 
						System.out.println("Your session has ended");
						exit = true;
						break;	
					case 1: 			
						System.out.println("You are now adding a new (Symbol,Value) to your Table: ");
						System.out.print("	Enter symbol: ");
						key = keyboard.readLine().trim();
						System.out.println(key);
						System.out.print("	Enter value: ");
						int value = Integer.parseInt(keyboard.readLine().trim());
						System.out.println(value);
						
						symbolTable.tableInsert(key, value);					
						break;	
					case 2: 
						if(symbolTable.tableIsEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.println("You are now deleting a task from your Table.");
							System.out.print("	Enter symbol to remove from table: ");
							key = keyboard.readLine();
							System.out.print(key);
							System.out.println();
							
			
							if(symbolTable.tableDelete(key))
								System.out.println("Symbol " + key + " has been removed from table.");
							else
								System.out.println("Symbol " + key + " is not in table.");
						}
						break;
					case 3:
						if(symbolTable.tableIsEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.print("Enter Symbol to be retrived: ");
							key = keyboard.readLine().trim();
							System.out.print(key);
							System.out.println();
							
							System.out.print("Value " + symbolTable.tableRetrieve(key) + " found with symbol: " + key);
	
							System.out.println();
						}
						break;
					case 4: 
						if( symbolTable.tableIsEmpty())
						{
							System.out.println("You have no items in your list.");
						}
						else
						{
							System.out.print("Enter Symbol to be displayed: ");
							key = keyboard.readLine().trim();
							System.out.print(key);
							System.out.println();
							
							System.out.print("Symbol " + key + " has hash index: " + symbolTable.hashIndex(key));
							System.out.println();
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
