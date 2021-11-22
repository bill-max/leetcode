import java.util.HashSet;
import java.util.Set;
//基本思想：统计每个数字出现的次数，只要和二的幂的各字符出现的次数一致，必然能够通过重新组合得到二的幂
public class Day35_ReorderedPowerOf2 {
    Set<String> powerOf2Digits = new HashSet<String>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {
            powerOf2Digits.add(countDigits(n));
        }
    }

    public String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }
}
