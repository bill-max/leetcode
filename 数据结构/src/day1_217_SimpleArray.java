import java.util.Arrays;

/**
 * @author 李建彤
 */
public class day1_217_SimpleArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean b = containsDuplicate(nums);
        System.out.printf(String.valueOf(b));

    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i< nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}

