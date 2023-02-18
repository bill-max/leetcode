import java.util.Arrays;

public class Merge_88 {
    static class Solution {
        /**
         * 1,2,3,0,0,0   2,5,6
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int ptr1 = 0;
            int ptr2 = 0;
            int temp = m;
            while (ptr1 < m + n && ptr2 < n) {
                if (nums1[ptr1] <= nums2[ptr2]) {
                    if (nums1[ptr1] == 0 && ptr1 > m + ptr2) {
                        nums1[ptr1] = nums2[ptr2++];
                    }
                    ptr1++;
                } else {
                    if (temp - ptr1 >= 0)
                        System.arraycopy(nums1, ptr1, nums1, ptr1 + 1, temp - ptr1);
                    nums1[ptr1++] = nums2[ptr2++];
                    temp++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 0, 0, 0};
        new Solution().merge(nums, 1, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(nums));
    }
}
