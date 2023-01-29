import java.util.Arrays;

public class FindMedianSortedArrays_4 {
    static class Solution {
        /**
         * time O(m+n)  space O(m+n)
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[] num = new int[m + n];
            int l = 0, r = 0;
            int i = 0;
            while (l < m && r < n) {
                if (nums1[l] < nums2[r]) {
                    num[i++] = nums1[l++];
                } else {
                    num[i++] = nums2[r++];
                }
            }
            while (l < m) {
                num[i++] = nums1[l++];
            }
            while (r < n) {
                num[i++] = nums2[r++];
            }
            System.out.println(Arrays.toString(num));
            return (m + n) % 2 == 0 ? (num[(m + n) / 2] + num[(m + n) / 2 - 1]) / 2.0 : num[(m + n) / 2];
        }

        /**
         * 优化空间
         */
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int len = m + n;
            int left = -1, right = -1;
            int aStart = 0, bStart = 0;
            for (int i = 0; i <= len / 2; i++) {
                left = right;
                if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                    right = nums1[aStart++];
                } else {
                    right = nums2[bStart++];
                }
            }
            if ((len & 1) == 0)
                return (left + right) / 2.0;
            else
                return right;
        }

        /**
         * 二分
         */
        public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
            if (len1 == 0) return nums2[start2 + k - 1];

            if (k == 1) return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;

            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            } else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
