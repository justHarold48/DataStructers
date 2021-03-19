public class Menu 
{	
	private String menu;
	
	public Menu()
	{
		menu = "Select from the following menu:\n"
				+ "	1. Insert key in BST\n"
				+ "	2. Delete key from BST\n"
				+ "	3. Search for key in BST\n"
				+ "	4. Display height of BST\n"
				+ "	5. Display size of BST\n"
				+ "	6. Display content of BST in inorder\n"
				+ "	7. Display content of BST in preorder\n"
				+ "	8. Display content of BST in postorder\n"
				+ "	9. Build copy of the tree, and test it\n"
				+ "	10. Exit program\n"
				+ "Make your selection now: ";
	}

	public void setMenu(String menu)
	{
		this.menu = menu;
	}
	
	
	public String getMenu()
	{
		return menu;
	}
}