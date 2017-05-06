import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//Random object used to randomly generate numbers
	private static Random rand = new Random();
	
	//integer arrays used to hold integers scanned in from file objects
	static int[] thousandIntegers = new int[1000];
	static int[] tenThousandIntegers = new int[10000];
	static int[] hundredThousandIntegers = new int[100000];
	static int[] millionIntegers = new int[1000000];
	
	//file objects that numbers are randomly generated and inserted into
	static File thousandFile = new File("thousandIntegers.txt");
	static File tenThousandFile = new File("tenThousandIntegers.txt");
	static File hundredThousandFile = new File("hundredThousandIntegers.txt");
	static File millionFile = new File("millionIntegers.txt");
	
	//arrays that hold the total time for each sorting algorithm
	//index 0: is total time for sorting a thousand integers...index 3: is total time for sorting a million integers
	static long[] totalInsertionTime = new long[4];
	static long[] totalSelectionTime = new long[4];
	static long[] totalHeapTime = new long[4];

	public static void main(String[] args) throws IOException {
		
		System.out.println("Time to sort arrays of random integers.\n");

		//will get and print the sorting averages for random integers
		getSortingAverages("random");
		printAverages("random order");
		
		System.out.println("\nTime to sort arrays of ascending integers.\n");
		
		//will get and print the sorting averages for ascending integers
		getSortingAverages("ascending");
		printAverages("asceding order");
		
		System.out.println("\nTime to sort arrays of descending integers.\n");
		
		//will get and print the sorting averages for descending integers
		getSortingAverages("descending");
		printAverages("descending order");
	}

	/**
	 * This method will write the correct type of numbers to a text file, then will read those integers from the text file
	 * into an array, lastly all algorithms will be tested with each of these arrays and the time for each will be kept track of
	 * as a total time for each algorithm on each size array. This process will be done 100 times to get a good average of the
	 * time to complete each sort.
	 * 
	 * @param numberType string that represents if random, ascending, or descending integers are written to the file
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void getSortingAverages(String numberType) throws IOException, FileNotFoundException {
		fillZeros();
		for(int i=0; i<10; i++) {
			//if "random" is passed in it will fill a text file with random integers
			if(numberType.equals("random")) {
				fillRandomInts(thousandFile, 1000);
				fillRandomInts(tenThousandFile, 10000);
				fillRandomInts(hundredThousandFile, 100000);
				fillRandomInts(millionFile, 1000000);
			}
			//if "ascending" is passed in it will fill a text file with ascending integers
			else if(numberType.equals("ascending")) {
				fillAscendingInts(thousandFile, 1000);
				fillAscendingInts(tenThousandFile, 10000);
				fillAscendingInts(hundredThousandFile, 100000);
				fillAscendingInts(millionFile, 1000000);
			}
			//if "descending" is passed in it will fill a text file with descending integers
			else {
				fillDescendingInts(thousandFile, 1000);
				fillDescendingInts(tenThousandFile, 10000);
				fillDescendingInts(hundredThousandFile, 100000);
				fillDescendingInts(millionFile, 1000000);
			}
			//read all the integers from the text file into the array
			readIntoArray(thousandFile, thousandIntegers);
			readIntoArray(tenThousandFile, tenThousandIntegers);
			readIntoArray(hundredThousandFile, hundredThousandIntegers);
			readIntoArray(millionFile, millionIntegers);
			
			//perform insertion sort on thousand integers
			totalInsertionTime[0] = totalInsertionTime[0] + SortingTimer.insertionSortTimer(thousandIntegers);
			
			//perform insertion sort on ten thousand integers
			totalInsertionTime[1] = totalInsertionTime[1] + SortingTimer.insertionSortTimer(tenThousandIntegers);
			
			//perform insertion sort on hundred thousand integers
			totalInsertionTime[2] = totalInsertionTime[2] + SortingTimer.insertionSortTimer(hundredThousandIntegers);
			
			//perform insertion sort on one million integers
			totalInsertionTime[3] = totalInsertionTime[3] + SortingTimer.insertionSortTimer(millionIntegers);
			
			
			//perform selection sort on thousand integers
			totalSelectionTime[0] = totalSelectionTime[0] + SortingTimer.selectionSortTimer(thousandIntegers);
			
			//perform selection sort on ten thousand integers
			totalSelectionTime[1] = totalSelectionTime[1] + SortingTimer.selectionSortTimer(tenThousandIntegers);
			
			//perform selection sort on hundred thousand integers
			totalSelectionTime[2] = totalSelectionTime[2] + SortingTimer.selectionSortTimer(hundredThousandIntegers);
			
			//perform selection sort on one million integers
			totalSelectionTime[3] = totalSelectionTime[3] + SortingTimer.selectionSortTimer(millionIntegers);
			
			
			//perform heap sort on thousand integers
			totalHeapTime[0] = totalHeapTime[0] + SortingTimer.heapSortTimer(thousandIntegers);
			
			//perform heap sort on ten thousand integers
			totalHeapTime[1] = totalHeapTime[1] + SortingTimer.heapSortTimer(tenThousandIntegers);
			
			//perform heap sort on hundred thousand integers
			totalHeapTime[2] = totalHeapTime[2] + SortingTimer.heapSortTimer(hundredThousandIntegers);
			
			//perform heap sort on one million integers
			totalHeapTime[3] = totalHeapTime[3] + SortingTimer.heapSortTimer(millionIntegers);
		}
	}
	
	/**
	 * This method will take in a string of how the numbers in the text file was ordered and print out to the console
	 * the average for each sorting algorithm on each sized array for that given number order.
	 * 
	 * @param numberOrder specifies how the numbers in the text files were ordered. Ascending, descending, random.
	 */
	private static void printAverages(String numberOrder) {
		String amount = "";
		for(int i=0; i < 4; i++) {
			switch(i) {
			case 0:
				amount = "thousand";
				break;
			case 1:
				amount = "ten thousand";
				break;
			case 2:
				amount = "hundred thousand";
				break;
			case 3:
				amount = "million";
			}
			System.out.println("Average time to complete insertion sort on " + amount + " integers in " + numberOrder + ": " + (totalInsertionTime[i]/10));
		}
		
		for(int i=0; i < 4; i++) {
			switch(i) {
			case 0:
				amount = "thousand";
				break;
			case 1:
				amount = "ten thousand";
				break;
			case 2:
				amount = "hundred thousand";
				break;
			case 3:
				amount = "million";
			}
			System.out.println("Average time to complete selection sort on " + amount + " integers in " + numberOrder + ": " + (totalSelectionTime[i]/10));
		}
		
		for(int i=0; i < 4; i++) {
			switch(i) {
			case 0:
				amount = "thousand";
				break;
			case 1:
				amount = "ten thousand";
				break;
			case 2:
				amount = "hundred thousand";
				break;
			case 3:
				amount = "million";
			}
			System.out.println("Average time to complete heap sort on " + amount + " integers in " + numberOrder + ": " + (totalHeapTime[i]/10));
		}
	}

	/**
	 * This method will write random integers to a text file until the amount of integers it has
	 * written to the file is equivalent to the size parameter.
	 * 
	 * @param f File object to write random integers to
	 * @param size The amount of numbers needed to be written to that file
	 * @throws IOException
	 */
	public static void fillRandomInts(File f, int size) throws IOException {
		FileWriter out = new FileWriter(f);
		for(int i = 0; i < size ; i++) {
			//a[i] = rand.nextInt(Integer.MAX_VALUE-1) + 1;
			out.write(Integer.toString(rand.nextInt(Integer.MAX_VALUE-1) + 1) + " ");
		}
		out.close();
	}

	/**
	 * This method will write integers in ascending order to a text file until the amount of integers it has
	 * written to the file is equivalent to the size parameter.
	 * 
	 * @param f File object to write ascending integers to
	 * @param size The amount of numbers needed to be written to that file
	 * @throws IOException
	 */
	public static void fillAscendingInts(File f, int size) throws IOException {
		FileWriter out = new FileWriter(f);
		int step = 100;
		int max = 100;
		for(int i=0; i<size; i++) {
			out.write(Integer.toString(rand.nextInt(step) + 1 + (max*i)) + " ");
		}
		out.close();
	}

	/**
	 * This method will write integers in descending order to a text file until the amount of integers it has
	 * written to the file is equivalent to the size parameter.
	 * 
	 * @param f File object to write descending integers to
	 * @param size The amount of numbers needed to be written to that file
	 * @throws IOException
	 */
	public static void fillDescendingInts(File f, int size) throws IOException {
		FileWriter out = new FileWriter(f);
		int step = 100;
		int max = 1000000000;
		for(int i=0; i<size; i++) {
			out.write(Integer.toString(rand.nextInt(step) + (max)) + " ");
			max = max - 100;
		}
		out.close();
	}
	
	/**
	 * This will iterate through every integer in the file and each integer will be placed
	 * into the array
	 * 
	 * @param f File to read from
	 * @param a Array to put values in
	 * @throws FileNotFoundException
	 */
	public static void readIntoArray(File f, int[] a) throws FileNotFoundException {
		Scanner fileScan = new Scanner(f);
		int i = 0;
		while(fileScan.hasNextInt()) {
			a[i] = fileScan.nextInt();
			i++;
		}
		fileScan.close();
	}

	public static void fillZeros() {
		for(int i=0; i<4; i++) {
			totalInsertionTime[i] = 0;
			totalSelectionTime[i] = 0;
			totalHeapTime[i] = 0;
		}
	}
	
}
