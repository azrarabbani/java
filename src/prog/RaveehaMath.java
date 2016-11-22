package prog;

/**
 * Created by arabbani on 11/23/15.
 */
public class RaveehaMath {

    public static  int addNumbers(int[] intArray) {
         int sum=0;
        for(int  i=0; i<intArray.length; i++) {
            sum = sum + intArray[i];
        }
        return sum;

    }

   public static  void printPonySymbol(String name) {
       if("Rarity".equals(name)) {
           System.out.println("Rarity Symbol is *** ");
       } else if("AppleJack".equals(name)) {
           System.out.println("AppleJack Symbol is @@@ ");
       } else if("AppleBloom".equals(name)) {
           System.out.println("AppleBloom Symbol is % ");
       } else  if("PrincessCadance".equals(name)) {
           System.out.println("PrincessCadance Symbol is <3");
       }
       else {
           System.out.println("I don't know symbol of "+name);
       }
   }


//        RaveehaMath.addNumbers(num);
    public static void main(String[] args) {
        int[] numbers = new int[] {12,4,6,7,9,10,4,28,445};
        int sumUp=RaveehaMath.addNumbers(numbers);
        //int subtract = RaveehaMath
        System.out.println("Sum is = "+sumUp);
//        double num = 6.9;
        RaveehaMath.printPonySymbol("AppleJack");
        RaveehaMath.printPonySymbol("Rarity");
        RaveehaMath.printPonySymbol("AppleBloom");
        RaveehaMath.printPonySymbol("PrincessCadance");

    }
}
