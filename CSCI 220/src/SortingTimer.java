import java.util.Arrays;

public class SortingTimer {
	
	private static long startTime;
	private static long endTime;
	
	public static long insertionSortTimer(int[] a) {
		startTime = 0;
		endTime = 0;
		int[] insertionSortArray = Arrays.copyOf(a, a.length);
		startTime = System.currentTimeMillis();
		//preform insertion sort
		InsertionAndSelection.InsertionSort(insertionSortArray);
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static long selectionSortTimer(int[] a) {
		startTime = 0;
		endTime = 0;
		int[] selectionSortArray = Arrays.copyOf(a, a.length);
		startTime = System.currentTimeMillis();
		//preform selection sort
		InsertionAndSelection.SelectionSort(selectionSortArray);
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static long heapSortTimer(int[] a) {
		startTime = 0;
		endTime = 0;
		int[] heapSortArray = Arrays.copyOf(a, a.length);
		startTime = System.currentTimeMillis();
		//perform heap sort
		HeapSort.heapSort(heapSortArray);
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

}
