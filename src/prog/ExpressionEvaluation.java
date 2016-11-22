package prog;

import java.util.*;
/**
 * Created by arabbani on 11/1/16.
 */
public class ExpressionEvaluation {

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
            if(numbers.size() < 1) {
                return -1;
            }
            number = numbers.pop();
            if(number >= 0 ) {
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
                int res =0;
                try{
                    res =  Math.addExact(operand1 , operand2);
                }catch(Exception e){
                    throw new IllegalArgumentException("Overflow!");
                }
                numbers.push(res );
            } else if(operator == '-'){
                int res =0;
                try{
                    res =  Math.subtractExact(operand1 , operand2);
                }catch(Exception e){
                    throw new IllegalArgumentException("underflow!");
                }
                numbers.push(res );
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

        public static void main(String[] args) {
            //test cases
            System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -"));
            System.out.println(solution("5 6 + -"));
        }
    }

