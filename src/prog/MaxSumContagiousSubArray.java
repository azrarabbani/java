package prog;

import java.util.*;

/**
 * Created by arabbani on 11/18/16.
 */
public class MaxSumContagiousSubArray {



    public static int maxConsecutiveSeq(int[] num){
        Set<Integer> numSet = new HashSet();
        for(int n : num) {
            numSet.add(n);
        }
        int i = 0;
        int max = 0;
        for(int v : numSet){
            if(numSet.contains(i-1)) continue;
            int length = 0;
            while(numSet.contains(i++)) length++;
            max = Math.max(max, length);
        }
        return max;
    }


    public static int[] getMaxContagiousSubArray(int[] num){
        int sum = 0;
        int count = 0;
        int endIndx = 0;
        int sIndx = 0;
        int maxSum = 0;

        for(int i = 0 ; i < num.length ; i++){
            sum += num[i];
            count++;
            if(sum > maxSum) {
                maxSum = sum;
            } else if(sum < maxSum ){
                if(num[i] < 0 ) {
                   if(sum != num[i]) {//
                        sIndx = i  - count + 1;
                        endIndx = i - 1;
                    }
                    count = 0;
                    sum = 0;
                }
            }
        }


        System.out.println("sIndx="+sIndx+" , endIndx="+endIndx);
        System.out.println("Max sum "+maxSum);
        int size = endIndx - sIndx + 1;
        int[] sub = new int[size];
        int i = 0;
        for(int j = sIndx ; j <= endIndx; j++){
            sub[i++] = num[j];
        }
        return sub;
    }



    public static void main(String[] args){
        int[] num= {2,5,4,-7,10,8,-9,-2,-5,1,2,6,9,-20};
        int[] sub = getMaxContagiousSubArray(num);
        System.out.println(""+Arrays.toString(sub));
    }
}
