public class Kmp {
    /**
     * 给你两个字符串haystack 和 needle
     * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
     * 如果不存在，则返回 -1 。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0) {
            return 0;
        }

        int[] next = getNext(needle.toCharArray());
        for (int i = 0, j = 0; i < haystack.length();) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     * next数组的求取
     */
    int[] getNext(char[] T) {
        int[] next = new int[T.length];
        //双指针，i应当小于模式串长度
        for (int i = 1, j = 0; i < T.length; i++) {
            //当两个字符不相等时，j根据next的值向前回溯
            while (j > 0 && T[i] != T[j]) {
                j = next[j - 1];
            }
            if (T[i] == T[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
