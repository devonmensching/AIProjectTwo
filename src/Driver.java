import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Driver( ) - contains the driver program. The Driver opens and reads a file 
 * inputed by the user. Then runs a genetic algorithm on the file to find 
 * the best solution.
 * 
 * By Devon Mensching
 *
 */

public class Driver {
	
	private static int maxGeneration = 200;
	private static int populationSize = 2000;
	private static int mutationRate = 10;
	
	private static int numOfVariables;
	private static int[][] grid;
	private static java.util.Scanner input;
	
	
	public static void main( String args[] ) throws FileNotFoundException 
	{
		// Prompt the user to enter a file name
		System.out.println("Please enter a file name: ");
		input = new java.util.Scanner(System.in);	
		String fileName = input.nextLine();
		
		// Open the file and read in the information
		// If the file doens't exist, print error message 
		File file = openFile( fileName );
		ArrayList<Integer> gridNumbers = readFile( file );
		createGrid(gridNumbers);
		
		// Run a genetic algorithm
		runGeneticAlgorithm( );
		
		// Print the best set of variables found, and the  
		// value of the function with those variables 
		
		
	}

	// openFile( String fileName ) - opens a file 
	public static File openFile( String fileName ){
		File file = null;
		try
		{
			file = new File( fileName );
			if( !file.exists() )
			{
				System.out.println("This fine does not exist.");
				System.exit(0);
			}
		}
		catch( Exception e ){ }	
		
		return file;
	}
	
	// readFile( File file ) - read through the file and sets the 
	// numOfVariabes and collect integers for grid 
	public static ArrayList<Integer> readFile( File file ) throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
		
		// Sets the field numOfVariables from file
		numOfVariables = scanner.nextInt();
		
		// Creates an ArrayList<Integer> of numbers for grid from file
		ArrayList<Integer> gridNumbers = new ArrayList<Integer>();
		while( scanner.hasNext() )
		{

			if( scanner.hasNextInt() )
			{
				gridNumbers.add(scanner.nextInt());
			}
			else
			{
				scanner.next();
			}
		}
		scanner.close();
		return gridNumbers;
	}
	
	// createGrid( ArrayList<Integer> gridNumbers ) - creates the grid out of ArrayList
	public static  void createGrid( ArrayList<Integer> gridNumbers )
	{
		grid = new int[numOfVariables+1][numOfVariables+1];
		for( int i = 0; i < numOfVariables+1; i++ )
		{
			for( int j = 0; j < numOfVariables+1; j++ )
			{
				grid[i][j] = gridNumbers.get( 0 );
				gridNumbers.remove( 0 );
			}
		}
	}
	
	// runGeneticAlgorithm( ) - runs the genetic algorithm 
	public static void runGeneticAlgorithm( )
	{
		
	}
}
