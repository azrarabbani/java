package prog;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by arabbani on 8/17/16.
 */

public class CallablePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public int[][] call() throws Exception {
                int[][] array = new int[5][];
                for (int i = 0; i < array.length; i++) {
                    array[i] = new int[]{5 * i, 5 * i + 1, 5 * i + 2, 5 * i + 3};
                }

                return array;
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<int[][]> result = service.submit(callable);

        int[][] intArray = result.get();//it will be blocked until results are returned
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(Arrays.toString(intArray[i]));
        }






        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        for (String word: args) {
            Callable<Integer> calble = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(calble);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        System.exit(sum);
    }



        public static class WordLengthCallable
                implements Callable {
            private String word;
            public WordLengthCallable(String word) {
                this.word = word;
            }
            public Integer call() {
                return Integer.valueOf(word.length());
            }
        }



}