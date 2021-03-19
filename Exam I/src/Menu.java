public class Menu 
{	
	private String menu;
	
	public Menu()
	{
		menu = "Select from the following menu:\n"
				+ "	0. Exit.\n"
				+ "	1. Customer enters restroom.\n"
				+ "	2. Customer uses a stall.\n"
				+ "	3. Customer finishes using the stall and leaves.\n"
				+ "	4. Display customers waiting to enter a stall.\n"
				+ "	5. Display the avaliable stalls.\n"
				+ "	6. Display customers using stalls and the stall they are using.\n"
				+ "	7. Display the number of customers that have left the restroom.\n"
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
