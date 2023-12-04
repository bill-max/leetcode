import java.util.Scanner;

class Solution {
    public int addab(int a, int b) {
        int c = Math.max(a, b);
        return a + b;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while (cin.hasNextInt()) {
            a = cin.nextInt();
            b = cin.nextInt();
            Solution s = new Solution();
            int c = s.addab(a, b);
            System.out.println(c);
        }
    }
}
