/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/6/17
 * Submitted:  02/7/17
 * Comment: test suite and sample run attached
 * @author: Harold Hatch
 * @version: 2017.01.23
 */

public class MyListReferenceBased<T> implements ListInterface<T>
{
	private Node head;
	
	/**
	 * Constructor
	 */
	public MyListReferenceBased()
	{
		head = null;
	}
	
	/**
	 * adds a node to the list
	 */
	public void add(int index, T item) throws ListIndexOutOfBoundsException
	{
		if(validIndex(index))
		{
			if(index == 0)
			{
				head = new Node(item, head.getNext());
			}
			else
			{
				Node prevNode = search(index-1);
				Node temp = new Node(item, prevNode.getNext());
				prevNode.setNext(temp);		
			}
			
		}
		else
			 throw new ListIndexOutOfBoundsException( "ListIndexOutOfBoundsException on get");
		
	}
	
	/**
	 * @param index the index of the node
	 * removes a node from the list
	 */
	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if(validIndex(index))
		{
			if(index == 0)
				head = head.getNext();
			else
			{
				Node prevNode = search(index-1);
				prevNode.setNext(prevNode.getNext().getNext());
			}
			
		}
		else
			 throw new ListIndexOutOfBoundsException( "ListIndexOutOfBoundsException on get");
	}
	
	/**
	 * @return the object inside the node
	 */
	public Object get(int index) throws ListIndexOutOfBoundsException
	{
		Object result;
		
		if(validIndex(index))
			result = search(index).getItem();
		else
			 throw new ListIndexOutOfBoundsException( "ListIndexOutOfBoundsException on get");
		
		return result;
	}
	
	/**
	 * @return the size of the list
	 */
	@Override
	public int size()
	{
		int size = 0;
		Node current = head;
		
		while(current != null)
		{
			current = current.getNext();
			size++;
		}
		
		return size;		
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(size() == 0)
			return true;
		
		return false;
	}

	public void removeAll() 
	{
		head = null;
	}
	
	/**
	 * @return a reference to a searched node
	 */
	private Node search(int index)
	{
		Node current = head;

		for(int i = 0; i < index; i++)
			current = current.getNext();
		
		return current;
	}
	
	/**
	 * validates the index
	 */
	private boolean validIndex(int index)
	{
		return (index >= 0 && index < size()+1);		
	}
	
	public String toString()
	{
		String stringItems = "";
		
		Node current = head;
		
		while(current != null)
		{
			stringItems += (current.getItem() + " ");
			current = current.getNext();
		}
		
		return stringItems;
	}
}
