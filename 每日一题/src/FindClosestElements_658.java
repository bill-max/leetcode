import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestElements_658 {
    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }
            list.sort((a, b) -> {
                if (Math.abs(a - x) != Math.abs(b - x)) {
                    return Math.abs(a - x) - Math.abs(b - x);
                } else {
                    return a - b;
                }
            });
            List<Integer> ans = list.subList(0, k);
            Collections.sort(ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 6));
    }
}
