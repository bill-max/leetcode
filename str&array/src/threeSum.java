import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    /**
     * 15-三数之和
     * 排序加双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int l,r;
        for (int i = 0; i < nums.length-2; ++i) {
            int cur = nums[i];
            //cur>0,则后面不可能有三元组=0
            if (cur > 0) {
                break;
            }
            //去重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int left = nums[l];
                int rigt = nums[r];
                int sum = cur + left + rigt;
                if (sum== 0) {
                    ans.add(Arrays.asList(cur, left, rigt));
                    //去重
                    while (l < r && left == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && rigt == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return ans;
    }
}
