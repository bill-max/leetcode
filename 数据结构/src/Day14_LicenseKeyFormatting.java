import java.util.Locale;

public class Day14_LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-",4));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb=new StringBuilder();
        //求第一个分组的个数
        int n=0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j)!='-'){
                sb.append(s.charAt(j));
                n++;
            }
        }
        if (sb.length() == 0) {
            return sb.toString();
        }
        n = n % k > 0 ? n % k : k;
        //在第一个分组后添加分割符
        sb.insert(n, '-');
        //在后面的分组后添加分割符
        while (n+1+k < sb.length()) {
            n=n+1+k;
            sb.insert(n, '-');
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.delete(sb.length()-1, sb.length());
        }
        return sb.toString().toUpperCase();
    }
}
