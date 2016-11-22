package prog;

import java.util.stream.*;
/**
 * Created by arabbani on 10/26/16.
 */
public class CharacterUtil {


    public static int encodeString(String str, int index, int stringId ) {

        if(index >= str.length()) {
            return stringId;
        }
        stringId += getCharacterId(str, index);
        index++;
        return encodeString(str, index , stringId);

    }


    public static int encodedStringUsingStream(CharSequence str ) {
        int encoded= IntStream.range(0, str.length())
                              .mapToObj(k -> getCharacterId(str, k))
                              .reduce(0, Integer::sum);
        return encoded;


    }


    private static Integer getCharacterId(CharSequence str, int index) {
        int previousCharCodePoint = 0;
        if(index > 0 ) {
            previousCharCodePoint = Character.codePointAt(str, index- 1);
        }
        int currentCharCodePoint = Character.codePointAt(str, index);
        if(previousCharCodePoint == currentCharCodePoint) {
            return currentCharCodePoint;
        } else {
            return previousCharCodePoint + currentCharCodePoint;
        }


    }

    public static void main(String[] args) {
        String idToConvert = "abbknlksnflflnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsflnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsflnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsflnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsflnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsdlfnslknflnsdlfnsldfnlsdnflsndflnsdnjkbkjbkbkbkttttttttteeeejjjjjjjjjjjjjejjjjjllllllllllllllababsbsjssbsbsshsjsjsjsjsjsjsjsjsjsjsjbkbc";
        long startTime = System.currentTimeMillis();
        String encodedStr = encodeString(idToConvert, 0, 0) + "";
		System.out.println(encodedStr+" by Recursive -> took " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
	    encodedStr =  encodedStringUsingStream(idToConvert) + "";
	    System.out.println(encodedStr +" by Stream -> took " + (System.currentTimeMillis() - startTime));




    }


}
