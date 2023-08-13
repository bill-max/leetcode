import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findPrimePairs {
    static class Solution {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        public List<List<Integer>> findPrimePairs(int n) {
            List<List<Integer>> result = new ArrayList<>();
            if (n < 3) return new ArrayList<>();
            for (int i = 2; i <= n / 2; i++) {
                boolean isP = true;
                for (int prime : primes) {
                    if (i > prime && i % prime == 0) {
                        isP = false;
                        break;
                    }
                }
                isP = isP && isPrimes(n - i) && isPrimes(i);
                if (isP) {
                    result.add(new ArrayList<>(List.of(i, n - i)));
                }
            }
            return result;
        }

        private boolean isPrimes(int n) {
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
