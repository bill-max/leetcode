public class reverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (' ' == ch) {
                continue;
            }
            int k=i;
            while (k < s.length() && ' ' != s.charAt(k)) {
                k++;
            }
            sb.insert(0, s.substring(i, k));
            sb.insert(0, ' ');

            i = k;
        }
        return sb.substring(1);
    }
}
