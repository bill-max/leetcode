import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;

        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1, -1};
    }
}
