public class Day13_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        //纵向比较
        /*if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];*/

        //
        if (strs.length==0)
            return "";
        String ans = strs[0];
        for (String str : strs) {
            int i = 0;
            while (i < ans.length()&&i<str.length()) {
                if (str.charAt(i) != ans.charAt(i)) {
                    break;
                }
                i++;
            }
            ans = str.substring(0, i);
        }
        return ans;
    }
}
