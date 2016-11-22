package prog;

/**
 * Created by arabbani on 8/10/16.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x[] = new int[n];
        for(int i=0; i < n; i++){
            x[i] = in.nextInt();
        }
        int y[] = new int[n];
        for(int j=0; j < n; j++){
            y[j] = in.nextInt();
        }
        validateInput(n, x, y);
        makeSetsMatching(n, x, y);

//        validateInput(n , x );
//        polygon(n, x);
    }


    public static void makeSetsMatching(int n , int[] x , int[] y) {

        if(n == 1) {
            System.out.println(-1);
            return;
        } if (n == 2) {
            if(--x[0] != y[0] || --x[1] != y[1]) {
                System.out.println(-1);
                return;
            }
        }
        int decrementIndex = selectNextIndexForDecrement(n, x, y);
        int incrementIndex = selectNextIndexForIncrement(n, decrementIndex, x, y);
        if(decrementIndex == -1  || incrementIndex == -1) {
            System.out.println(-1); //not possible
            return;
        }

        int numOfOperationsForDecrement = x[decrementIndex] - y[decrementIndex]  ;
        int numOfOperationsForIncrement = y[incrementIndex] - x[incrementIndex]  ;
        if(numOfOperationsForDecrement != numOfOperationsForIncrement) {
            System.out.println(-1);
            return;
        }
        for(int i = 0 ; i < decrementIndex; i++) {
            x[decrementIndex]--;
            x[incrementIndex]++;
        }
        for(int i = 0 ; i < n ; i++)
        {
            if(x[i] != y[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(numOfOperationsForDecrement);
    }


    public static int selectNextIndexForIncrement (int n,  int decrementIndex,  int[] x , int[] y) {
        Random r = new Random();
        int incrementIndex = r.nextInt(n - 1);
//        int attempts = 0;
//        while(attempts++ < (n-1) ) {
//            if(incrementIndex != decrementIndex) {
//               attempts --; //do not count this attempt
//            } else
//            if(x[incrementIndex] < y[incrementIndex]) { //where i != j
//               return incrementIndex;
//            }
//            incrementIndex = r.nextInt(n - 1);
//        }
//        return -1;
        return incrementIndex;
    }


    public static int selectNextIndexForDecrement (int n, int[] x , int[] y) {
        Random r = new Random();
        int decrementIndex = r.nextInt(n - 1);
//        int attempts = 0;
//        while( attempts++ < (n-1) ) {
//            if(x[decrementIndex] > y[decrementIndex]) {
//                return decrementIndex;
//            }
//            decrementIndex = r.nextInt(n - 1);
//        }
//        return -1;
        return decrementIndex;
    }

    public static void polygon(int n, int[] a) {
        validateInput (n, a);
        for(int i = 0 ; i < a.length ; i++) {
            int sum = 0;
            for (int j = 0 ; j < a.length ; j++  ) {
                if( j != i) {
                    sum += a[j];
                }
            }
            if(a[i] >= sum ) {
                System.out.println();
            }
        }
        //if a,b,c are input
        //a < b + c
    }


    public static void validateInput(int n , int[] x , int[] y) {

        if(n < 1 || n > (int) Math.pow(10, 5) || x.length != n || y.length != n) {
            throw new IllegalArgumentException("Not a valid input.") ;
        }
        for(int i : x) {
            if(i <  -(int) Math.pow(10, 9) || i > (int) Math.pow(10, 9)) {
                throw new IllegalArgumentException("Not a valid input.") ;
            }
        }


        for(int i : y) {
            if(i <  -(int) Math.pow(10, 9) || i > (int) Math.pow(10, 9)) {
                throw new IllegalArgumentException("Not a valid input.") ;
            }
        }

    }


    public static void validateInput(int n, int[] a) {
        if(n < 1 || n > 50 ) {
            throw new IllegalArgumentException("Not a vlid input.") ;
        }
        for(int i : a) {
            if(i < 1 || i > 100) {
                throw new IllegalArgumentException("Not a vlid input.") ;
            }
        }


    }
}

