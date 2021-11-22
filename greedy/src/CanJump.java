import java.util.HashSet;
import java.util.Set;

public class CanJump {
    public boolean canJump(int[] nums) {
        int curAim = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int maxditance = nums[i] + i;
            if (maxditance >= curAim) {
                curAim = i;
            }
        }
        return curAim == 0 ? true : false;
    }
}
