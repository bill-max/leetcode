package meituan;

import java.util.Scanner;

public class main_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, a, b;
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            int[] cakes = new int[m];
            for (int i = 0; i < m; i++) {
                cakes[i] = in.nextInt();
            }
            solve(n, m, a, b, cakes);
        }
    }

    private static void solve(int n, int m, int a, int b, int[] cakes) {
        if (n - m < 2) {
            System.out.println("NO");
            return;
        }
        int minCake = Integer.MAX_VALUE;
        int maxCake = Integer.MIN_VALUE;
        for (int cake : cakes) {
            minCake = Math.min(minCake, cake);
            maxCake = Math.max(maxCake, cake);
        }
        if (minCake < Math.min(a, b) || maxCake > Math.max(a, b)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}
