package prog;

import java.lang.reflect.Method;

/**
 * Created by arabbani on 11/23/16.
 */
public class Reflection {


    public static void main(String args[])
    {
        try {
            Class cls = Class.forName("prog.BSTUtil");

            Method methlist[]
                    = cls.getDeclaredMethods();

            for (int i = 0; i < methlist.length;  i++) {
                Method m = methlist[i];
                System.out.println("method " + m.getName());
                System.out.println("decl class = " + m.getModifiers());

                Class pvec[] = m.getParameterTypes();


                for (int j = 0; j < pvec.length; j++)
                {
                    System.out.println("param #" + j + " " + pvec[j]);
                }

                Class evec[] = m.getExceptionTypes();
                for (int j = 0; j < evec.length; j++) {
                    System.out.println("exc #" + j + " " + evec[j]);
                }
                System.out.println("return type = " +  m.getReturnType());
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}
