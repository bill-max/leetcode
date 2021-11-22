import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day34_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] res=new int[nums1.length];

        for (int i = 0; i < n1; i++) {
            res[i] = -1;
            int index = search(nums2, nums1[i]);
            for (int j = index+1; j < n2; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    public int search(int[] num, int key) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
