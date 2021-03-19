import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{

	static BufferedReader keyboard;
	
	public static void main(String[] args) throws IOException 
	{	
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		Menu menu = new Menu();
		boolean exit = false;
		
		Bag bag = new Bag();
		
		do
		{
			try
			{
				System.out.print(menu.getMenu());
	
				int request = Integer.parseInt(keyboard.readLine().trim());
				System.out.print(request); System.out.println();
				System.out.println();
	
				switch(request)
				{
					case 1:
						System.out.println("You are now inserting items into the bag.");
						System.out.print("	Enter number of items to place in bag: ");
						int items = Integer.parseInt(keyboard.readLine().trim());
						System.out.print(items);System.out.println();
						System.out.print("	Enter weight of item (lb): ");
						double weight = Double.parseDouble(keyboard.readLine().trim());
						System.out.print(weight);System.out.println();
					
						bag.addLayer(items, (items*weight));
						System.out.println(items + " items weighing " + weight + " have been placed in the bag.");
						break;
					case 2:	
						Layer layer = bag.removeLayer();
						System.out.print(layer.getItems() + " items have been removed from the bag. ");
						System.out.println();
					
						System.out.print("Would you like to store a sample from this layer(Y/N)?");
						String response = keyboard.readLine().trim();
						System.out.print(response);System.out.println();
						
						if(response.equals("Y") || response.equals("y"))
						{
							bag.addSample(layer.getWeight()/layer.getItems());
							System.out.println("Sample stored");
						}else if(response.equals("N") || response.equals("n"))
						{
							System.out.println("No sample stored");
						}
						else
							System.out.println("Invaild response");	
						
						break;
					case 3:
						if( bag.getWeight() == 0)
							System.out.println("The bag is empty : Weight is 0 lbs.");
						else
							System.out.format("The weight of the bag is %.1flbs%n", bag.getWeight());
						break;
					case 4:
						if(bag.getLayers() == 0)
							System.out.println("The bag is empty: No layers. ");
						else
							System.out.println("The number of layers in the bag is " + bag.getLayers());
						break;
					case 5:
						if(bag.getSmplLayers() == 0)
							System.out.println("The Sample bag is empty: No items. ");
						else
						{
							System.out.println("The number of items in the sample bag is " + bag.getSmplLayers());
							System.out.format("The sample bag weighs %.1flbs%n",bag.getSmplWeight());
						}
						break;
					case 6:
						if(bag.getSmplLayers() == 0)
							System.out.println("The bag is empty: No items. ");
						else
						{
							
							System.out.println("One item removed weighing: " + bag.removeSample());
						}
						break;
					case 7:
						bag.removeAllSamples();
						System.out.println("Sample bag has been cleared");
						break;
					case 8:
						exit = true;
						System.out.println("Your session has ended");
						break;
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println();
		}while(!exit);
	}

}
