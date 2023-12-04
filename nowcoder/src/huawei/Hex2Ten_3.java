package huawei;

import java.util.*;

public class Hex2Ten_3 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, 4}));
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> a = new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum>0) r--;
                else if(sum<0) l++;
                else {
                    a.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                }
            }
        }
        return new ArrayList<>(a);
    }
    public Solution(){

    }

}