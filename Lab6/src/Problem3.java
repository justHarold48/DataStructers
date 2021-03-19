import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 
{

	static BufferedReader keyboard;
	
	public static void main(String[] args) throws IOException 
	{	
		File file = new File("problem3.txt");
		BufferedReader keyboard = new BufferedReader(new FileReader(file));
		//keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		boolean notComplete = true;
		
		DEQ<String> words = new DEQ<String>();
		
		while(notComplete)
		{
			System.out.print("Enter Character: ");
			words.enqueue(keyboard.readLine());
			System.out.println(words.peekLast());
			
			if( words.peekLast().equals("-"))
			{
				notComplete = false;
			}
			else if(words.peekLast().equals('.'))
			{
				notComplete = false;
			}
		}
		
		if(words.peekLast().equals("."))
			System.out.println(words.toString().replaceAll(" ", "") + "	no minus");
		else
		{
			notComplete = true;
			boolean leftLonger = false;
			
			
			while(notComplete)
			{
				System.out.print("Enter Character: ");
				words.enqueue(keyboard.readLine());
				System.out.println(words.peekLast());
				
				if(words.peekLast().equals("."))
				{
					notComplete = false;
				}
				
				if(leftLonger)
					System.out.println(words + "    Left Longer");
			
			/*if(rightLonger)
				System.out.println(words + "    Right Longer");
			else if(leftLonger)
				System.out.println(words + "    Left Longer");
			else if(sameLength && sameContent)
				System.out.println(words.toString().replaceAll(" ", "") + "    Same Length, Same Content, No palindrome");
			else if (sameLength)
				System.out.println(words + "    Same Length, Different Content, No palindrome");
			else if(isPalindrome)
				System.out.println(words + "    Same Length and Same Content, Palindrome");*/
			}
		}

		
	}

}
