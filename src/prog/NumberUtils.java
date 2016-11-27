package prog;


import java.util.*;
/**
 * Created by arabbani on 10/18/16.
 */
public class NumberUtils {


    private static Random rand = new Random();

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in); int number = Integer.MAX_VALUE;
////        while (number != 0) { // Ask user to enter number for decimal to binary conversion
////         System.out.println("\nEnter a decimal number to convert into binary format");
////            number = sc.nextInt(); // one way to convert decimal number to binary in Java
////            //byte[] bits = toBinary(number);
////            //printBinary(bits); // combined conversion and printing part in one method
////            convert(number);
////
////
////        }
////        sc.close();
//
//        Integer[] numbers = new Integer[]{ 1, 1, 2, 1, 3, 4, 5 };
//
////        final int[] distinct = Arrays.stream(numbers)
////                .distinct()
////                .toArray();
////        for(int i : distinct) {
////           System.out.print(i+" , ");
////        }
//
//        Set<Integer> all = new HashSet<>();
//
//        Set<Integer> distinctSet = Arrays.stream(numbers)
//                .filter(n -> all.add(n))
//                .collect(Collectors.toSet());
////                .distinct()
////                .toArray();
//        for(Integer i : distinctSet) {
//            System.out.print(i+" , ");
//        }
//
//
//        numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
//        Set<Integer> allItems = new HashSet<>();
//
//        Set<Integer> duplicates = Arrays.stream(numbers)//source
//                .filter(n -> !allItems.add(n)) //intermediate//Set.add() returns false if the item was already in the set.
//                .collect(Collectors.toSet()); //terminal
//
//        convert(13);
//        byte[] bits = toBinary(13);
//        printBinary(bits);
//        System.out.println();
//        findDuplicates(Arrays.asList(1, 4, 7, 4, 2, 8, 9, 1, 10, 442, 55, 44, 234));
//        System.out.println("Random  ------------- ");
//        for(int i = 0 ; i < 20; i++) {
//            System.out.print(rand.nextInt(10) + " ");
//        }
//
//        swapNumWithoutTemp(10 , 16);
        int num = 7;
        //int tib = tribonacci(num);
       // System.out.println("tribonacci (" + num + ")  = " + tib);

        System.out.println("256 >>> 1  = " + (256 >>> 1 )); //means 256 / 2
        System.out.println("256 >>> 2  = " + (256 >>> 2 )); //means 256 / 2 = 128 / 2 = 64
        System.out.println("256 >>> 3  = " + (256 >>> 3 ));//means 256 / 2 = 128 / 2 = 64 / 2 = 32
        System.out.println("256 >>> 4  = " + (256 >>> 4 ));//means 256 / 2 = 128 / 2 = 64 / 2 = 32 / 2 =16
        //isPowerOf4(81);
        //isPowerOf4(256);

    }

    int median(int[] num){
        if(num == null || num.length == 0) return -1;
        if(num.length == 1) return num[0];
        if(num.length == 2) return num[0] + num[1] / 2;
        int size = num.length;
        int mod = size % 2;
        int mid = size / 2;
        if(mod == 0) { //even
            return num[mid-1] + num [mid] / 2;
        } else {//odd
            return num[mid];
        }

    }


    private static void isPowerOf4(int input ) {
        for(int i=1; i<input/4; i++) {
            if(Math.pow(i,4) == input) {
                System.out.print(true);
                return;
            }
        }
        System.out.print(false);

        double d = Math.sqrt(input);
        System.out.println("input="+input);
        System.out.println("Sqrt  " + d);
        d = Math.sqrt(d);
        System.out.println("Sqrt  " + d);

        d = Math.sqrt(d);
        System.out.println("Sqrt  " + d);
        System.out.println("power  " + Math.pow(d, 9));
    }


    public static void swapNumWithoutTemp(int x, int y) {
        System.out.println(" before swapping X = "+x +"   , Y = "+y);

        // Code to swap 'x' (1010) and 'y' (0101)
        x = x ^ y;  // x now becomes 15 (1111)
        y = x ^ y;  // y becomes 10 (1010)
        x = x ^ y;  // x becomes 5 (0101)

        System.out.println(" after swapping X = " + x + "   , Y = " + y);

        x =4; y=2;
        System.out.println(" before swapping X = "+x +"   , Y = "+y);
        x = x + y; //6
        y = x - y;//4
        x = x - y;//2

        System.out.println(" after swapping X = " + x + "   , Y = " + y);

        x  = 65 ; y = 90;
        System.out.println(" before swapping X = "+x +"   , Y = "+y);
        x = x * y;  // x now becomes 50
        y = x / y;  // y becomes 10
        x = x / y;  // x becomes 5
        System.out.println(" after swapping X = "+x +"   , Y = "+y);

    }



    public static byte[] toBinary(int number) {
        byte[] binary = new byte[32];
        int index = 0;
        int copyOfInput = number;
        while (copyOfInput > 0) {
            binary[index++] = (byte) (copyOfInput % 2);
            copyOfInput = copyOfInput / 2;
        }
        return binary;
    }

    public static void printBinary(byte[] binary) {
        for (int i = binary.length - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    } /* * Combination of previous two method to convert and print binary numbers */



    public List<Integer> getListIntersection(List<Integer> list1 , List<Integer> list2) {
        //You could put all elements of the first list into a hash set. Then, iterate the second one and, for each of its elements, check the hash to see if it exists in the first list. If so, output it as an element of the intersection.
        Set<Integer> set = new HashSet<>();
        for(Integer in : list1) {
            set.add(in);
        }
        List<Integer> intersection = new ArrayList<>();
        for(Integer in : list2) {
            if(set.contains(in)) {
                intersection.add(in);
            }
        }
        //complexity O(n) + O(n)
        return intersection;
    }

    public static List<Integer> findDuplicates(List<Integer> list1) {
        //You could put all elements of the first list into a hash set. Then, iterate the second one and, for each of its elements, check the hash to see if it exists in the first list. If so, output it as an element of the intersection.
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for(Integer in : list1) {
            if(!set.add(in)) {
                duplicates.add(in);
                System.out.println(in);
            }
        }
        //complexity O(n) + O(n)
        //Merge sort is O(n log(n)) while checking neighboring values is simply O(n).
        return duplicates;
    }

//0,1,1,2,4,8,
    public static int tribonacci(int num) {
        if(num == 1) { return 0;}
        if(num == 2 || num == 3) { return 1;}
        int tib = tribonacci(num -1);//tib=1 on 1st  return
        tib += tribonacci(num - 2) ; //num = 4; recur for 4 -2 => 2 =1
        tib += tribonacci(num - 3);// num = 4; tib = 2
        return tib;//tib = 2
    }
// fact(n - 1) * n
//    factR(6) = factR(5) * 6
//            = (factR(4) * 5) * 6
//            = ((factR(3) * 4) * 5) * 6
//            = (((factR(2) * 3) * 4) * 5) * 6
//            = ((((factR(1) * 2) * 3) * 4) * 5) * 6
//            = ((((1 * 2) * 3) * 4) * 5) * 6
//            = (((2 * 3) * 4) * 5) * 6
//            = ((6 * 4) * 5) * 6
//            = (24 * 5) * 6
//            = 120 * 6
//            = 720

    Set<Integer> union(){
        int[] list1 = { 0,4,7,9,11};
        int[] list2 = { 0,2,4,6,9,11};
        int sizeOfList1 = list1.length;
        int sizeOfList2 = list2.length;
        Set<Integer> union = new HashSet<>();
        int pointer1 = 0;
        int pointer2 =0;

        while(pointer1 < sizeOfList1 && pointer2 < sizeOfList2 ) {

            if(list1[pointer1] <= list2[pointer2] )
            {
                union.add(list1[pointer1++]);
            } else {
                union.add(list2[pointer2++]);
            }
        }

       for(int i = pointer1;  i < sizeOfList1 ; i++) {
           union.add(list1[pointer1]);
       }
        for(int i = pointer2;  i < sizeOfList2 ; i++) {
            union.add(list2[pointer2]);
        }
        return union;
    }


    public static void convert(int input) {
        int copyOfInput = input;
        StringBuilder sb = new StringBuilder();
        while (copyOfInput > 0) {
            byte bit = (byte) (copyOfInput % 2);
            sb.append(bit);
            copyOfInput = copyOfInput / 2;
        }
        System.out.printf("\nDecimal number %d in Binary format is %s %n", input, sb.reverse().toString());
    }



}
