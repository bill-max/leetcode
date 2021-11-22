public class Day47_DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                    return false;
                }
            }
        } else {
            if (word.charAt(1) >='A' && word.charAt(1) <= 'Z') {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                        return false;
                    }
                }
            } else if (word.charAt(1) >= 'a' && word.charAt(1) <= 'z') {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
