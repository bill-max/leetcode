public class doesValidArrayExist {
    class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int n = derived.length;
            int[] origin = new int[n];
            for (int i = 0; i < n-1; i++) {
                origin[i + 1] = derived[i] ^ origin[i];
            }
            if ((origin[n-1]^derived[n-1])==origin[0]) return true;
            origin[0] = 1;
            for (int i = 0; i < n-1; i++) {
                origin[i + 1] = derived[i] ^ origin[i];
            }
            return (origin[n - 1] ^ derived[n - 1]) == origin[0];
        }
    }
}
