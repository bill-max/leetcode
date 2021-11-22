public class Day9_ReverseString {
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        reverseString(s);
        for (char a:
             s) {
            System.out.print(" "+a+" ");
        }
    }
    public static void reverseString(char[] s) {
        char temp;
        int i=0;
        int j=s.length-1;
        while(i<j){
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
