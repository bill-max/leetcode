import java.util.HashSet;
import java.util.LinkedList;

public class FindLexSmallestString_1625 {
    static class Solution {
        /**
         * 我们定义队列 q，初始时将字符串 s 入队，定义一个哈希表 ，用于记录字符串是否已经出现过，另外定义一个字符串 ，用于记录答案。
         *
         * 然后，我们不断从队列中取出字符串，将其与答案 进行比较，如果当前字符串字典序更小，则更新答案。然后我们对该字符串进行累加和轮转操作，得到新的字符串，
         * 如果新的字符串没有出现过，则将其入队，并更新。一直重复上述操作，直到队列为空。
         */
        public String findLexSmallestString(String s, int a, int b) {
            int n = s.length();
            HashSet<String> set = new HashSet<>();
            String res = s;

            LinkedList<String> q = new LinkedList<>();
            q.add(s);
            set.add(s);
            while(!q.isEmpty()){
                String cur = q.poll();

                if(cur.compareTo(res) < 0){
                    res = cur;
                }

                String add = add(cur, a);
                String offset = cur.substring(n - b) + cur.substring(0, n - b);

                if(set.add(add)){
                    q.add(add);
                }
                if(set.add(offset)){
                    q.add(offset);
                }
            }

            return res;
        }

        public String add(String s, int a){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(i % 2 != 0){
                    sb.append(((c - '0') + a) % 10);
                }else{
                    sb.append(c);
                }
            }

            return sb.toString();
        }

    }
}
