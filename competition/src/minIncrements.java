
class minIncrements {
    public int minIncrements(int n, int[] cost) {
        int cnt = 0;
        int j = n - n / 2;
        for (int i = n / 2; i > 0; i /= 2, j /= 2) {
            int max = Integer.MIN_VALUE;
            for (int k = 0; k < j; k++) {
                max = Math.max(max, cost[i + k]);
            }
            for (int k = 0; k < j; k++) {
                cnt += max - cost[i + k];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        minIncrements ins = new minIncrements();
        System.out.println(ins.minIncrements(15, new int[]{764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761}));
    }
}

