public class Day58_MaxPower {
    /**
     *  start-->
     *  l e e t c o d e
     *  j i
     *  next-->
     *  l e e t c o d e
     *    j i
     *  next-->
     *  l e e t c o d e
     *    j   i
     *  --->ans=i-j=2
     *  --->
     *  l e e t c o d e
     *        j i
     * @param s
     * @return
     */
    public int maxPower(String s) {
        //双指针
        int i = 1, j = 0;
        int ans = 1;
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        //i指针遍历字符串
        while (i < n) {
            while (i < n && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            ans = Math.max(ans, i - j);
            j=i;
            i++;
        }
        return ans;
    }
}
