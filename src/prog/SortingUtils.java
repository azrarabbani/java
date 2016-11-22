package prog;


import java.util.*;

/**
 * Created by arabbani on 10/28/16.
 */
public class SortingUtils {

    public static Stack<Integer>  sort(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        while(!stack.isEmpty()) {//o(n)
            if(sortedStack.isEmpty()) {
                sortedStack.push(stack.pop());
            } else {
                Stack<Integer> tempStack = new Stack<>();
                Integer temp = stack.pop();//get next unsorted number
                while(!sortedStack.isEmpty() && temp < sortedStack.peek()) {
                    tempStack.push(sortedStack.pop());
                }
                sortedStack.push(temp);
                while(!tempStack.isEmpty()) {
                    sortedStack.push(tempStack.pop());
                }
            }
        }
        return sortedStack;
    }


    public static Stack<Integer>  sortAsStream(Stack<Integer> stack) {
        return new Stack();//return stack.stream().sorted().map().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Stack<Integer> unsortedStack = new Stack<>();
        unsortedStack.push(34);
        unsortedStack.push(4);
        unsortedStack.push(24);
        unsortedStack.push(7);
        unsortedStack.push(38);
        System.out.println("UnSorted stack " + unsortedStack.toString());
        Stack<Integer> sortedStack = sort(unsortedStack);
        System.out.println("Sorted stack "+sortedStack.toString());




    }
}
