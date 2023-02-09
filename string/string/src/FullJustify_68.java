import java.util.ArrayList;
import java.util.List;

public class FullJustify_68 {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            StringBuilder sb = new StringBuilder();
            List<String> ans = new ArrayList<>();
            int[] num = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                num[i] = words[i].length();
            }
            int cur = num[0];
            int countWord = 1;
            //添加前几行 两端对齐
            for (int i = 1; i < words.length; i++) {
                if (cur + num[i] + countWord - 1 >= maxWidth) {
                    int countSpace = maxWidth - cur;//总共空格数
                    int countS = countWord == 1 ? 1 : countWord - 1; //间隔数
                    int space = countSpace / countS; //平均空格数
                    int less = countSpace % countS;  //多出来的空格 匀到前面的空格上去
                    while (countWord > 0 && sb.length() < maxWidth) {
                        sb.append(words[i - countWord]).append(" ".repeat(Math.max(0, space)));
                        if (less-- > 0) {
                            sb.append(" ");
                        }
                        countWord--;
                    }
                    ans.add(sb.substring(0, maxWidth).toString());
                    cur = num[i];
                    countWord = 1;
                    sb = new StringBuilder();
                } else {
                    countWord++;
                    cur += num[i];
                }
            }
            //添加最后一行  左对齐
            sb = new StringBuilder();
            while (countWord > 0) {
                sb.append(words[words.length - countWord]).append(" ");
                countWord--;
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            ans.add(sb.substring(0,maxWidth));
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
