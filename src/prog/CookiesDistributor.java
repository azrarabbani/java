package prog;

import java.util.*;

public class CookiesDistributor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nog = in.nextInt();
        int noc = in.nextInt();
        validate(nog, noc);
        CookiesDistributor dc = new CookiesDistributor();
        dc.distribute(nog, noc);
    }


    public  void distribute(int nog, int noc) {
        if(nog == noc) {
            System.out.println(0);
        }
        else if(noc < nog) {
            int diff;
            if(noc < 1) {
                diff =  nog;
            } else {
                diff = nog - Math.abs(noc);
            }
            System.out.println(diff);
        } else {
            int remainingCookies = noc;
            remainingCookies = Math.abs(nog - remainingCookies);
            distribute(nog, remainingCookies);
        }
    }

    public static void validate (int nog, int noc) throws IllegalArgumentException {
        if(nog < 1 ||
                noc > (int) Math.pow(10, 9) ) {
            throw new IllegalArgumentException("Valid range : 1 <= number Of guests , number Of cookies <= 10 ^9 ");
        }

    }
}
