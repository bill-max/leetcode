public class Day17_Solution {
    public int Solution(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=' '){
                count++;
            }
            while (i<s.length()&&s.charAt(i)!=' '){
                i++;
            }
        }
        return count;
    }
}
