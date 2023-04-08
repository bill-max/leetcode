import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class prevPermOpt1_1053 {
    static class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int n = arr.length;
            if (n <= 2) return arr;

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int j = n - 1;
                    while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                        j--;
                    }
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }

            }
            return arr;
        }

    }

}
