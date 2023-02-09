package huawei;

import java.util.Scanner;

public class Hex2Ten_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        int ans = Integer.parseInt(s.substring(2),16);
        System.out.println(ans);
    }
}
