public class Menu 
{	
	private String menu;
	
	public Menu()
	{
		menu = "Select from the following menu:\n"
				+ "	1. Insert item to list.\n"
				+ "	2. Remove item from list.\n"
				+ "	3. Get item from list.\n"
				+ "	4. Clear list.\n"
				+ "	5. Print size and content of list.\n"
				+ "	6. Delete largest item in the list.\n"
				+ "	7. Reverse list.\n"
				+ "	8. Exit.\n"
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
