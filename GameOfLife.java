
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameOfLife
{
	public static void main (String [] args) 
	{
		final int M = 25;
		final int N = 75;
		
		char[][] oldGeneration = new char[M+2][N+2]; // total 27 and 77 created considering the edge cells 
		char[][] newGeneration = new char[M+2][N+2]; 
		
		int generationNumber = 0;
		
		Scanner consoleReader = new Scanner(System.in);
		
		System.out.print ("Which file do you want to open?");
		String filename = consoleReader.next();
		
		File file = new File(filename);
		Scanner fileReader = null;

		try 
		{ 
		   fileReader = new Scanner (file);
		}
		catch (FileNotFoundException e) 
		{
		   System.out.print("file " + file + " does not exist");
		   System.exit(0);
		}
	
		for (int i = 1; i <= M; i++) 
		{
			String line = fileReader.nextLine(); 
			
			for(int j = 1; j <= N; j++)
			{
				oldGeneration[i][j] = line.charAt(j-1); 
			}
  		}
		
		System.out.println("Generation #: " + generationNumber);
		printGeneration(oldGeneration);
		generationNumber++;
		
		while(true)
		{
			System.out.println();
			System.out.println("Press any key for the next genration or Press \"Q\" to terminate the program");
			
			String input = consoleReader.next();
			
			if(input.equals("Q"))
			{
				System.out.println("you just terminate the program");
				System.exit(0);
			}
			else // want to see the next generation
			{
				newGeneration = createNewGeneration(oldGeneration, newGeneration);

				if(isWorldEmpty(newGeneration) == true)
				{
					System.out.println("The program is terminated since the world is empty");
					System.exit(0);	
				}
				else if(Arrays.deepEquals(oldGeneration, newGeneration) == true)
				{
					System.out.println("The program is terminated since successive generations will not yield any changes to the current generation");
					System.exit(0);
				}
				else
				{
					System.out.println("Generation #: " + generationNumber);
					printGeneration(newGeneration);
					generationNumber++;
					
					oldGeneration = newGeneration; // now update the oldGeneration to the newGeneration and executing the looping
					newGeneration = new char[M+2][N+2]; // initializing newGeneration for the next loop
				}
			}	
		}
  	}

	public static int getNumberOfNeighbors(char[][] world, int i , int j)
	{
		int count = 0;
		
		if(world[i-1][j-1] == 'X')
		{
			count++;
		}
		if(world[i-1][j] == 'X')
		{
			count++;
		}
		if(world[i-1][j+1] == 'X')
		{
			count++;
		}
		if(world[i+1][j-1] == 'X')
		{
			count++;
		}
		if(world[i+1][j] == 'X')
		{
			count++;
		}
		if(world[i+1][j+1] == 'X')
		{
			count++;
		}
		if(world[i][j-1] == 'X')
		{
			count++;
		}
		if(world[i][j+1] == 'X')
		{
			count++;
		}
		return count;
	}
	
	public static boolean isWorldEmpty(char[][] world)
	{
		boolean isWorldEmpty = false;
		int count = 0;

		for(int i = 0 ; i < world.length; i++) 
		{
			for(int j = 0 ; j < world[i].length; j++)
			{
				if(world[i][j] == 'X')
				{
					count++;
				}
			}
		}
		
		if(count > 0)
		{
			isWorldEmpty = false;
		}
		else
		{
			isWorldEmpty = true;
		}
		return isWorldEmpty;
	}
	
	public static void printGeneration(char[][] world)
	{
		
		
		for(int i = 1 ; i < world.length-1; i++)
		{
			for(int j = 1 ; j < world[i].length-1; j++)
			{
				System.out.print(world[i][j]);
			}
			System.out.println();
		}
	}
	
	public static char[][] createNewGeneration(char[][] oldGeneration, char[][] newGeneration)
	{

		for(int i = 1; i < oldGeneration.length - 1; i++)
		{	
			for(int j = 1; j < oldGeneration[i].length - 1; j++)
			{

				if(oldGeneration[i][j] == 'X')
				{
					if(getNumberOfNeighbors(oldGeneration,i , j) == 2 || getNumberOfNeighbors(oldGeneration, i , j) == 3)
					{
						newGeneration[i][j] = oldGeneration[i][j];
					}
					else 
					{
						newGeneration[i][j] = '.';
					}
				}
				
				else if(oldGeneration[i][j] == '.')
				{
					if(getNumberOfNeighbors(oldGeneration, i , j) == 3)
					{
						newGeneration[i][j] = 'X';
					}
					else
					{
						newGeneration[i][j] = '.';
					}
				}
			}
		}
		return newGeneration;
	} 
}
	

