import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String at = s.split(",")[0];
        String bt = s.split(",")[1];
        String a = at.substring(1, at.length() - 1);
        String b = bt.substring(1, bt.length() - 1);
    }
    public String getTypeOfMobilePhoneNumber (String mobilePhoneNumber) {
        // write code here
        String x1 = "Invalid";
        int start = 0;
        while (mobilePhoneNumber.charAt(start) == '0') {
            start++;
        }
        mobilePhoneNumber = mobilePhoneNumber.substring(start);
        String part;
        if (mobilePhoneNumber.length() == 13) {
            part = mobilePhoneNumber.substring(3, 7);
        } else if (mobilePhoneNumber.length() == 11) {
            part = mobilePhoneNumber.substring(0, 4);
        } else {
            return x1;
        }
        if (part.startsWith("134")) {

        }

    }

}
