package huawei;

import java.util.Scanner;

public class Random_2 {
    public static void main(String[] args) {
        int[] ans = new int[500];
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int idx = in.nextInt() - 1;
            ans[idx]++;
        }
        for (int i = 0; i < 500; i++) {
            if (ans[i] >= 1)
                System.out.println(i + 1);
        }
    }
}
