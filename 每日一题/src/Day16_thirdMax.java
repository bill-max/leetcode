import java.util.ArrayList;
import java.util.Arrays;

public class Day16_thirdMax {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //第三大的数
        int k=3;
        int count=1;
        for (int i = n-2; i >=0; i--) {
            if (nums[i] != nums[i+1]) {
                count++;
            }
            if (count==k){
                return nums[i];
            }
        }
        return nums[n - 1];
    }
}
