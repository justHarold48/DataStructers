import Lab6.*;
/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/21/17
 * Submitted:  02/23/17
 * Comment: test suite and sample run attached
 * @author: Harold Hatch
 * @version: 2017.01.23
 */
public class Bag
{
	private Stack<Layer> layer;
	private Stack<Double> smplWeights;
	private int layers;
	private int smplLayers;
	private double weight;
	private double smplWeight;
	
	public Bag()
	{
		layers = 0;
		weight = 0;
		layer = new Stack<Layer>();
		smplWeights = new Stack<Double>();
	}
	
	public void addLayer(int items, double weight)
	{
		layers++;
		this.weight += weight;
		layer.push(new Layer(items,weight));
	}
	public void addSample(double weight)
	{
		smplLayers++;
		smplWeight += weight;
		smplWeights.push(weight);
	}
	
	public Layer removeLayer()
	{
		Layer result = layer.pop();
		this.weight -= result.getWeight();
		layers--;
		return result;
	}
	public double removeSample()
	{
		double result;
		result = smplWeights.pop();
		smplWeight -= result;
		return result;
	}
	
	public void removeAll()
	{
		layers = 0;
		weight = 0;
		layer = new Stack<Layer>();
	}
	
	public void removeAllSamples()
	{
		smplLayers = 0;
		smplWeight = 0;
		smplWeights = new Stack<Double>();
	}
	
	public int getLayers()
	{
		return layers;
	}
	
	public int getSmplLayers()
	{
		return smplLayers;
	}
	
	public double getWeight()
	{
		return weight;
	}

	public double getSmplWeight()
	{
		return smplWeight;
	}
}
