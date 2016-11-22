package prog;

/**
 * Created by arabbani on 11/14/16.
 */
public class InterleavedString {


    public static boolean isInterleavedString(String a, String b, String interleaved) {
        if (a == null || b == null || interleaved == null) {
            return false;
        }

        if (a.length() + b.length() != interleaved.length()) {
            return false;
        }
        int i = 0;
        int countA = 0;
        int countB = 0;
        char[] iChar = interleaved.toCharArray();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        while (i < interleaved.length()) {
            if (countA < a.length() && iChar[i] == aChar[countA]) {
                countA++;
            } else if (countB < b.length() && iChar[i] == bChar[countB]) {
                countB++;
            } else {
                return false;
            }
            i++;
        }
        return (countA == a.length() &&
                countB == b.length());


    }

    public static void main(String[] args) {
        String c = "abcxydez";
        String a = "abcde";
        String b = "xyz";

        System.out.println("is interleaved " + isInterleavedString(a, b, c));

        c = "abcxydez";
        a = "abcde";
        b = "eyz";


        System.out.println("is interleaved " + isInterleavedString(a, b, c));


        c = "abcxydez";
        a = "abcdx";
        b = "eyz";


        System.out.println("is interleaved " + isInterleavedString(a, b, c));
    }


}