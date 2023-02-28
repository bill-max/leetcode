import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSimilarItems_2363 {
    static class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Arrays.sort(items1, Comparator.comparingInt(o -> o[0]));
            Arrays.sort(items2, Comparator.comparingInt(o -> o[0]));
            List<List<Integer>> ans = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < items1.length && j < items2.length) {
                int finalI = i;
                int finalJ = j;
                if (items1[i][0] == items2[j][0]) {
                    ans.add(new ArrayList<>() {{
                        add(items1[finalI][0]);
                        add(items1[finalI][1] + items2[finalJ][1]);
                    }});
                    i++;
                    j++;
                } else if (items1[i][0] < items2[j][0]) {
                    ans.add(new ArrayList<>() {{
                        add(items1[finalI][0]);
                        add(items1[finalI][1]);
                    }});
                    i++;
                } else {
                    ans.add(new ArrayList<>() {{
                        add(items2[finalJ][0]);
                        add(items2[finalJ][1]);
                    }});
                    j++;
                }
            }
            while (i < items1.length) {
                int finalI1 = i;
                ans.add(new ArrayList<>() {{
                    add(items1[finalI1][0]);
                    add(items1[finalI1][1]);
                }});
                i++;
            }
            while (j < items2.length) {
                int finalJ = j;
                ans.add(new ArrayList<>() {{
                    add(items2[finalJ][0]);
                    add(items2[finalJ][1]);
                }});
                j++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
