import java.util.*;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //将每个区间按照左端点的大小排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        //Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });*/

        List<int[]> merged = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                int n = merged.size();
                //结果集中最后一个区间右端点值
                int lastR = merged.get(n - 1)[1];
                merged.get(n - 1)[1] = Math.max(lastR, R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
