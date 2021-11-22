import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Day49_MaxProduct {
    public int maxProduct(String[] words) {
        int n = words.length,idx=0;
        //标记数组
        int[] masks = new int[n];
        for (String str : words) {
            //用一个整数代表个字符出现的次数
            int t=0;
            //遍历字符串
            for (int i = 0; i < str.length(); i++) {
                int u= str.charAt(i) - 'a';
                //只需要统计是否出现过该字符，出现，则当前位为1，后面再出现，与该结果相或--》保证只要出现过就为1
                t = t | (1 << u);
            }
            masks[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
