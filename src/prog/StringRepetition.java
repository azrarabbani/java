package prog;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by arabbani on 11/22/16.
 */
public class StringRepetition {

    public static void numberOfTimesStringQueried(String[] str, String[] queries){
        List<String> stringList = Arrays.asList(str);
        Collections.sort(stringList);
        for(int i = 0 ; i < queries.length; i++) {
            int index = Collections.binarySearch(stringList, queries[i]);
            int count = 0;
            if(index >= 0) {
                count = 1;
                int j = index + 1;
                while (j < stringList.size() && stringList.get(j).equals(queries[i])) {
                    count++;
                    j++;
                }
            }
            System.out.println(count);
        }

    }

//    public static boolean matchPattern(String str, String pattern){
//        Pattern p = Pattern.compile(pattern);
//        p.matcher(str).matches();
//
//    }
//tom, mot, mto,otm,

    public static Set<String> permutationRecursive(char[] c, int index, Set<String> p){
        if(index >= c.length) {
            return p;
        }
        for(int i = 0 ; i < c.length; i++){ //tom: otm
            if(i!=index) {
                char[] cc = swapchar(c, i ,index);
                p.add(new String(cc));
                permutationRecursive(c, index + 1, p);

            }
        }
        return p;
    }

    static char[] swapchar(char[] c , int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }

    // num << inidcates multiple by 2 times the number appear after operator
    // num >> indicates divide by 2 times the number appear after operator 8 >> 1 = 4 8 /2 one time

    public static boolean isAnagram(String s, String s1 ){
        int[] letters = new int[1 << 8]; //2*2*2*2*2*2*2*2=256 2 multiply 8 times; because we need to deal with characters
        for(char c : s.toCharArray()){
            letters[c]++;//a=97
        }
        for(char c : s1.toCharArray()){
            letters[c]--;
        }
        for(int i : letters){
            if(i != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        //while((num = in.nextInt()) <= 0);
//        String[] str = new String[num];
//        for(int i =0; i < num; i++){
//            str[i] = in.nextLine();
//        }
//
//        int numQ = in.nextInt();
//        //while((numQ = in.nextInt()) <= 0);
//        String[] strQ = new String[numQ];
//        for(int i =0; i < numQ; i++){
//            strQ[i] = in.nextLine();
//        }
//        numberOfTimesStringQueried(str,strQ);

        char[] c = {'t','o','m'};
        //Set<String> d = permutationRecursive(c, 0, new HashSet<>());
        System.out.println("d"+isAnagram("abab", "bbaa"));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
