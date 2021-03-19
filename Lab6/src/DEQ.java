
public class DEQ<T> extends Queue<T> implements ExtendedQueueInterface<T>
{

	@Override
	public void enqueueFirst(T newItem) throws ExtendedQueueException 
	{
		if(queue.length == size)
			resize();
		;
		front = ((front-1) + queue.length) % queue.length;
		queue[front] = newItem;
	}

	@Override
	public T dequeueLast() throws ExtendedQueueException 
	{
		T temp;
		
		if(isEmpty())
			throw new ExtendedQueueException("Queue is Empty");
		else
		{
			temp  = queue[back];
			queue[back] = null; 
			back = ((back-1) + queue.length) % queue.length;
		}
		
		return temp;
	}

	@Override
	public T peekLast() throws ExtendedQueueException 
	{
		return queue[back];
	}

}
