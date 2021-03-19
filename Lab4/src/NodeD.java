public class NodeD 
{
  private Object item;
  private NodeD next;
  private NodeD prev;

  public NodeD(Object newItem) 
  {
    item = newItem;
    next = this;
    prev = this;
  } // end constructor

  public NodeD(Object newItem, NodeD nextNode) 
  {
    item = newItem;
    next = nextNode;
    prev = this;
  } // end constructor
  
  
  public NodeD(Object newItem, NodeD nextNode, NodeD prevNode) 
  {
    item = newItem;
    next = nextNode;
    prev = prevNode;
  } // end constructor

  public void setItem(Object newItem) 
  {
    item = newItem;
  } // end setItem

  public Object getItem() 
  {
    return item;
  } // end getItem

  public void setNext(NodeD nextNode) 
  {
    next = nextNode;
  } // end setNext

  public NodeD getNext() 
  {
    return next;
  } // end getNext
  
  public void setPrevious(NodeD prevNode) 
  {
    prev = prevNode;
  } // end setNext
  
  public NodeD getPrevious() 
  {
    return prev;
  } // end getNext
  
  public String toString()
  {
	  return item.toString();
  }
} // end class Node