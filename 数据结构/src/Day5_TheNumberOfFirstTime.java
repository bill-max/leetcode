import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 李建彤
 */
public class Day5_TheNumberOfFirstTime {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int result=singleNumber(nums);
        System.out.println(result);
    }
    public static int singleNumber(int[] nums){
        //利用hashSet
/*        int n=nums.length;
        HashSet result=new HashSet<Integer>();
        for (int i=0;i<n;i++){
            if(!result.add(nums[i])){
                result.remove(nums[i]);
            }
        }
        return  (int)result.iterator().next();*/
        //利用异或运算
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
