public class Day20_ArrangeCoins {
    public int arrangeCoins(int n) {
        long res=0;
        int i =1;
        while (res < n) {
            res+=i;
            i++;
        }
        if (res==n){
            return i-1;
        }else {
            return i-2;
        }
    }
}
