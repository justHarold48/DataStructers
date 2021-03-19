public class Restroom 
{
	private int numStalls;
	private int avaliable;
	private int customers;
	private final Stack<Key> keys;
	private final Queue<Stall> stalls;
	
	public Restroom(int numStalls)
	{
		this.numStalls = numStalls;
		avaliable = numStalls;
		keys = new Stack<Key>();
		stalls = new Queue<Stall>();
		customers = 0;
	}
	
	public void setStalls(int numStalls)
	{
		this.numStalls = numStalls;
	}
	
	public void setKey(Key key)
	{
		keys.push(key);
	}
	
	public int getStalls()
	{
		return numStalls;
	}
	
	public int getStallsAvaliable()
	{
		return avaliable;
	}
	
	public int getTotalCustomers()
	{
		return customers;
	}
	
	public boolean isEmpty()
	{
		return (avaliable == numStalls);
	}
	
	public boolean isFull()
	{
		return (avaliable == 0);
	}
	
	public String getAvaliableKeys()
	{	
		return keys.toString();
	}
	
	public String getStallsInUse()
	{	
		return stalls.toString();
	}	
	
	public Stall useStall(String name)
	{
		Stall temp = new Stall(name, keys.pop());
		stalls.enqueue(temp);
		avaliable--;
		return temp;
	}
	
	public Stall freeStall()
	{
		keys.push(stalls.peek().getKey());
		avaliable++;
		customers++; 
		
		return stalls.dequeue();
	}
}
