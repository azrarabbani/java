package prog;


import java.util.*;

/**
 * Created by arabbani on 8/11/16.
 */
public class NumSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x[] = new int[n];
        for(int i=0; i < n; i++){
            x[i] = in.nextInt();
        }
//        System.out.println( Math.floorMod(2, 3 ));
//        System.out.println(Math.floorMod(47, 6));
//
//        System.out.println( Math.floorMod(6, 1000000007 )); //we are considering this 1000000007 because we want to keep the first number smaller than this big num
        countNumOfSequence(n, x);

    }



    private static void countNumOfSequence(int n, int[] x ){
        List<Integer> negativeIdx =  new ArrayList<>();
        List<Integer> internalList =  new ArrayList<>();
        Set<List<Integer>> setOfSeq = new HashSet<>();
        for(int i = 0 ; i < x.length ; i++) {
            if(x[i] < 0) {
                negativeIdx.add(i);
                x[i] += 1;
            }
        }
        if(negativeIdx.size() == 0) {
            System.out.println(1);
        } else {
            for (int idx = 0;idx < negativeIdx.size(); idx++ ) {
                int[] xCopy = x;
                makePositiveNumSeq(negativeIdx.get(idx), xCopy, setOfSeq);
            }
            System.out.println(setOfSeq.size());
        }
    }

    private static void makePositiveNumSeq(int negativeIdx, int[] x, Set<List<Integer>> listOfSeq) {
        List<Integer> internalList =  new ArrayList<>();
        boolean allPositive = true;
        for (int val : x) {

            internalList.add(val);
        }
        System.out.println(internalList.toString());
        //if(allPositive) {
            listOfSeq.add(internalList);
        //}
        if(x[negativeIdx] <= negativeIdx - 1  ) {
            x[negativeIdx] += 1;
            makePositiveNumSeq(negativeIdx, x, listOfSeq);
        }

    }
//
//
//
//    private static void makePositiveNumSeq(List<Integer> negativeIdx, int i , int[] x, Set<List<Integer>> listOfSeq) {
//        List<Integer> internalList =  new ArrayList<>();
//        for (int val : x) {
//            internalList.add(val);
//        }
//        System.out.println(internalList.toString());
//        listOfSeq.add(internalList);
//        for (int idx = i;idx < negativeIdx.size(); idx++ ) {
////            BigDecimal big = new BigDecimal( Math.floorMod(6, 1000000007) );
////            System.out.println("Modulo "+big );
//            //if (listOfSeq.size() == Math.floorMod(listOfSeq.size(), 1000000007)) {
////            if(x[negativeIdx.get(idx)] >= x.length -1  ) {
//            int actualIndx = negativeIdx.get(idx);
//            if(x[actualIndx] <= actualIndx - 1  )
//            {
//                // return;
//                //    }
//                //else {
//                x[negativeIdx.get(idx)] += 1;
//                makePositiveNumSeq(negativeIdx, idx, x, listOfSeq);
//
//            }
//
//
//        }
//
//    }


}
