import java.util.Arrays;
import java.util.stream.Collectors;

public class offer_11 {
    static class Solution {
        /**
         * 查找数组的最小值
         * 该数组满足规律：为一个升序数组旋转过后的值，数组可能存在重复元素
         *
         * @param numbers
         * @return
         */
        public int minArray2(int[] numbers) {
            int min = Integer.MAX_VALUE;
            for (int num : numbers) {
                min = Math.min(min, num);
            }
            return min;
        }

        //java stream
        public int minArray3(int[] numbers) {
            return Arrays.stream(numbers).boxed().min(Integer::compare).get();
        }

        /**
         * 二分
         * 3 4 5 1 2
         * 3 4 5 1 3
         *
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            int l = 0, r = numbers.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] > numbers[r]) {
                    l = mid + 1;
                } else if (numbers[mid] < numbers[r]) {
                    r = mid;
                } else {
                    r--;
                }
            }
            return numbers[l];
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
