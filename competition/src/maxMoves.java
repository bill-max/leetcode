public class maxMoves {
    class Solution {
        int[][] pos = {{1, -1}, {1, 0}, {1, 1}};
        int ans = Integer.MIN_VALUE;

        public int maxMoves(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                dfs(grid, 0, i, 0);
            }
            return ans;
        }

        private void dfs(int[][] grid, int x, int y, int cnt) {
            if (ans == grid[0].length - 1) return;
            ans = Math.max(ans, cnt);
            for (int[] po : pos) {
                int x1 = x + po[0];
                int y1 = y + po[1];
                if (y1 >= 0 && y1 < grid.length && x1 < grid[0].length && grid[y][x] < grid[y1][x1]) {
                    dfs(grid, x1, y1, cnt + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new maxMoves().new Solution();
        System.out.println(solution.maxMoves(
                new int[][]{
                        {1000000, 92910, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068},
                        {1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118}
                }));
    }
}
