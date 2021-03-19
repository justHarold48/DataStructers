import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{

	static BufferedReader keyboard;
	static int counterCalls = 0;
	static int counterDiskMoves = 0;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Integer Factorial ");
		System.out.print("Enter a number: ");
		int num = Integer.parseInt(keyboard.readLine());
		System.out.println();
		System.out.println("New answer is: " + intFactorial(num));
		System.out.println();
		
		System.out.println("Long Factorial ");
		System.out.print("Enter a number: ");
		long num1 = Long.parseLong(keyboard.readLine());
		System.out.println();
		longFactorial(num1);
		System.out.println();
		
		System.out.println("BigInteger Factorial");
		System.out.print("Enter a number: ");
		BigInteger num2 = BigInteger.valueOf(Long.parseLong(keyboard.readLine()));
		System.out.println();
		bigIntFactorial(num2);
		System.out.println();

		System.out.println("Towers of Hanoi");
		System.out.print("Enter number of disks: ");
		int num3 = Integer.parseInt(keyboard.readLine());
		System.out.println();
		solve(num3,"Inital","Temp","Destination");
		System.out.println();
		
		System.out.println("Find the Coeffient");
		System.out.print("Enter first number: ");
		int n = Integer.parseInt(keyboard.readLine());
		System.out.println();
		System.out.print("Enter secound number: ");
		int k = Integer.parseInt(keyboard.readLine());
		System.out.println();
		System.out.println("Result is: " + coefficient(n,k));
		System.out.println();
		
		System.out.println("Pascals Tower");
		System.out.print("Enter number of rows: ");
		int rows = Integer.parseInt(keyboard.readLine());
		System.out.println();
		pascalsTriangle(rows+1);
		System.out.println();
		
		System.out.println("Find the Coeffient Second way");
		System.out.println("Result is: " +coefficient2(n+1,k+1));
		System.out.println();
		
		System.out.println("Find the Coeffient Third way");
		System.out.println("Result is: " + coefficient3(n,k));
		System.out.println();
		
		
	}
	
	static int intFactorial(int n)
	{
	    if(n == 0 || n == 1)
	      return 1;
	    
	    return (intFactorial(n-1) * n);
	}
	
	static long longFactorial(long n)
	{
	    if(n == 0 || n == 1)
	      return 1;

	    return (longFactorial(n-1) * n);
	}
	
	static BigInteger bigIntFactorial(BigInteger n)
	{
	    if(n.intValue() == 0 || n.intValue() == 1)
	      return BigInteger.valueOf(1);
	    
	    return n.multiply(bigIntFactorial(n.subtract(BigInteger.valueOf(1))));
	}
	
	static void solve(int n, String i, String t, String d)
	{
		counterCalls++;
		
		if(n > 0)
		{
			solve(n-1, i, d, t);
			counterDiskMoves++;
			System.out.println("Plan (Move disk: " + n + " from " + i + " to " + d + ") , Number of Calls( " + counterCalls + " ) , Number of Disk Moves( " + counterDiskMoves + " )");
			solve(n-1, t, i, d );
		}
	}
	
	static int coefficient(int n, int k)
	{
		int result;
		
		if (k == 0 || k == n)
			return 1;
		
		result = (coefficient(n-1,k-1) + coefficient(n-1,k));
		
		return result;
	}
	
	static int coefficient2(int n,int k)
	{
		int result = 0;
		int length = 2;
		int [] oldrow = new int[1];
		int [] newrow = new int[length];
		newrow[0] = 1;
		newrow[1] = 0;
		oldrow[0] = 1;
		
		for (int i = 1; i <= n; i++)
		{
			for(int t = 0; t < oldrow.length; t++)
			{
				if ((t+1) <= (oldrow.length-1))
					newrow[t+1] = oldrow[t] + oldrow[t+1];
				result = newrow[t];
			}
			
			if(length < k)
				length++;
			
			oldrow = newrow;
			newrow = new int[length];
			newrow[0] = 1;
		}
		
		return result;
	}
	
	
	static void pascalsTriangle(int n)
	{
		int [] oldrow = new int[1];
		int [] newrow = new int[2];
		newrow[0] = 1;
		newrow[1] = 0;
		oldrow[0] = 1;
		
		for (int i = 1; i <= n; i++)
		{
			
			for(int t = 0; t < oldrow.length; t++)
			{
				if ((t+1) <= (oldrow.length-1))
					newrow[t+1] = oldrow[t] + oldrow[t+1];
				System.out.print(newrow[t]+" ");
			}
			
			System.out.println();
			oldrow = newrow;
			newrow = new int[oldrow.length+1];
			newrow[0] = 1;
		}		
	}
	static int coefficient3(int n, int k)
	{
		if (k > (n-k))
			return ffp(n,k)/fact(n-k);
		else
			return ffp(n,n-k)/fact(k);
	}
	
	static int ffp(int n, int k)
	{
		int result = n;
		int num = n;
		
		while(num > k+1)
		{
			result = result * (num - 1);
			num--;
		}
		
		return result;	
	}
	
	static int fact(int n)
	{
	    if(n == 0 || n==1)
	      return 1;
	    
	    return (fact(n-1) * n);
	}
}
