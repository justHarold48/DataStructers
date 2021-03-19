public class Menu 
{	
	private String menu;
	
	public Menu()
	{
		menu = "Select from the following menu:\n"
				+ "	1. Place a layer of item(s) in the bag.\n"
				+ "	2. Remove a layer of item(s) from the bag.\n"
				+ "	3. Display the weight of the bag.\n"
				+ "	4. Display the number of layers in the bag.\n"
				+ "	5. Display the number of items and the weight of the sample bag.\n"
				+ "	6. Remove an item from the sample bag.\n"
				+ "	7. Empty the sample bag.\n"
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
