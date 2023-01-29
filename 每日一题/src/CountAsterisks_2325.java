public class CountAsterisks_2325 {
    static class Solution {
        //统计 *
        public int countAsterisks(String s) {
            int count = 0;
            boolean flag = false;
            for (char ch : s.toCharArray()) {
                if (ch == '*' && flag == false) {
                    count++;
                }
                if (ch == '|') {
                    flag = !flag;
                }
            }
            return count;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }
}
