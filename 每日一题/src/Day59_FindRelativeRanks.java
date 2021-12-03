import java.util.*;

public class Day59_FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; ++i) {
            map.put(score[i], i);
        }
        String[] ans = new String[score.length];
        Arrays.sort(score);
        for (int i = score.length - 1; i >= 0; i--) {
            int count = map.get(score[i]);
            if (i == score.length-1) {
                ans[count] = "Gold Medal";
            } else if (i == score.length-2) {
                ans[count] = "Silver Medal";
            } else if (i == score.length-3) {
                ans[count] = "Bronze Medal";
            } else {
                ans[count] = Integer.toString(score.length-i);
            }
        }
        return ans;
    }
}
