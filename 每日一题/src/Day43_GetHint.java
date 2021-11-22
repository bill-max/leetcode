import java.util.*;

public class Day43_GetHint {
    public String getHint(String secret, String guess) {
        int bull=0;
        int cow=0;
        StringBuilder sb=new StringBuilder();
        Map<Character, Integer> sec = new HashMap<>();
        List<Character> gue = new ArrayList<>();
        //优先公牛
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                sec.put(secret.charAt(i), sec.getOrDefault(secret.charAt(i), 0) + 1);
                gue.add(guess.charAt(i));
            }
        }

        //cow
        for (char ch : gue) {
            if (sec.containsKey(ch) && sec.get(ch) != 0) {
                cow++;
                sec.put(ch,sec.get(ch)-1);
            }
        }
        sb.append(bull).append('A').append(cow).append('B');
        return sb.toString();
    }
}
