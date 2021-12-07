import java.util.*;

public class test {
    //合并区间，重写函数，将每个区间按照左端点的大小排序
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //结果集
        List<int[]> res = new ArrayList<>();
        //重写数组排序函数
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size()==0||res.get(res.size()-1)[1]<L){
                res.add(new int[]{L, R});
            }else {
                int n = res.size();
                int lastR = res.get(n - 1)[1];
                res.get(n - 1)[1] = Math.max(lastR, R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
