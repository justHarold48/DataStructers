package Lab6;
/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/21/17
 * Submitted:  02/23/17
 * Comment: test suite and sample run attached
 * @author: Harold Hatch
 * @version: 2017.01.23
 */
public class Stack<T> implements StackInterface<T>
{
	private T [] stack;
	private int top;
	
	@SuppressWarnings("unchecked")
	public Stack()
	{
		stack = (T[]) new Object[3];
		top = -1;
	}

	@Override
	public boolean isEmpty() 
	{
		return (top == -1);	
	}

	@Override
	@SuppressWarnings("unchecked")
	public void popAll() 
	{
		stack = (T[]) new Object[3];
        top = -1;
	}

	@Override
	public void push(T newItem) 
	{	
		if(top == stack.length-1)
			resize();
		top++;
		stack[top] = newItem;
	}

	@Override
	public T pop() throws StackException 
	{
		if(isEmpty())
			throw new StackException("StackException List Empty");
		else
		{
			T result = stack[top];
			stack[top] = null;
			top--;
			return result;
		}
	}

	@Override
	public T peek() throws StackException 
	{
		if(isEmpty())
			throw new StackException("StackException Out of bounds");
			
		return stack[top];
	}
	
	/**
	 * when array is full this method resizes 
	 * the array
	 */
	private void resize()
	{
		@SuppressWarnings("unchecked")
		T [] biggerItems = (T[]) new Object[2*stack.length];
		
		for(int i = 0; i < stack.length;i++)
		{
			biggerItems[i] = stack[i];
		}
		
		stack = biggerItems;
	}
	
	public String toString()
	{
		String stringItems = "";

		for(int i = 0;i <= top;i++)
		{
			stringItems += (stack[i] + " ");
		}
		
		return stringItems;

	}

}
