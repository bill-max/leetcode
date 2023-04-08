package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class score_1 {
    public static void main(String[] args) {
        int n, x, y;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        int[] people = new int[n];
        int i = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            people[i++] = in.nextInt();
            if (i == n) {
                break;
            }
        }
        if (n < 2 * x || n > 2 * y) {
            System.out.println(-1);
        }
        Arrays.sort(people);
        for (int j = 0; j < n; j++) {
            if (j + 1 >= x && j + 1 <= y && n - j - 1 <= y && n - j - 1 >= x) {
                System.out.println(people[j]);
                break;
            }
        }
        System.out.println(Arrays.toString(people));
    }
}
