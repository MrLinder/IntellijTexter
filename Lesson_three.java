
import java.util.Scanner;

public class Lesson_three
{
	public static final char CROSS = 'x'; 
	public static final char ZERO = 'o'; 	
	public static final char EMPTY = (char)32; 

	public static void main(String[] args)
	{
		char map[][] = new char[3][3];
		
		initMap(map);
		
		System.out.print("Ruls: You  need input number from 1 to 9 - that will be your move\n");
		drawMap(map);
		
		System.out.print("Choise who first (1)-you, (2)-me:  ");
			
		int whofirst = StreamCheckInput(1, 2);
		
		boolean first = true;
		if (whofirst == 1 )
		{
			System.out.print("Ok! you first\n");
		} 
		else
		{
			System.out.print("Ok! i'm first\n");
			first = false;
		}
				
		cleanMap(map);
				
		boolean game = true;
		int moveUser;
		int moveComp;
		
		moveUser = moveComp =0;
	
		while (game)
		{ 
			if (first)
			{
				System.out.print("your move: ");
				moveUser = StreamCheckInput(1, 9);
				
				instalPos(map, moveUser, CROSS);
				
				first = false;
								
			} 
			else
			{
				System.out.print("i'm move: ");
				moveUser = StreamCheckInput(1, 9);
								
;				instalPos(map, moveUser, ZERO);
				
				first = true;
			}

			
			chkWin(map, CROSS);
			
			drawMap(map);
		};
		
		
		
		
		
		
		
		
	
		
	}
	
	public static void chkWin(char[][] map, char elem) 
	{
		if(
			(map[0][0] == elem && map[1][0] == elem && map[2][0] == elem) || 
			(map[0][1] == elem && map[1][1] == elem && map[2][1] == elem) ||		
			(map[0][2] == elem && map[1][2] == elem && map[2][2] == elem) ||
			
			(map[0][0] == elem && map[0][1] == elem && map[0][2] == elem) || 
			(map[1][0] == elem && map[1][1] == elem && map[1][2] == elem) ||		
			(map[2][0] == elem && map[2][1] == elem && map[2][2] == elem) ||
			
			(map[0][0] == elem && map[1][1] == elem && map[2][2] == elem) || 
			(map[2][0] == elem && map[1][1] == elem && map[0][2] == elem) 		
		  )
		{
			System.out.print("CROSS COMPLIT!");
		}	
			
		
		
		
	}
	
	
	public static void instalPos(char[][]map, int place, char elem)
	{
		switch (place) 
		{
			case 1 : map[0][0] = elem;	break;
			case 2 : map[0][1] = elem;	break;
			case 3 : map[0][2] = elem;	break;
			
			case 4 : map[1][0] = elem;	break;
			case 5 : map[1][1] = elem;	break;
			case 6 : map[1][2] = elem;	break;
			
			case 7 : map[2][0] = elem;	break;
			case 8 : map[2][1] = elem;	break;
			case 9 : map[2][2] = elem;	break;
			
			default:
				break;
		}
	}
	
	public static void cleanMap(char map[][])
	{
		for ( int i = 0; i < 3; ++i) 
		{
			for ( int j = 0; j < 3; ++j) 
					map[i][j] = EMPTY;
		}
	}

	public static void drawMap(char[][] map)
	{
		drawline();
		for ( int i = 0; i < 3; ++i) 
		{
			System.out.print("| ");			
			for ( int j = 0; j < 3; ++j) 
				System.out.print(map[i][j] + " | ");
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
	
	public static int getInputNumber()
	{
		Scanner in = new Scanner(System.in);
		
		if(in.hasNextInt())
		{
			return in.nextInt();
		}
		return 0;
	}
	
	public static int StreamCheckInput(int a, int b)
	{
		int results = 0;
		while ( results == 0 || (results < a || results > b))
		{ 
			results = getInputNumber();
						
			if (results == 0 || (results < a || results > b))
				System.out.print("\nYou need input number from " + a + " to " + b + ": ");
			else
				break;
		};
		return results;
	}
	
}
	






/*int results = 0;
		*/















  
  