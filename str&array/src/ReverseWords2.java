

import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class ReverseWords2 {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (i < s.length()) {
            while (i<s.length()&&chars[i] != ' ') {
                i++;
            }
            int start = j;
            int end = i - 1;
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            i++;
            j = i;
        }
        StringBuilder sb=new StringBuilder();
        for (char a : chars) {
            sb.append(a);
        }
        return sb.toString();
    }
}
