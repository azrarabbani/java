package prog;


import java.io.*;
import java.util.*;

/**
 * Created by arabbani on 10/25/16.
 */
public class IOUtils {
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));
        } catch(Exception e){

        }

        //Autoclosable
        try(FileInputStream fis = new FileInputStream(new File(""));
            BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
        ) {

        } catch(Exception e){

        }
            Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

       //bf.l
    }
}
