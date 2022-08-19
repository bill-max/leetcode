public class BusyStudent_1450 {
    static class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int ans=0;
            for (int i = 0; i < endTime.length; ++i) {
                if (endTime[i] >= queryTime && startTime[i] <= queryTime) {
                    ans++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
