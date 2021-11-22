public class Day12_StrStr {
    public static void main(String[] args) {
        String haystack = "iiiiipi";
        String needle ="ip" ;
        System.out.println(strStr(haystack,needle));
    }

    /*public static int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length()>haystack.length()){
            return -1;
        }
        //fi->haystack
        int fi=0;
        //sc->needle
        int sc=0;
        for (int i=0; i <haystack.length() ; i++) {
            fi=i;
            //如果当前字符串剩余长度小于needle长度，直接返回
            if (haystack.length()-i<needle.length()){
                return -1;
            }
            //如果第一个字符一致，启动查找循环
            if (haystack.charAt(i)==needle.charAt(0)){
                while(sc<needle.length()){
                    if (haystack.charAt(fi) == needle.charAt(sc)) {
                        fi++;
                        sc++;
                    }else {
                        sc=0;
                        break;
                    }
                }
                if (sc==needle.length()){
                    return i;
                }
            }
        }
            return -1;
    }*/
    public static int strStr(String haystack, String needle) {
    //使用KMP算法
        //needle为空,返回0
        if (needle.isEmpty()){
            return 0;
        }
return -1;
    }
}
