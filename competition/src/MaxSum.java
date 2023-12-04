import java.util.*;

public class MaxSum {
    public int maxSum(int[] nums) {
        List<Queue<Integer>> ma = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            ma.add(new PriorityQueue<>(10, (o1, o2) -> o2 - o1));
        }
        for (int num : nums) {
            ma.get(check(num)).add(num);
        }
        int ans = -1;
        for (Queue<Integer> q : ma) {
            if (q.size() < 2) continue;
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += q.poll();
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    private int check(int num) {
        int max = 0;
        while (num != 0) {
            max = Math.max(max, num % 10);
            num /= 10;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSum().maxSum(new int[]{84, 91, 18, 59, 27, 9, 81, 33, 17, 58}));
    }

}
