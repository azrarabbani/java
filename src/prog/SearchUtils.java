package prog;

/**
 * Created by arabbani on 10/25/16.
 */
public class SearchUtils {



    public static int binarySearch(int[] a, int key) {
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) {
                // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                if      (key < a[mid]) hi = mid - 1;
                else if (key > a[mid]) lo = mid + 1;
                else return mid;
            }
            return -1;
        //Arrays.stream();
    }



}
