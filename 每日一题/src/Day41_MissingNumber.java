import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day41_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
        /*//异或和
        int xor=0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        return xor;*/
    }
}
