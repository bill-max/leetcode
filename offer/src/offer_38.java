import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer_38 {
    static class Solution {
        /**
         * 全排列
         * 回溯
         */
        List<String> rec;
        boolean[] vis;

        public String[] permutation(String s) {
            int n = s.length();
            rec = new ArrayList<String>();
            vis = new boolean[n];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            dfs(arr, 0, new StringBuilder());
            return rec.toArray(new String[0]);
        }

        public void dfs(char[] arr, int cur, StringBuilder stringBuilder) {
            if (cur == arr.length) {
                rec.add(stringBuilder.toString());
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                //保证当前字符没有被用过
                //保证当前字符不是重复字符
                if (vis[i] || (i > 0 && !vis[i - 1] && arr[i - 1] == arr[i])) {
                    continue;
                }
                vis[i] = true;
                stringBuilder.append(arr[i]);
                dfs(arr, cur + 1,stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                vis[i] = false;
            }
        }
    }
}
