/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/21/17
 * Submitted:  02/23/17
 * Comment: test suite and sample run attached
 * @author: Harold Hatch
 * @version: 2017.01.23
 */
public class Layer 
{
	private int num;
	private double weight;
	
	public Layer(int num, double weight)
	{
		this.num = num;
		this.weight = weight;
	}

	public void setItems(int num)
	{
		this.num = num;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public int getItems()
	{
		return num;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
}
