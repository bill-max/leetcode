import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinNumberOfHours_2383 {
    static class Solution {
        /**
         * [1,4,3,2]  [2,6,3,1]   5  3
         * 4 3 2    6 3 1         4  5  +1  +2
         * 3 2      3 1           1  13 +3
         * 2        1             1  14 +2
         */
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int sum = 0;
            for (int e : energy) {
                sum += e;
            }
            int trainingHours = initialEnergy > sum ? 0 : sum + 1 - initialEnergy;
            for (int e : experience) {
                if (initialExperience <= e) {
                    trainingHours += 1 + (e - initialExperience);
                    initialExperience = 2 * e + 1;
                } else {
                    initialExperience += e;
                }
            }
            return trainingHours;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfHours(5, 1, new int[]{1, 4}, new int[]{1, 3, 6}));
    }
}
