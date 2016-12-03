package prog;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

/**
 * Created by ravee on 12/2/2016.
 */
public class Codility {


    public static int frogJump(int X, int Y, int D) {
        // write your code in Java SE 8
        int sum = X;
        int count = 0;
        while (sum < Y) {
            sum += D;
            count++;
        }
        return count;
    }


    public static int frogJump2(int X, int Y, int D) {
        // write your code in Java SE 8
        double sum = (Y - X ) /(double) D;
        double value = sum;//3.25;
        double fractionalPart = value % 1;
        double integralPart = value - fractionalPart;
        if (fractionalPart > 0){
            return (int)integralPart +1;
         }

        return (int)integralPart;


    }

    public static  int solution(int[] A) {
        // write your code in Java SE 8
        int result = A.length + 1;
        for ( int i = 0; i < A.length; i++) {
            result = result - A[i] + i + 1;
        }
        return result;
    }


    public static int oddOccurrences(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int result = A[0];
        for (int i = 1; i < A.length; i++){
            System.out.println(Integer.toBinaryString(result) + " ^ "+Integer.toBinaryString(A[i])+"="+A[i]);
            result = result ^ A[i];
        }
        return result;
        // write your code in Java SE 8
//        Arrays.sort(A);
//        int prev = A[0];
//        int count = 1;
//        for (int i = 1; i < A.length; i++) {
//            if (prev == A[i]) {
//                count++;
//            } else {
//                if (count % 2 == 0) {
//                    count = 1;
//
//                } else {
//                    return prev;
//                }
//            }
//            prev = A[i];
//
//        }
//        if(count % 2 > 0) {
//            return prev;
//        }
//        return -1;1
    }

    public static void main(String[] args){
        int[] num={1,4,6,4,4,1,5,6,5,6,6};
        System.out.println("Odd "+oddOccurrences(num));
        System.out.println("Frog Jump "+frogJump2(12,34, 9));
        System.out.println("Frog Jump "+frogJump2(0,50, 10));
        int[] num2={2,3,4,5,6,7,8};
        System.out.println("solution "+solution(num2));
        int[] num3={1,2,3,4,5,6,7,8};
        System.out.println("solution "+solution(num3));

        int[] num4={1,2,3,5};
        System.out.println("solution "+solution(num4));
    }
}
