package prog.observer;

/**
 * Created by arabbani on 11/24/16.
 */
public class BitUtils {

    private static int BITS_IN_INTEGER = 32;

    public static void rotateClockwise(int x, int n){
      //return (x >> n ) ||
    }

    public static void convertToBinary(int x){
        StringBuilder sb = new StringBuilder();
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toHexString(x));
        while(x > 0) {
          byte b = (byte) (x % 2);
            sb.append(b);
            x = x / 2;
        }
        System.out.print(sb.reverse());
    }

    public static void main(String[] args){
        convertToBinary(4);
    }
}
