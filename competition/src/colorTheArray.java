class colorTheArray {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] num = new int[n];
        int[] ans = new int[queries.length];
        int j = 0;
        ans[j++] = 0;
        num[queries[0][0]] = queries[0][1];

        for (int i = 1; i < queries.length; i++) {
            int idx = queries[i][0];
            int color = queries[i][1];
            int cnt = ans[j - 1];
            if (idx != n - 1) {
                if (num[idx] == num[idx + 1] && num[idx] != 0) {
                    cnt--;
                }
                if (color == num[idx + 1]) {
                    cnt++;
                }
            }
            if (idx != 0) {
                if (num[idx] == num[idx - 1] && num[idx] != 0) {
                    cnt--;
                }
                if (color == num[idx - 1]) {
                    cnt++;
                }
            }
            ans[j++] = cnt;
            num[idx] = color;
        }
        return ans;
    }
}
