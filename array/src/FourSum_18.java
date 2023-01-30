import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum_18 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length <= 3) {
                return ans;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                        continue;
                    }
                    int aim = target - nums[i] - nums[j];
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        if (nums[l] + nums[r] < aim) {
                            l++;
                        } else if (nums[l] + nums[r] > aim) {
                            r--;
                        } else {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) l++;
                            l++;
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            r--;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
