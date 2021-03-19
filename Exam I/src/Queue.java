
public class Queue<T> implements QueueInterface<T>
{
	protected T [] queue;
	protected int size;
	protected int front;
	protected int back;
	
	@SuppressWarnings("unchecked")
	public Queue()
	{
		queue = (T[]) new Object[3];
		size = 0;
		front = 0;
		back = queue.length-1;
	}

	@Override
	public boolean isEmpty() 
	{
		return (size == 0);
	}

	@Override
	public void enqueue(T item) 
	{
		if(size == queue.length)
			resize();
		
		back = (back+1) % queue.length; //increment b
		queue[back] = item; //drop new item in index b  
		size++; //update items	
	}

	@Override
	public T dequeue() throws QueueException 
	{
		T result;
		
		if(isEmpty())
			throw new QueueException("Queue is empty");
		else
		{
			result = queue[front]; //save reference of index front
			queue[front] = null; //drop null at index front
			front = (front+1) % queue.length; //increment from in circular fashion
			size--; //update items
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dequeueAll() 
	{
		queue = (T[]) new Object[3];
		front = 0;
		back = queue.length;
		size = 0;
	}

	@Override
	public T peek() throws QueueException 
	{
		return queue[front];
	}
	
	/**
	 * when array is full this method resizes 
	 * the array
	 */
	protected void resize()
	{
		@SuppressWarnings("unchecked")
		T [] biggerItems = (T[]) new Object[2*queue.length];

		int t = 0;
		
		if (front > back)
		{
			for(int i = front; i < queue.length;i++,t++)
			{
				biggerItems[t] = queue[i];
			}
			for(int i = 0;i <= back;i++,t++)
			{
				biggerItems[t] = queue[i];
			}
		}
		else
			for(int i = front;i <= back;i++,t++)
			{
				biggerItems[t] = queue[i];
			}
		
		queue = biggerItems;
		front = 0;
		back = t-1;
	}
	
	public String toString()
	{
		String stringItems = "";

		if (front > back)
		{
			for(int i = front;i < queue.length;i++)
				stringItems += (queue[i] + " ");
			
			for(int i = 0;i <= back;i++)
				stringItems += (queue[i] + " ");
		}
		else
			for(int i = front;i <= back;i++)
				stringItems += (queue[i] + " ");		
		
		return stringItems;
	}
}
