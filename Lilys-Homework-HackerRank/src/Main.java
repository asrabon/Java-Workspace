import java.util.*;

/**
 * Created by Sloan on 4/20/2017.
 */
public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //get array size
        int arraySize = in.nextInt();
        //create array of that size
        int[] initialArray = new int[arraySize];
        for(int i=0; i<arraySize; i++) {
            initialArray[i] = in.nextInt();
        }
        //create a queue of arrays to hold each permutation
        Queue<int[]> permutationQueue = new LinkedList<int[]>();
        //add initial array and null array as break point
        permutationQueue.add(initialArray);
        permutationQueue.add(null);
        //create count
        int minimumSwaps = 0;
        //while no array in queue is sorted
        while(!containsSorted(permutationQueue)) {
            //get each of the array
            int[] currentArray = permutationQueue.remove();
            while(currentArray != null) {
                //get all permutations of switching values in each array and add each one back to queue
                addPermutations(currentArray, permutationQueue);
                currentArray = permutationQueue.remove();
            }
            permutationQueue.add(null);
            //count++
            minimumSwaps++;
        }
        System.out.println(minimumSwaps);
    }

    private static boolean containsSorted(Queue<int[]> permutationQueue) {
        //create copy of queue
        Queue<int[]> copyQueue = new LinkedList<>(permutationQueue);
        //go through each one checking if sorted
        int i = 0;
        while(copyQueue.peek() != null && i<copyQueue.size()) {
            int[] a = copyQueue.remove();
            //if sorted return true
            if(isSorted(a)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean isSorted(int[] a) {
        int previousInt = a[0];
        for(int i=1; i<a.length; i++) {
            if(!(previousInt < a[i])) {
                return false;
            } else {
                previousInt = a[i];
            }
        }
        return true;
    }

    private static void addPermutations(int[] a, Queue<int []> queue) {
        for(int i=0; i<a.length-1; i++) {
            for(int j=1; j<a.length; j++) {
                int[] permutation = Arrays.copyOf(a, a.length);
                int temp = permutation[i];
                permutation[i] = permutation[j];
                permutation[j] = temp;
                queue.add(permutation);
            }
        }
    }

}
