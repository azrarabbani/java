package prog;

/**
 * Created by arabbani on 11/13/16.
 * What is the algorithmic approach
 * to find the first missing positive integer provided an unsorted integer array in O(n) time complexity and constant space?
 */
public class FindMissingNumber {


    /**
     * this will be only helpful when the arr size is not too large and max possible value in array is also not very large.
     * in worst case scenario the time complexity will be o(maxValue)
     * @param arr
     * @param maxValue
     * @return
     */
    public static int findFirstmissing(int[] arr, int maxValue){
        if(arr == null) return 0;
        boolean exist[] = new boolean[maxValue];
        for(int j = 0; j < arr.length; j++) {
            exist[arr[j]] = true;
        }
        int i = 0;
        while(i < exist.length) {
            if(!exist[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }




    public static void main(String[] args) {


    }
}
