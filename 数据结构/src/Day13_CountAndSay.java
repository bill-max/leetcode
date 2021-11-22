public class Day13_CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
//        StringBuilder sb = new StringBuilder();
        String s = "";
        for (int i = 1; i <= n; i++) {
            s = count_T(s, i);
        }
        return s;
    }

    //    public static StringBuilder count(StringBuilder sb, int n) {
//        int count = 1;
//        //对于第一项
//        if (n == 1) {
//            sb.append("1");
//            return sb;
//        }
//        //第二项
//        if (n == 2) {
//            sb.replace(0, sb.length(), "11");
//            return sb;
//        }
//        StringBuilder sb2 = new StringBuilder();
//        for (int i=1;i < sb.length();i++) {
//            if (sb.charAt(i - 1) == sb.charAt(i)) {
//                count++;
//                continue;
//            }
//            sb2.append(count).append(sb.charAt(i - 1));
//            count=1;
//        }
//        sb2.append(count).append(sb.charAt(sb.length() - 1));
//        return sb2;
//    }
    public static String count_T(String s, int n) {
        int count = 1;
        //对于第一项
        if (n == 1) {
            return "1";
        }
        //第二项
        if (n == 2) {
            return "11";
        }
        String s1 = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                continue;
            }
            s1 += Integer.toString(count)+ s.charAt(i - 1);
            count = 1;
        }
        s1 += Integer.toString(count) + s.charAt(s.length() - 1);
        return s1;
    }

}
