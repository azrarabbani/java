package prog;

/**
 * Created by arabbani on 10/25/16.
 */
public class ArraysUtils{

    private static final int MAX_INITIAL_SIZE = 40;
    private static final int GROWTH_FACTOR= 2;
    //ArrayList<T>[] myArray = new ArraysUtils<>();

   Integer[] numbers = new Integer[MAX_INITIAL_SIZE];
    private int currentIndex = 0;

    public ArraysUtils(){
        numbers = new Integer[MAX_INITIAL_SIZE];
    }

    public ArraysUtils(int initialCapacity) {
        numbers = new Integer[initialCapacity];
    }

    public void add(Integer in) {
        if(currentIndex >= numbers.length) {
            regrowArray();
        }
        numbers[currentIndex++] = in;
    }


    public void addAtIndex(Integer in, int atIndex) {
        if(atIndex >= numbers.length) {
            regrowArray();
        }
        numbers[atIndex] = in;
    }


    private void regrowArray() {
        Integer[] numbers2 = new Integer[numbers.length * GROWTH_FACTOR];
        int index = 0;
        for(int i : numbers) {
            numbers2[index++] = i;
        }
        numbers = numbers2;
    }



}
