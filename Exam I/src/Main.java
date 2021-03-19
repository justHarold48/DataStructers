import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Simulate public restroom
 * Status: Complete and thoroughly tested
 * Last update: 11/21/18
 * Submitted:  03/17/17
 * @author: Harold Hatch
 * @version: 2017.01.23
 */
public class Main
{
  static BufferedReader keyboard;

  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");
    keyboard =new BufferedReader(new FileReader(file));
    //keyboard = new BufferedReader(new InputStreamReader(System.in));
    Menu menu = new Menu();
    boolean exit = false;

    System.out.println("Welcome to OneKlicLabs's Public Restroom!");
    System.out.print("Please enter number of stalls in the Restroom: ");
    int stalls = Integer.parseInt(keyboard.readLine().trim());
    System.out.println(stalls);
    Restroom restroom = new Restroom(stalls);

    int x = 0;

    while(x < stalls)
    {
      System.out.print("Enter identifier for key number: ");
      int identifier = Integer.parseInt(keyboard.readLine().trim());
      System.out.println(identifier);
        System.out.print("Enter key color: ");
      String color = keyboard.readLine().trim();
      System.out.println(color);
      Key key = new Key(identifier, color);
      restroom.setKey(key);
      x++;
    }

    System.out.println(menu.getMenu());

    Queue<String> queue = new Queue<String>();

    do
    {
      try
      {
        System.out.print("You know the Opitions. Make your menu Selection now: ");
        int request = Integer.parseInt(keyboard.readLine().trim());
        System.out.print(request); System.out.println();
        System.out.println();

        switch(request)
        {
          case 0:
            System.out.println("Your session has ended");
            exit = true;
            break;

          case 1:
            System.out.print("	Welcome to Harold's Restroom, your name please: ");
            String name = keyboard.readLine().trim();
            queue.enqueue(name);
            System.out.print(name);System.out.println();
            System.out.println("	\"" + name + "\" is now waiting");
            break;

          case 2:
            if(queue.isEmpty())
            {
              System.out.println("No customers waiting");
            }
            else if(!restroom.isFull())
            {
              Stall stall = restroom.useStall(queue.dequeue());
              System.out.println(stall.getName() + " is now using stall " +stall.getKey().getIdentifier() );//+ "(" + stall.getKey().getColor() + ")");
            }else
            {
              System.out.println("No stalls Avaliable");
            }
            break;

          case 3:
            if(restroom.isEmpty())
              System.out.println("All stalls are empty");
            else
              System.out.println(restroom.freeStall().getName() + " has left stall");
            break;

          case 4:
            if (queue.isEmpty())
              System.out.println("No customers waiting");
            else
              System.out.println("The following customers are waiting: " + queue.toString());
            break;

          case 5:
            if (restroom.isFull())
              System.out.println("No stalls left");
            else
              System.out.println(restroom.getAvaliableKeys());
            break;

          case 6:
            if(restroom.isEmpty())
              System.out.println("Restroom is empty");
            else
              System.out.println(restroom.getStallsInUse());
            break;

          case 7:
            System.out.println(restroom.getTotalCustomers() + " customers have used the restroom");
            break;
          default:
            System.out.println("Selection Invalid");
            break;
        }
      }catch(Exception e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      System.out.println();
    }while(!exit);
  }

}
