package prog;


import java.io.*;
import java.util.stream.Collectors;

/**
 * Created by arabbani on 10/24/16.
 */
public class JavaEight {


    public static String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
