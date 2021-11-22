public class Day45_FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int a = timeSeries[i] - timeSeries[i - 1];
            count += a > duration - 1 ? duration : a;
        }
        return count + duration;
    }
}
