public class Menu 
{	
	private String menu;
	
	public Menu()
	{
		menu = "Select from the following menu:\n"
				+ "	1. Insert item to list.\n"
				+ "	2. Remove item from list.\n"
				+ "	3. Get item from list.\n"
				+ "	4. Search for item in list. \n"
				+ "	5. Clear list.\n"
				+ "	6. Print size and content of list.\n"
				+ "	7. Exit.\n"
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
