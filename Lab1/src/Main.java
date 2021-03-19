import java.io.*;
import java.util.*;

public class Main 
{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		
		ArrayList<Double> numbers = new ArrayList<Double>();
		ArrayList<Double> weights = new ArrayList<Double>();
		double numSum = 0;
		double weightSum = 0;
		double numMean = 0;
		double weightMean = 0;
		
		System.out.print("Enter number of pairs: ");
		int numOfPairs = Integer.parseInt(input.readLine());
		
		int x = 1;
		
		if(numOfPairs >1)
		{
			do
			{
				System.out.print("Enter number " + x + " : " );
				numbers.add(Double.parseDouble(input.readLine()));
				
				System.out.print("Enter weight " + x + " : ");
				weights.add(Double.parseDouble(input.readLine()));
				
				x++;
			}while(x <= numOfPairs);	
		}
		else
		{
			System.out.println("Wrong restart the program and try again");
		}

		
		for(int i = 0; i < numOfPairs; i++)
		{
			numSum += numbers.get(i);
			weightSum += (weights.get(i) * numbers.get(i));
	 	}
		
		numMean = numSum/numOfPairs;
		weightMean = weightSum/numOfPairs;
		
		System.out.println();
		System.out.println("Weighted arithmetic mean of these 5 pairs is:" +  weightMean);
		System.out.println("Simple arithmetic mean of these 5 pairs is:" +  numMean);
	}

}
