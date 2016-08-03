import java.util.Random;
import java.util.Scanner;

public class Lesson_three
{
	public static final char CROSS = 'x'; 
	public static final char ZERO = 'o'; 	
	public static final char EMPTY = '_'; 
	public static int EqvilStepArr[] = new int[10];
	
	public static void main(String[] args)
	{
		char map[][] = new char[3][3];
		
		initMap(map);
		
		System.out.print("Ruls: You  need input number from 1 to 9 - that will be your move\n");
		drawMap(map);
		
		System.out.print("Choise who first (1)-you, (2)-me:  ");
			
		int whofirst = StreamCheckInput(1, 2);
		boolean first = chengePlayer(whofirst);
						
		cleanMap(map);
				
		boolean game = true;
		int moveUser;
		int moveComp;
		
		moveUser = moveComp = 0;
	
		while (game)
		{ 
			if (first)
			{
				System.out.print("your move: ");
								
				if(chkDoubleMove(moveUser = StreamCheckInput(1, 9)))
				{
					System.out.print("Your move has already been, try again!\n");
					first = true;
				}
				else
					first = false;
				
				instalPos(map, moveUser, CROSS);
			} 
			else
			{
				System.out.print("i'm move: ");
								
					moveComp = compMoveBlock(map);
					if (moveComp == 0)
					{
						Random rand = new Random();
						moveComp = rand.nextInt(8)+1;
					}
					
					System.out.print(moveComp + "\n");
					
					if(chkDoubleMove(moveComp))
					{
						System.out.print("It move has already been, try again!\n");
						first = false;
					}
					else
					{
						first = true;
					}	
					
					instalPos(map, moveComp, ZERO);			
				}
			
			
			
			drawMap(map);
			
			int countStep = 0;
			if (chkWin(map, CROSS))
			{
				System.out.print("You Win!");
				break;
			} 
			else if(chkWin(map, ZERO))
			{
				System.out.print("Comp WIN!");
				break;
			}
			else if (EqvilStepArr[9] == 9)
			{
				System.out.print("Standoff!!!");
				break;
			} 


		};	
			
	}		
	
	
	

	public static int compMoveBlock(char[][]map)
	{
		for ( int m = 0; m < 3; ++m) 
		{
			if (map[m][0] == CROSS && map[m][1] == CROSS && map[m][2] == EMPTY) {	map[m][2] = ZERO; return pos(m, 2);	}
			if (map[m][0] == CROSS && map[m][2] == CROSS && map[m][1] == EMPTY) {	map[m][1] = ZERO; return pos(m, 1);	}
			if (map[m][1] == CROSS && map[m][2] == CROSS && map[m][0] == EMPTY) {	map[m][0] = ZERO; return pos(m, 0);	}
			
			if (map[0][m] == CROSS && map[1][m] == CROSS && map[2][m] == EMPTY) {	map[2][m] = ZERO; return pos(2, m);	}
			if (map[1][m] == CROSS && map[2][m] == CROSS && map[0][m] == EMPTY) {	map[0][m] = ZERO; return pos(0, m);	}
			if (map[0][m] == CROSS && map[2][m] == CROSS && map[1][m] == EMPTY) {	map[1][m] = ZERO; return pos(1, m);	}
		}
		return 0;
	}
	
	 
	public static int pos(int k, int c)
	{
		int countPos = 0; 
		for( int i = 0; i < k; ++i) 
		{
			for( int j = 0; j < c; ++j) 
				countPos++;
		}
		return countPos;
	}
	
	public static boolean chkDoubleMove(int step)
	{
		if(EqvilStepArr[step] != step)
		{
			EqvilStepArr[step] = step;
			return false;
		}
		return true;
	}

	public static boolean chkWin(char[][] map, char elem) 
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
		return true;
	return false;	
	}
	
	public static void instalPos(char[][]map, int place, char elem)
	{
		switch (place) 
		{
			case 1 : map[0][0] = (map[0][0] == EMPTY) ? elem: map[0][0]; break;
			case 2 : map[0][1] = (map[0][1] == EMPTY) ? elem: map[0][1]; break;
			case 3 : map[0][2] = (map[0][2] == EMPTY) ? elem: map[0][2]; break;
			
			case 4 : map[1][0] = (map[1][0] == EMPTY) ? elem: map[1][0]; break;
			case 5 : map[1][1] = (map[1][1] == EMPTY) ? elem: map[1][1]; break;
			case 6 : map[1][2] = (map[1][2] == EMPTY) ? elem: map[1][2]; break;
			
			case 7 : map[2][0] = (map[2][0] == EMPTY) ? elem: map[2][0]; break;
			case 8 : map[2][1] = (map[2][1] == EMPTY) ? elem: map[2][1]; break;
			case 9 : map[2][2] = (map[2][2] == EMPTY) ? elem: map[2][2]; break;
			
			default:
				break;
		}
	}
	
	public static boolean chengePlayer(int who)
	{
		if (who == 1 )
			System.out.print("Ok! you first\n");
		else
		{
			System.out.print("Ok! i'm first\n");
			return false;
		}
		return true;
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
	










  
  