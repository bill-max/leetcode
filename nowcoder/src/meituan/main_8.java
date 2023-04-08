package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class main_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] edge = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edge[i][0] = in.nextInt();
            edge[i][1] = in.nextInt();
        }
        System.out.println(Arrays.deepToString(edge));
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(color));
        int q;
        while (in.hasNextInt()) {
            q = in.nextInt();
            System.out.println("q===" + q);
        }
    }
}
