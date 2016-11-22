package prog;

import java.util.Calendar;

/**
 * Created by arabbani on 10/24/16.
 */
public class DateUtil {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        cal.set(Calendar.MONTH, 8);
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(cal.getActualMinimum(Calendar.DAY_OF_MONTH));
    }


}

