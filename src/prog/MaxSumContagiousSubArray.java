package prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arabbani on 11/18/16.
 */
public class MaxSumContagiousSubArray {

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
            } else if(sum < maxSum && num[i] < 0 ) {
                sIndx = i  - count + 1;
                endIndx = i - 1;
                count = 0;
                sum = 0;
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
        int[] num= {2,5,4,-7,10,8,-9,1,2,6,9,-20};
        int[] sub = getMaxContagiousSubArray(num);
        System.out.println(""+Arrays.toString(sub));
    }
}
