package prog;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * Created by arabbani on 10/25/16.
 */
public class StringUtils {

    private final static Pattern TASK_NAME_REGEX_VALIDATION_PATTERN = Pattern.compile("^\\w+[re*]");


    Comparator<String> com = ( String str1 , String str2)->  {
        return str1.compareTo(str2);
    };



    public static String reverseString(String str) {
        String strR = "";
     return reverseString(str.toCharArray(), 0, strR);

    }


    private static String reverseString(char[] str, int index, String strR) {
        if(index >= str.length) {
           return strR;
       }
        strR = reverseString(str,index+1, strR);
        return strR + str[index];

    }

    public static void main(String[] arg) {
//        System.out.println("Reverse  " + reverseString("sana"));
//        System.out.println("Reverse  " + TASK_NAME_REGEX_VALIDATION_PATTERN.matcher("_teww9tre").matches());
//        System.out.println("Reverse  " + TASK_NAME_REGEX_VALIDATION_PATTERN.matcher("9_teww9trerere").matches());
//        System.out.println("Reverse  " + TASK_NAME_REGEX_VALIDATION_PATTERN.matcher("0_").matches());
//        System.out.println("Reverse  " + TASK_NAME_REGEX_VALIDATION_PATTERN.matcher("0893649").matches());
//        Stream operations are divided into intermediate and terminal operations, and are combined to form stream pipelines. A stream pipeline consists
//        of a source (such as a Collection, an array, a generator function, or an I / O channel); followed by zero or
//        more intermediate operations such as Stream.filter or Stream.map; and a terminal operation such as Stream.forEach or Stream.reduce.

//        String s = "The quick brown fox jumped over the lazy dog.";
//        //Map<? , Integer> count =
//                s
//                .codePoints()
//                .mapToObj(i ->  (char) i)
//                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
//System.gc();
//        "The quick brown fox jumped over the lazy dog."
//                .chars()
//                .mapToObj(i -> (char) i)
//                .forEach(System.out::println);
//
//        Integer[] numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
//        Set<Integer> allItems = new HashSet<>();
//
//        Set<Integer> duplicates = Arrays.stream(numbers)//source
//                .filter(n -> !allItems.add(n)) //intermediate//Set.add() returns false if the item was already in the set.
//                .collect(Collectors.toSet()); //terminal
//        System.out.println(duplicates); // [1, 4]
//        Set<Integer> allItems2 = new HashSet<>();
//
//        //following is broken into multiple statements for understanding purpose
//        Stream<Integer> stream =Arrays.stream(numbers);
//        duplicates = stream
//                .filter(n -> { return !allItems2.add(n);}) //Set.add() returns false if the item was already in the set.
//                .collect(Collectors.toSet());
//
//        //The above statments cna be described as every element from the stream will be filtered by applying the given predicate to the filter method
//        // and whatever returns true for will be collected in the collection indicated in the collect argument which will be finally returned.
//
//        System.out.println(duplicates); // [1, 4]
//
//
//        System.out.println("Code point ------------------ "+"U+0061".codePointAt(0));
//

//        Files.lines(Paths.get("stuff.txt"))
//                .map(line -> line.split("\\s+")) // Stream<String[]>
//                .distinct() // Stream<String[]>
//                .forEach(System.out::println);

//        StringUtils.reverseAString("Life is good!");
//        StringUtils.reverseAString("sana anas");//Palindrome naturally
//        //StringUtils.isMirror("Was it a cat or a car i saw");
//        StringUtils.isMirror("chaahcsd");
//        StringUtils.evaluatePrefixNotation("+*236");
//        StringUtils.findMatchingParenthesisPosition("(ieueu))",0 );
    StringUtils.permutation("tom");
//        StringUtils.permutationRecursive("tom");
//        //StringUtils.findFactorial(3);
//        //StringUtils.fibonacci(8);
//
        //StringUtils.findWordsFromString("programmerit");
//        //StringUtils.getTokens("UserID\\d{3}12384\\d{3} , purchased 4 tickets for event A");
//
//        StringUtils.azra("def", "abcdefsunmd");
//        StringUtils.azra("dgf", "abcdefsunmd");
    }






    public static String[] getTokens(String str) {

        String[] tokens = str.split("# , ");
        for (String token : tokens) {
            System.out.println("token  :" + token);
        }
        return tokens;
    }

    public static String reverseAString(String stringToBeReversed) {
        if(stringToBeReversed == null) return null;
        System.out.println("String to be reversed "+stringToBeReversed);
        int strLength = stringToBeReversed.length();
        int last = strLength -1;
        char[] chars = stringToBeReversed.toCharArray();
        for (int i=0; i < strLength / 2; i++) {
            char ch = chars[i];
            chars[i] = chars[last-i];
            chars[last-i] = ch;
        }
        String reversedString = new String(chars);
        System.out.println("Reversed String "+reversedString);
        return reversedString;
    }


    @Override
    public String toString(){
        return "";
    }
    public static boolean isMirror(String str){
        assert str != null;
        int length = str.length();
        int midIdx = length /2 - 1;
        int reverseIdx = midIdx ;
        int fwdIdx = midIdx +1 ;
        char[] chars = str.toCharArray();
        char rChar ;
        char fChar ;
        while (reverseIdx >=0 && fwdIdx < length) {
            rChar = chars[reverseIdx--];
            fChar = chars[fwdIdx++];
            if(rChar != fChar) {
                System.out.println(str+" is not a Palindrome!");
                return false;
            }
        }
        System.out.println(str+" is a Palindrome!");
        return true;
    }

    public static int evaluatePrefixNotation(String prefixNotation) {
        char[] prefixNotationchars = prefixNotation.toCharArray();
        char c;
        Stack<Integer> workingStack = new Stack();
        for(int i=prefixNotationchars.length -1 ; i > 0; i--) {
            c = prefixNotationchars[i];
            if(isOperand(c)) {
                workingStack.push(Integer.valueOf(c));
            } else {
                if (isOperator(c)) {
                    List<Integer> operands = new ArrayList<>();
                    while(!workingStack.isEmpty()) {
                        operands.add(workingStack.pop());
                    }
                    int result = calculate(operands, c);
                    workingStack.push(result);
                } else {
                    assert false;
                }
            }
        }

        Integer result = workingStack.peek();
        System.out.println("Result is  "+result);
        return result;
    }


//  def bst_valid_recursive(root, lower_bound = MIN_INT, upper_bound = MAX_INT):
//    if (not root):
//    return True
//
//  if (root.value > upper_bound or root.value < lower_bound):
//    return False
//
//  return bst_valid_recursive(root.left, lower_bound, root.value) \
//  and bst_valid_recursive(root.right, root.value, upper_bound)

    public static int calculate(List<Integer> operands, char operator ) {
        int result = 0;
        if(operator == '+') {
            for(Integer operand : operands) {
                result +=  operand ;
            }
            return result;
        } else if(operator == '-'){
            for(Integer operand : operands) {
                result -=  operand ;
            }
            return result;
        } else if(operator == '*') {
            for(Integer operand : operands) {
                result -=  operand ;
            }
            return result;
        } else if(operator == '/'){
            for(Integer operand : operands) {
                result /=  operand ;
            }
            return result;
        } else {
            return 0;
        }


    }

    public int clearBit(int x, int kth) {
        return (x & ~(1 << kth));
    }

    private static boolean isOperand(char c){
        return Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER;
    }

    private static boolean isOperator(char c) {
        return Character.getType(c) == Character.MATH_SYMBOL;

    }

    public static int findMatchingClosingParenthesisPosition(String str, int parenIndex) {
        if(str == null || str.length() <= 1 ) {
            System.out.println("String must be non null and length is greater than 1.");
            return -1;
        }
        char[] chars = str.toCharArray();
        int idx = parenIndex + 1;
        int openParenthesisCount = 0;
        System.out.println("Parenthesis at "+parenIndex +" , is "+chars[parenIndex]);
        while(idx < str.length()) {
            if (isClosingParen(chars[idx])) {
                if(openParenthesisCount > 0 ) {
                    openParenthesisCount-- ;//matching with other opening parenthesis
                } else {
                    System.out.println("Matching paren found at "+idx);
                    return idx;
                }
            } else if(isOpeningParen(chars[idx])) {
                openParenthesisCount ++;
            }
            idx++;
        }
        System.out.println("No Matching paren found for the position of opening paren at "+parenIndex);
        return -1;
    }

    public static boolean isClosingParen(char c) {
        if(c == ')')  return true;
        return false;
    }

    public static boolean isOpeningParen(char c) {
        if(c == '(')  return true;
        return false;
    }

    public static Set<String> permutation (String str) {
        System.out.print(str);
        char[] chars = str.toCharArray();
        Set<String> permutations = new HashSet<>();
        recHelpPermute(chars,0);
        return permutations;
    }

    private static void recHelpPermute(char[] c , int k) {
        if(k == c.length) {
            System.out.print(" , " + new String(c));
            //return c;
        } else {
            for(int i = k; i < c.length; i++) {
                //if(i != k) {
                swapChar(c, k, i);
                recHelpPermute(c, k + 1);
                swapChar(c, k, i);
                //}
            }
        }
    }

    //a number is a sum of previous 2 numbers
    public static long fibonacci( long n )
    { //0,1,1,2,3,5
        if ( n == 0 || n == 1 )
            return n;
        else
            n = fibonacci( n - 1 ) + fibonacci( n - 2 );
        System.out.println(" , "+n);
        return n;
    }


    //the product of an integer and all the integers below it; 1 * 2 * 3 * 4 = 24 =fact(4);
    public static int findFactorial (int number)
    {
        if (( number == 1) || (number == 0))
            return 1;
        else
            return (number * findFactorial (number-1)); //4 * (4 -1) * (3 -1) * (2-1) = 4 * 3 * 2 * 1
    }


    //
//  private static void swap(String str, char[] chars, Set<String> permutations, int i) {
//    for(int j = 0; j < str.length() ; j++) {
//      if(i != j) {
//        String s = swapChar(chars, i, j);
//        boolean added  = permutations.add(s);
//        if(added) {
//          System.out.print(" , " + s);
//        }
//      }
//    }
//  }
    public static Set<String> permutationNonRecursive(String str) {
        System.out.print(str);
        char[] chars = str.toCharArray();
        Set<String> permutations = new HashSet<>();
        for(int i=0; i < str.length()  ; i++) {
            for(int j = 0; j < str.length() ; j++) {
                if(i != j) {
                    swapChar(chars, i, j);
                    permutations.add(new String(chars));
                }
            }
        }
        return permutations;
    }
    public static Set<String> permutationRecursive(String str) {
        System.out.print(str);
        char[] chars = str.toCharArray();
        Set<String> permutations = new HashSet<>();
        permutationRecursive(chars, 0, permutations);
        for (String permutation : permutations) {
            System.out.print(permutation + " \t ");
        }

        return permutations;
    }


    public static void permutationRecursive(char[] chars, int j, Set<String> permutations) {
        if(j >= chars.length) {
            return;
        } else {
            permutationRecursive(chars, j +1,permutations);
            for (int i = 0 ; i < chars.length; i++) {
                if(i != j ) {
                    swapChar(chars, i, j);
                    permutations.add(new String(chars));
                }
            }
        }
        return;
    }

    public static void findWordsFromString(String str) {
        Set<String> words = new HashSet<>();
        findWordsFromString(str,0, words);
        System.out.println(" ");
        System.out.println("Valid words in string '" + str+"'");
        for (String word : words) {
            System.out.print("  " + word);
        }
    }

    static void azra(String regix, String actual){
        Pattern p = Pattern.compile(regix);
        System.out.println(p.matcher(actual).find());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //br.readLine();
    }

    public static void findWordsFromString(String str,int index, Set<String> words) {
        if(index > str.length()) {
            return;
        }
        findWordsFromString(str,index+1, words);
        for(int i = 0 ; i < index; i++) {
            String sub = str.substring(i, index);
            if(isValidWord(sub)) {
                words.add(sub);
            }
        }
    }

    public static boolean isValidWord(String str) {
        Map<String, String> dictionary = new HashMap();
        dictionary.put("pro","mea");
        dictionary.put("program","mea");
        dictionary.put("programmer","mea");
        dictionary.put("gram","mea");
        dictionary.put("grammer","mea");
        dictionary.put("am","mea");
        dictionary.put("merit","mea");
        dictionary.put("it","mea");
        dictionary.put("ram","mea");
        dictionary.put("i","mea");
        return dictionary.containsKey(str);
    }


    public static char[] swapChar(char[] c, int i , int j ) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }
}
