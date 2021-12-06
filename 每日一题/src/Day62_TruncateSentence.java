public class Day62_TruncateSentence {
    public String truncateSentence(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return "";
        }
        int i = 0;
        StringBuilder sb=new StringBuilder();
        while (k > 0) {
            while (i<s.length()&&s.charAt(i) != ' ') {
                i++;
            }
            k--;
            i++;
        }
        sb.append(s,0, i-1);
        return sb.toString();
    }
}
