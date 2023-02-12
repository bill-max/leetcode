import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath_1138 {
    static class Solution {
        public String alphabetBoardPath(String target) {
            Map<Character, int[]> board = new HashMap<>() {{
                put('z', new int[]{5, 0});
            }};
            for (int i = 0, count = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board.put((char) ('a' + count++), new int[]{i, j});
                }
            }

            StringBuilder sb = new StringBuilder();
            char[] chars = target.toCharArray();
            sb.append("D".repeat(Math.max(0, board.get(chars[0])[0]))).append("R".repeat(Math.max(0, board.get(chars[0])[1]))).append("!");
            for (int i = 1; i < chars.length; i++) {
                int y = board.get(chars[i])[0] - board.get(chars[i - 1])[0];
                int x = board.get(chars[i])[1] - board.get(chars[i - 1])[1];
                if (y < 0)
                    sb.append("U".repeat(-y));
                if (x < 0)
                    sb.append("L".repeat(-x));
                if (x >= 0)
                    sb.append("R".repeat(x));
                if (y >= 0)
                    sb.append("D".repeat(y));
                sb.append("!");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().alphabetBoardPath("code"));
    }
}
