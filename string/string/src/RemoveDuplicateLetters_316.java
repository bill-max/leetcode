import java.util.*;

public class RemoveDuplicateLetters_316 {
    static class Solution {
        /**
         * 核心思路：找出最小的满足 s[i]>s[i+1]的下标 i，并去除字符 s[i]
         * @param s
         * @return
         */
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];//标记当前元素是否在栈中
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;//记录元素出现次数
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!vis[ch - 'a']) {
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {//栈不为空，且栈顶元素大于ch 即字典逆序
                        if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {//如果 sb的最后一个字符 出现过
                            vis[sb.charAt(sb.length() - 1) - 'a'] = false;//添加删除标记
                            sb.deleteCharAt(sb.length() - 1);//弹出最后一个字符
                        } else {
                            break;
                        }
                    }
                    vis[ch - 'a'] = true;//添加标记
                    sb.append(ch);//ch 入栈
                }
                num[ch - 'a'] -= 1;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
    }
}
