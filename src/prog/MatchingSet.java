package prog;

import java.util.*;

public class MatchingSet {

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
    }

//    public static void makeSetsMatching(int n , int[] x , int[] y) {
//
//        if(n == 1) {
//            System.out.println(-1);//not possible
//            return;
//        } if (n == 2) {
//            if(--x[0] != y[0] || --x[1] != y[1]) {
//                System.out.println(-1);//not possible
//                return;
//            }
//        }
//        int decrementIndex = 0;
//        int incrementIndex = 0;
//        int numberOfDifferentElements = 0;
//
//        for(int i = 0 ; i < n ; i++)
//        {
//            if(x[i] != y[i]) {
//                numberOfDifferentElements++;
//                if(x[i] > y[i]) {
//                    decrementIndex = i;
//                } else if(x[i] < y[i]) {
//                    incrementIndex = i;
//                }
//                if(numberOfDifferentElements > 2 ) {
//                    System.out.println(-1);//not possible
//                    return;
//                }
//
//            }
//        }
//
//       if(numberOfDifferentElements == 0) {
//           System.out.println(0);//no diff found
//           return;
//       }
//
//        int numOfOperationsForDecrement = x[decrementIndex] - y[decrementIndex]  ;
//        int numOfOperationsForIncrement = y[incrementIndex] - x[incrementIndex]  ;
//        if(numOfOperationsForDecrement != numOfOperationsForIncrement) {
//            System.out.println(-1); //not possible, this might not be necessary need to checked
//            return;
//        }
//        while(x[decrementIndex] != y[decrementIndex] ) {
//            x[decrementIndex]--;
//        }
//        while(x[incrementIndex] != y[incrementIndex] ) {
//            x[incrementIndex]++;
//        }
//
//        for(int i = 0 ; i < n ; i++)
//        {
//            if(x[i] != y[i]) {
//                System.out.println(-1);
//                return;
//            }
//        }
//        System.out.println(numOfOperationsForDecrement > numOfOperationsForIncrement ? numOfOperationsForDecrement : numOfOperationsForIncrement);
//    }
//




    public static void makeSetsMatching(int n , int[] x , int[] y) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> xList2 = new ArrayList<>();
        List<Integer> yList =  new ArrayList<>() ;
        List<Integer> yList2 =  new ArrayList<>() ;

        for(int val : x) {
            xList.add(val);
            xList2.add(val);
        }

        for(int val : y) {
            yList.add(val);
            yList2.add(val);
        }

        for(Integer val : xList) {
            yList2.remove(val);
        }

        for(Integer val : yList) {
            xList.remove(val);
        }
        //xList.removeAll(yList);
        System.out.println("XList : " + xList);

        //yList2.removeAll(xList2);
        System.out.println("yList : " + yList2);

        if(yList2.size() != 2 || xList.size() != 2 ) {
            System.out.println(-1);//no diff found
            return;

        } else if (yList2.size() == 0 || xList.size() == 0) {
            System.out.println(0);//no diff found
            return;

        }
        int sumX = xList.get(0) + xList.get(1);
        int sumY = yList2.get(0) + yList2.get(1);
        if(sumX != sumY) {
            System.out.println(-1);//no diff found
            return;
        }

        int temp = 0;
        if(xList.get(1) < xList.get(0)) {
            temp = xList.get(0);
            xList.set(0, xList.get(1));
            xList.set(1, temp);
        }


        if(yList2.get(1) < yList2.get(0)) {
            temp = yList2.get(0);
            yList2.set(0, yList2.get(1));
            yList2.set(1, temp);
        }

        int diff1 = Math.abs(xList.get(0) -  yList2.get(0));
        int diff2 = Math.abs(xList.get(1) - yList2.get(1));

        if(diff1 != diff2) {
            System.out.println(-1);//no diff found
            return;
        }

        System.out.println(diff1);

//        ArrayList<Integer> remove = new ArrayList<Integer>(original);
//        remove.removeAll(selected);
//        System.out.println("Remove: " + remove);
//        Set<Integer> xSet = toSet(x);
//        Set<Integer> ySet = toSet(y);
//        List<Integer> diff = new ArrayList<>();
//        for(Integer val : xSet) {
//            if(!ySet.contains(val)) {
//                diff.add(val);
//            }
//            if(diff.size() > 2) {
//                System.out.println(-1);
//                return;
//            }
//        }
//        if(diff.size() == 0) {
//            System.out.println(0);//no diff found
//            return;
//        } else if(diff.size() < 2) {
//            System.out.println(-1);//not possible
//            return;
//        }




    }


    private static Set<Integer> toSet(int[] x) {
        Set<Integer> xSet = new HashSet<>();
        for(int i : x) {
            xSet.add(i);
        }
        return xSet;
    }


    public static void makeSetsMatching2(int n , int[] x , int[] y) {

        if(n == 1) {
            System.out.println(-1);//not possible
            return;
        } if (n == 2) {
            if(--x[0] != y[0] || --x[1] != y[1]) {
                System.out.println(-1);//not possible
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
        while(x[decrementIndex] != y[decrementIndex] ) {
            x[decrementIndex]--;
        }
        while(x[incrementIndex] != y[incrementIndex] ) {
            x[incrementIndex]++;
        }

        for(int i = 0 ; i < n ; i++)
        {
            if(x[i] != y[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(numOfOperationsForDecrement > numOfOperationsForIncrement ? numOfOperationsForDecrement : numOfOperationsForIncrement );



    }


    public static int selectNextIndexForIncrement (int n,  int decrementIndex,  int[] x , int[] y) {
        Random r = new Random();
        int incrementIndex = r.nextInt(n - 1);
        int attempts = 0;
        while(attempts++ < (n-1) ) {
            if(incrementIndex == decrementIndex) {
                attempts --; //do not count this attempt
            } else if(x[incrementIndex] < y[incrementIndex]) { //where i != j
                return incrementIndex;
            }
            incrementIndex = r.nextInt(n - 1);
        }
        return -1;
    }


    public static int selectNextIndexForDecrement (int n, int[] x , int[] y) {
        Random r = new Random();
        int decrementIndex = r.nextInt(n - 1);
        int attempts = 0;
        while( attempts++ < (n-1) ) {
            if(x[decrementIndex] > y[decrementIndex]) {
                return decrementIndex;
            }
            decrementIndex = r.nextInt(n - 1);
        }
        return -1;
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
}
