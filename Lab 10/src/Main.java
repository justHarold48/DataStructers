import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
	static BufferedReader keyboard;
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		MergeSort merge = new MergeSort();
		QuickSort quick = new QuickSort();
		
		System.out.print("Enter number of integers: ");
		int size = Integer.parseInt(keyboard.readLine().trim());
		System.out.print(size);
		System.out.println();
		System.out.println();
		
		int [] nums = new int[size];
		
		
		for(int i = 0; i < size; i++)
		{
			System.out.print("Enter number: ");
			nums[i] = Integer.parseInt(keyboard.readLine().trim());
			System.out.print(nums[i]);
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("Your List: ");
		System.out.println(toString(nums));
		System.out.println();
		
		merge.setList(nums);
		merge.sort();
		System.out.println(merge);
		
		System.out.println();
		
		quick.setList(nums);
		quick.sort();
		System.out.println(quick);
		
	}
	
	static String toString(int [] list)
	{
		String result = "";
		for(int i = 0; i< list.length;i++)
			result += list[i] + " ";
		return result;
	}

}
