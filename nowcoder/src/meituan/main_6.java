package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class main_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(p));
    }
}
