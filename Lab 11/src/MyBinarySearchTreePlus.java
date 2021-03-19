
public class MyBinarySearchTreePlus<T extends KeyedItem<KT>,KT extends Comparable<? super KT>> extends MyBinarySearchTree<T, KT> implements BSTPInterface<T, KT>
{

	@Override
	public int getHeight() 
	{
		return height(root);
	}
	
	public int height(TreeNode<T> tnode)
	{	
		if (tnode == null) 
			return -1;
		return 1 + Math.max(height(tnode.getLeftChild()), height(tnode.getRightChild()));
	}

	@Override
	public int getSize() 
	{
		return size(root);	
	}
	
	protected int size(TreeNode<T> tnode)
	{
		if(tnode == null)
			return 0;
		
		return(size(tnode.getLeftChild()) + 1 + size(tnode.getRightChild()));
	}


	@Override
	public String toStringPreorder() 
	{
		return stringPreorder(root);
	}
	
	protected String stringPreorder(TreeNode<T> node)
    {
        if (node == null)
        	return "";
        
        return (node.getItem() + " " + stringPreorder(node.getLeftChild()) + stringPreorder(node.getRightChild()));
    }
	
	@Override
	public String toStringInorder() 
	{
		return stringInorder(root);
	}
	
	protected String stringInorder(TreeNode<T> node)
    {
		if (node == null)
			return "";
		
		return  ( stringInorder(node.getLeftChild()) + node.getItem() + " "+ stringInorder(node.getRightChild()));
    }

	@Override
	public String toStringPostorder() 
	{
		return stringPostorder(root);
	}
	
	public String stringPostorder(TreeNode<T> node)
    {
		if (node != null)
			return ""; 
        
		return  ( stringPostorder(node.getLeftChild()) + stringPostorder(node.getRightChild()) + node.getItem() + " ");
    }

	@Override
	public MyBinarySearchTreePlus<T,KT> getCopyOfTree() 
	{
		MyBinarySearchTreePlus<T,KT> copy = new MyBinarySearchTreePlus<T,KT>();
		copy.root = new TreeNode<T>(root.getItem());
		copy.root = copyTree(root);
	
		return copy;
	}
	
	protected TreeNode<T> copyTree(TreeNode<T> tnode)
	{
		if (tnode == null) 
            return null;
  
        TreeNode<T> copy = new TreeNode<T>(tnode.getItem());
        copy.setLeftChild(copyTree(tnode.getLeftChild()));
        copy.setRightChild(copyTree(tnode.getRightChild()));
        return copy;
	}
	

	@Override
	public void setRootItem(T newItem) 
	{
		root.setItem(newItem);
		
	}

}
