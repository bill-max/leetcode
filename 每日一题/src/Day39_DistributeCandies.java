import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day39_DistributeCandies {
    public int distributeCandies(int[] candyType) {
        //结果集合
        Set<Integer> res = new HashSet<>();

        int n = candyType.length;
        int k = 0;
        for (int candy : candyType) {
            if (!res.contains(candy)) {
                res.add(candy);
                k++;
            }
            if (k == n / 2) {
                break;
            }
        }
        return k;
    }
}
