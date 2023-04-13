import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoSum_2_6 {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < numbers.length - 1; i++) {
                int num = find(numbers, i + 1, target - numbers[i]);
                if (num != -1) {
                    ans.add(i);
                    ans.add(num);
                    break;
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        private int find(int[] numbers, int i, int aim) {
            int l = i, r = numbers.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (numbers[mid] == aim) return mid;
                else if (numbers[mid] > aim) r = mid;
                else l = mid + 1;
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{1, 2, 3, 6, 10}, 7)));
    }
}
