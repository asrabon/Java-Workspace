/**
 * @author Gavin Starnes
 * sorts and integer array with the heap sort algorithm
 * sorted array is in ascending order
 * help was derived from http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html 
 */
public class HeapSort {
	private static int size; /** size of the array passed in*/
	
	/**
	 * this method sorts the array passed in using heap sort
	 * @param array an array of integers
	 */
	public static void heapSort(int[] array){
		constructHeap(array);
		for(int i = size; i > 0; i--){
			swap(0,i,array);
			size = size - 1;
			reHeap(array, 0);
		}
	}
	
	/**
	 * this array begins the construction of the heap that will be sorted called by heapSort
	 * @param array an array of integers
	 */
	private static void constructHeap(int[] array) {
		size = array.length-1;
		for(int i = size/2; i >= 0; i-- ){
			reHeap(array, i);
		}
		
	}
	
	/**
	 * this method orders the heap correctly as it is constructed so that the root is the max integer and children
	 * of any node are smaller than their parent
	 * @param array an array of integers
	 * @param i current node in the array being evaluated 
	 */
	private static void reHeap(int[] array, int i) {
		int left = 2*i;
		int right = 2*i+1;
		int max;
		if(left <= size && array[left] > array[i]){
			max = left;
		}else{
			max = i;
		}
		
		if(right <= size && array[right] > array[max]){
			max = right;
		}
		if(max != i ){
			swap(i, max,array);
			reHeap(array, max);
		}
		
	}
	
	/**
	 * swaps integer A with integer B in the given array
	 * @param a an integer
	 * @param b an integer
	 * @param array an array off integers
	 */
	private static void swap(int a, int b,int[] array){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
