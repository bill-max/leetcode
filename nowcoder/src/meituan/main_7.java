package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class main_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(p));
    }
}
