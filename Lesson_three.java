
import java.util.Scanner;

public class Lesson_three
{
	public static void main(String[] args)
	{
		char map[][] = new char[3][3];
		
		initMap(map);
		
		System.out.print("Ruls: You  need input number from 1 to 9 - that will be your move\n");
		drawMap(map);
		
		System.out.print("Choise who first (1)-you, (2)-me:  ");
			
		int whofirst = 0;
		while (whofirst == 0 && (whofirst !=1 || whofirst !=2) )
		{ 
			whofirst = changeWhoFirst();
						
			if (whofirst == 0 && (whofirst !=1 || whofirst !=2))
				System.out.print("\nYou need make choice who move first 1(you) or 2(me):");
			else
				break;
		};
		
		if (whofirst == 1 )
		{
		  System.out.print("Ok! you first");
		} 
		else
		{
			System.out.print("Ok! i'm first");
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	public static void drawMap(char[][] map)
	{
		drawline();
		for ( int i = 0; i < 3; ++i) 
		{
			System.out.print("| ");			
			for ( int j = 0; j < 3; ++j) 
			{
				System.out.print(map[i][j] + " | ");
			}
			System.out.print("\n");
		}
		drawline();
	}
	
	public static void drawline()
	{
		System.out.print(" -------------\n");
	}
	
	
	public static void initMap(char[][] map)
	{
		int a = 1;
		
		for ( int i = 0; i < 3; ++i) 
		{
			for ( int j = 0; j < 3; ++j) 
				map[i][j] = Integer.toString(a++).charAt(0);
		}
	}
	
	public static int changeWhoFirst()
	{
		int Whofirst = 0;
		Scanner in = new Scanner(System.in);
		
		if(in.hasNextInt())
		{
			Whofirst = in.nextInt();
			return Whofirst;
		}
		return Whofirst;
	}
}
	
  
  