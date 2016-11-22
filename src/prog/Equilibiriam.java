package prog;

import java .util.*;
/**
 * Created by arabbani on 10/31/16.
 */
public class Equilibiriam {

    static final String POP ="POP";
    static final String DUP ="DUP";

    public static int solution(String S) {
        // write your code in Java SE 8

        String[] strArr = S.split("\\s");
        Stack<Integer> numbers = new Stack<Integer>();
        Character operator = null;
        Integer number = null;
        for(int i = 0 ; i  < strArr.length ; i++) {
            if (POP.equals(strArr[i])) {
                if (!numbers.isEmpty()) {
                    numbers.pop();
                } else {
                    return -1;
                }
            } else if (DUP.equals(strArr[i])) {
                if (!numbers.isEmpty()) {
                    numbers.push(numbers.peek());
                } else {
                    return -1;
                }
            } else if (( operator = getOperator(strArr[i]) )!= null ) {
                try {
                    applyOperator(numbers, operator);
                } catch(IllegalArgumentException e) {
                    return -1;
                }
            } else if ((number = getNumber(strArr[i])) != null) {
               numbers.push(number);
            }
        }
        if(numbers.size() < 1) { //at the end the number left should be one
            return -1;
        }
        number = numbers.pop();
        if(number > 0 ) {
            return number;
        } else {
            return -1;
        }
    }


    private static void applyOperator(Stack<Integer> numbers, Character operator ) {
        if(numbers.size() < 2) {
            throw new IllegalArgumentException("Operation not supported!");
        }
        Integer operand1 = numbers.pop();
        Integer operand2 = numbers.pop();
        if(operator == '+') {
            if((operand1 + operand2) > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Overflow!");
            }
            numbers.push( Math.addExact(operand1 ,operand2 ));
        } else if(operator == '-'){
            if((operand1 - operand2) < Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Underflow!");
            }
            numbers.push(  Math.subtractExact(operand1 , operand2));
        } else {
            throw new IllegalArgumentException("Operation not supported!");
        }
    }

    private static Character getOperator(String str) {
        if(str.length() == 1) {
            char c =  str.charAt(0);
            if( c == '+' || c == '-') {
                return new Character(c);
            }
        }
        return null;
    }

    private static Integer getNumber(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
           return null;
        }
    }
//
//    public static void solution(int N) {
//        // write your code in Java SE 8
//        String str = "";
//        for(int i = 1; i <= N ; i++) {
//
//            if(i % 3 == 0) {
//                str = "FIZZ";
//            }
//            if(i % 5 == 0) {
//                str += "BUZZ";
//            }
//            if(i % 7 == 0) {
//                str += "WOOF";
//            }
//
//            if(str.isEmpty()){
//                System.out.println(i);
//            } else {
//                System.out.println(str);
//            }
//            str = "";
//        }
//    }
    public static int findEquilibiriam(int[] nums) {
      if(nums == null ) return 0;
        if(nums.length == 0 ) {
            return 0;
        }
        if(nums.length < 3) {
            return -1;
        }
        int fwdIndex =0;
        int sum1 = nums[fwdIndex];
        int equiIndex = fwdIndex+1;
        //int fwdIndex = index+2;
        //int sum2 =  nums[fwdIndex];
        int backIdx = nums.length-1;
        int sum2 = nums[nums.length-1];
        while(equiIndex != backIdx && equiIndex <  nums.length-1 && backIdx > 2) {
            if(sum1 < sum2) {
                sum1 += nums[equiIndex];
                equiIndex = equiIndex +1;//move equi index
                if(equiIndex == backIdx) {
                    sum2 -=  nums[backIdx];
                }
            } else {
                backIdx = backIdx -1;
                sum2 += nums[backIdx];
            }
        }
        System.out.println("Fwd index "+backIdx);
        System.out.println("equi index "+equiIndex);
        System.out.println("Sum 1 "+sum1);
        System.out.println("sum 2  "+sum2);
        if(sum1 == sum2) {
            return equiIndex;
        }
        return -1;
    }

    public static void main(String[] main) {
//        int[] nums = {1, 6, -2 ,9, 5 ,  1 , -1};
//     System.out.println("equilibriam index is "+findEquilibiriam(nums));
//       int[] nums2 = {-1, 3, -4 ,5, 2 ,  -6 , 2};
//        System.out.println("equilibriam index is "+findEquilibiriam(nums2));
//
//        int[] nums3 = {-1, 3, -4 ,7, 2 ,  -6 , 1,1};
//        System.out.println("equilibriam index is "+findEquilibiriam(nums3));

        System.out.println(solution("13555 DUP 44555554 POP 535555555533 DUP + DUP + -"));
        System.out.println(solution("5 6 + -"));
    }
}
//
//
//while(equiIndex < nums.length-1 && backIdx > 2) {
//        if(sum1 < sum2) {
//        sum1 += nums[equiIndex];
//        equiIndex = equiIndex +1;//move equi index
//        if(equiIndex == backIdx) {
//        sum2 -=  nums[backIdx];
//        backIdx++;
//        if(sum1 == sum2) { return equiIndex; } else {
//
//        }
//        }
//
//        //sum2 -=  nums[equiIndex];//initialize sum2
//        //fwdIndex = equiIndex +1;
//        } else {
//        backIdx = backIdx -1;
//        sum2 += nums[backIdx];
//        }
