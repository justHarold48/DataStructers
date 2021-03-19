/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/13/17
 * Submitted:  02/14/17
 * Comment: test suite and sample run attached
 * @author: Harold Hatch
 * @version: 2017.01.23
 */
public class ListCDLSBased<T> implements ListInterface<T>
{
	private NodeD head;
	private int size;
	
	public ListCDLSBased()
	{
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() 
	{
		if(size == 0)
			return true;
		
		return false;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public void add(int index, T item) throws ListIndexOutOfBoundsException 
	{
		if(isValidAddIndex(index))
		{
			if(index == 0)
			{
				if(isEmpty())
				{
					head = new NodeD(item);
				}
				else
				{
					head = new NodeD(item, head , head.getPrevious());
					head.getNext().setPrevious(head);
					head.getPrevious().setNext(head);
				}
				
			}
			else
			{
				NodeD prevNode = search(index-1);
				NodeD temp = new NodeD(item, prevNode.getNext(),prevNode);
				prevNode.getNext().setPrevious(temp);
				prevNode.setNext(temp);
			}
			size++;
		}
		else
			 throw new ListIndexOutOfBoundsException( "ListIndexOutOfBoundsException on get");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws ListIndexOutOfBoundsException 
	{
		T result;
		
		if(isValidGetIndex(index))
			result = (T) search(index).getItem();
		else
			 throw new ListIndexOutOfBoundsException( "ListIndexOutOfBoundsException on get");
		
		return result;
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException 
	{
		if(isValidGetIndex(index))
		{
			if(index == 0 && size == 1)
				head = null;
			else if(index == 0)
			{
				NodeD temp = head;
				head = head.getNext();
				head.setPrevious(temp.getPrevious());
				head.getPrevious().setNext(head);
			}
			else
			{
				NodeD prevNode = search(index-1);
				prevNode.setNext(prevNode.getNext().getNext());
				prevNode.getNext().setPrevious(prevNode);
			}
			size--;
		}
		else
			 throw new ListIndexOutOfBoundsException( "ListIndexOutOfBoundsException on get");
		
	}

	@Override
	public void removeAll() 
	{
		head = null;
		size = 0;
	}
	

	/**
	 * @return a reference to a searched node
	 */
	private NodeD search(int index)
	{
		NodeD current = head;
		int middle = Math.floorDiv(size, 2);

		if (index >= middle )
			for(int i = size; i > index; i--)
				current = current.getPrevious();
		else
			for(int i = 0; i < index; i++)
				current = current.getNext();
		
		return current;
	}
	
	/**
	 * validates the index
	 */
	private boolean isValidAddIndex(int index)
	{	
		if(index >= 0 && index < size+1)
			return true;
		else
			return false;		
	}
	
	/**
	 * validates the index
	 */
	private boolean isValidGetIndex(int index)
	{	
		if(index >= 0 && index < size)
			return true;
		else
			return false;		
	}

	
	public String toString()
	{	
		String items = "";
		
		NodeD current = head;
		
		int counter = 0;
		
		while(counter < size)
		{
			items += (current.getItem() + " ");
			current = current.getNext();
			counter++;
		}
		
		return items;
		
	}

}
