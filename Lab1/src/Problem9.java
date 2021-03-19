import java.util.ArrayList;

/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 9
 * Status: Complete and thoroughly tested
 * Last update: 01/21/17
 * Submitted:  01/23/17
 * Comment: test suite and sample run attached
 * @author: Harold Hatch
 * @version: 2017.01.23
 */
public class Problem9 
{
	private ArrayList<Character> data;
	
	public Problem9()
	{
		data = new ArrayList<Character>();
	}
	
	public void add(char c)
	{
		
		data.add(data.size(),c);
	}
	
	public void displayList()
	{
		System.out.println(data);
	}
	
	public void displayWhileLoop()
	{
		int x = 0;
		while(x < data.size())
			System.out.print(data.get(x));
	}
	
	public void displayForLoop()
	{
		for(int i = 0;i < data.size();i++)
			System.out.print(data.get(i));
	}
	
	public void displayIterator()
	{
		while(data.iterator().hasNext())
			System.out.print(data.iterator().next());
	}
	
	public void displayToString()
	{
		System.out.println(data.toString());
	}
	
	public void displayReverseForLoop()
	{
		for(int i = 0;i < data.size();i++)
			System.out.print(data.get(data.size()-i));
	}
	
	public void displayReverseWhileLoop()
	{
		int x = 0;
		while(x < data.size())
			System.out.print(data.get(data.size()-x));
	}
	
	public boolean testIfPalindromeForLoop()
	{
		int x = 1;
		boolean isPalindrome = false;
		
		for(int i = 0;i < data.size();i++)
		{
			if (data.get(data.size()-i).equals(data.get(i)))
				x++;
				
		}
		if(x == data.size())
			isPalindrome = true;
		
		return isPalindrome;		
	}
}
