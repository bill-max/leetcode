import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeArrays {
    class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            List<int[]> ans = new ArrayList<>();
            int i = 0, j = 0;
            int idx = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i][0] == nums2[j][0]) {
                    ans.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                    i++;
                    j++;
                } else if (nums1[i][0] > nums2[j][0]) {
                    ans.add(new int[]{nums2[j][0], nums2[j][1]});
                    j++;
                } else {
                    ans.add(new int[]{nums1[i][0], nums1[i][1]});
                    i++;
                }
//                System.out.println(Arrays.toString(ans.get(idx++)));
            }
            while (i < nums1.length) {
                ans.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            }
            while (j < nums2.length) {
                ans.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
            return ans.toArray(new int[0][]);
        }
    }
}
