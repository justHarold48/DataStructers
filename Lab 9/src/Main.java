import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//include analysis of improved insertion sort
public class Main 
{
	static BufferedReader keyboard;
	static int comparisons = 0;
	static int swaps = 0;
	
	public static void main(String[] args) throws IllegalArgumentException, IOException 
	{
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter number of integers: ");
		int size = Integer.parseInt(keyboard.readLine().trim());
		System.out.print(size);
		System.out.println();
		System.out.println();
		
		int [] unsorted = new int[size];
		
		
		for(int i = 0; i < size; i++)
		{
			System.out.print("Enter number: ");
			unsorted[i] = Integer.parseInt(keyboard.readLine().trim());
			System.out.print(unsorted[i]);
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("Your List: ");
		System.out.println(toString(unsorted));
		System.out.println();
		
		System.out.println("Bubble Sort: ");
		System.out.println(toString(bubbleSort(unsorted)));
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps " + swaps);
		System.out.println();
		
		comparisons = 0;
		swaps = 0;
		
		System.out.println("Improved Bubble Sort: ");
		System.out.println(toString(ibubbleSort(unsorted)));
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps " + swaps);
		System.out.println();
		
		comparisons = 0;
		swaps = 0;
		
		System.out.println("Selection Sort: ");
		System.out.println(toString(selectionSort(unsorted)));
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps " + swaps);
		System.out.println();
		
		comparisons = 0;
		swaps = 0;
		
		System.out.println("Improved Selection Sort: ");
		System.out.println(toString(iselectionSort(unsorted)));
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps " + swaps);
		System.out.println();
		
		comparisons = 0;
		swaps = 0;
		
		System.out.println("Insertion Sort: ");
		System.out.println(toString(insertionSort(unsorted)));
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps " + swaps);
		System.out.println();
		
		

	}
	
	static int []  bubbleSort(int [] list)
	{
		int [] result = new int[list.length];
		
		for(int i = 0;i < result.length;i++)
			result[i] = list[i];
		
		int temp;
		
		for(int i = 1; i < result.length; i++)
			for(int j = 0; j < (result.length-i); j++)
			{
				comparisons++;
				if(result[j] > result[j+1])
				{
					swaps++;
					//swap
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;				
				}		
			}
		return result;
	}
	
	static int []  ibubbleSort(int [] list)
	{
		int [] result = new int[list.length];
		
		for(int i = 0;i < result.length;i++)
			result[i] = list[i];
		
		int temp;
		int swap;
		
		for(int i = 1; i < result.length; i++)
		{
			swap = 0;
			for(int j = 0; j < (result.length-i); j++)
			{
				comparisons++;
				if(result[j] > result[j+1])
				{
					swaps++;
					//swap
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;	
					swap++;
				}		
			}
			
			if (swap == 0)
				i = result.length;
		}
		return result;
	}
	
	static int [] selectionSort(int [] list)
	{
		int [] result = new int[list.length];
		for(int i = 0; i < result.length; i++)
			result[i] = list[i];
		
		int smallest;
		int temp;
		for(int i = 0; i < result.length; i++)
		{
			smallest = i;
			for(int j = i+1; j < result.length; j++)
			{
				comparisons++;
				if (result[smallest] > result[j])
					smallest = j;
			}	
			//swap
			if (result[i] > result[smallest])
			{
				swaps++;
				temp = result[i];
				result[i] = result[smallest];
				result[smallest] = temp;	
			}	
		}
		return result;
	}
	
	static int [] iselectionSort(int [] list)
	{
		int [] result = new int[list.length];
		for(int i = 0; i < result.length; i++)
			result[i] = list[i];
		
		int smallest;
		int temp;
		int j;
		
		for(int i = 0; i < result.length; i++)
		{
			
			boolean inorder = true;

			smallest = i;
			
			for(j = i+1; j < result.length; j++)
			{
				comparisons++;
				if (result[smallest] > result[j])
					smallest = j;

				if(result[j] < result[j-1] )
					inorder = false;
			}	
			
			if(inorder)
				i = result.length;
			else if (result[i] > result[smallest])
			{
				swaps++;
				temp = result[i];
				result[i] = result[smallest];
				result[smallest] = temp;
				//after swap is made assume list is now inorder
				inorder = true;
			}
		}
		return result;
	}
	
	static int [] insertionSort(int [] list)
	{
		int [] result = new int[list.length];	
		for(int i = 0;i < result.length;i++)
			result[i] = list[i];
		
		int key;
		int counter;
		
	    for (int i = 1; i < result.length; i++)
	    {
	    	key = result[i];
	    	counter = i-1;
	        while (counter >= 0 && result[counter] > key )
	        {
	        	comparisons++;
	        	result[counter+1] = result[counter];
	            counter--;
	        }
	        if (result[counter+1] != key)
	        {
	        	swaps++;
	        	result[counter+1] = key;
	        } 
	    }
		return result;
	}
	
	static String toString(int [] list)
	{
		String result = "";
		for(int i = 0; i< list.length;i++)
			result += list[i] + " ";
		return result;
	}
	
}

