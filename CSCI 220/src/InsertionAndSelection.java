import java.util.Random;
import java.util.Scanner;


/***************************
 * 
 * @author Joe O'Brien
 * @class CSCI 220
 * @date 4/17/2017
 * @source http://www.java2novice.com/java-interview-programs/insertion-sort/
 * 
 */
public class InsertionAndSelection {
	
	public static void main (String args[]){
		//Declaring variables for main method
		Scanner keyboard = new Scanner(System.in);
		int amountToCount = 0;
		
		//Prompting user to enter size of array;
		System.out.println("How many numbers would you like to sort?");
		amountToCount = keyboard.nextInt();
		
		//Declaring 2 arrays that will hold ints to be sorted.
		int selectionListOfNumbers[] = new int[amountToCount];
		int insertionListOfNumbers[] = new int[amountToCount];
		
		//Filling both arrays using random num generator
		fillArray(insertionListOfNumbers);
		fillArray(selectionListOfNumbers);
		
		//Prompting user array is being sorted(insertion)
		System.out.println("This is your array sorted using insertion sort:");
		InsertionSort(insertionListOfNumbers);
		
		System.out.println();
		//Prompting user array is being sorted(selection)
		System.out.println("This is your array sorted using selection sort:");
		SelectionSort(selectionListOfNumbers);
	}
	
	//Filling array with random num generator with numbers between 1 and 100
	public static void fillArray(int list[]){
		Random rand = new Random();
			for(int i = 0; i < list.length; i++)
				list[i] = rand.nextInt(99) + 1;
			
	}
	
	//Method to print array when called
	public static void printArray(int[] listOfNumbers){
		//Printing sorted list to console
		for(int i = 0; i < listOfNumbers.length; i++){
			System.out.print(listOfNumbers[i] +"  ");
		}
		System.out.println();
	}
			
	//Pass in array to be sorted using insertion sort
	public static void InsertionSort(int[] listOfNumbers){
		//printArray(listOfNumbers);
		//Begin insertion sort
		for(int i = 1; i < listOfNumbers.length; i++){
			int temp = listOfNumbers[i];
			int j;
			//Looping to check and sort numbers
			//Swap numbers if temp < listOfNumbers[j]
			for(j = i - 1; j >= 0 && temp < listOfNumbers[j]; j--){
				listOfNumbers[j+1] = listOfNumbers[j];
			}
			listOfNumbers[j+1] = temp;
			//printArray(listOfNumbers);
		}
		
	}
	
	//Pass in array to be sorted using selection sort
	public static void SelectionSort(int [] listOfNumbers){
		//Begin selection sort
		for(int i = 0; i < listOfNumbers.length - 1; i++){
			int index = i;
			for(int j = i + 1; j < listOfNumbers.length; j++){
				//Finding lowest index
				if(listOfNumbers[j] < listOfNumbers[index]){
					index = j;
				}
			} 	
			//Setting list of numbers to 
			int smallerNum = listOfNumbers[index];
			listOfNumbers[index] = listOfNumbers[i];
			listOfNumbers[i] = smallerNum;
			//printArray(listOfNumbers);
			}
		}
		

	}