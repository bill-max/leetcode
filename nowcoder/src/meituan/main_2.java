package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int idx = 0;
        while (in.hasNextInt()) {
            nums[idx++] = in.nextInt();
            if (idx == n) {
                break;
            }
        }
//        System.out.println(Arrays.toString(nums));
        int aim = (1 + n) * n / 2;
//        System.out.println(aim);
        int ans = 0;
        int res = 0;
        for (int num : nums) {
            if (num < 1) {
                res += (1 - num);
                num = 1;
            }
            ans += num;
        }
        res += Math.abs(ans - aim);
//        System.out.println(ans);
        System.out.println(res);

    }
}
