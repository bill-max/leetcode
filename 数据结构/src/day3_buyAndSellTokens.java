import java.util.ArrayList;

public class day3_buyAndSellTokens {
    public static void main(String[] args) {

        int[] prices={7,1,5,3,6,4};
        int result=maxProfit(prices);
        System.out.println("\n"+result);
    }
        public static int maxProfit(int[] prices) {
            //计算两两之间的差值
/*            int[] nums = new int[prices.length-1];
            int j=0;
            int result=0;
            for (int i=0;i<prices.length-1;j++){
                nums[j]=-(prices[i]-prices[++i]);
                if(nums[j]>0){
                    result+=nums[j];
                }
            }
            //此时nums储存的值为二者差
            for (int a:
                 nums) {
                System.out.print(","+a);
            }*/
            int result=0;
            for (int i=1;i<prices.length;i++) {
                int temp=0;
                temp = prices[i] - prices[i-1];
                if (temp>0){
                    result+=temp;
                }
                prices[i-1]=temp;
            }
            return  result;
        }
}


