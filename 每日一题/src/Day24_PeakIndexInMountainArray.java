public class Day24_PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int temp=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
            }else {
                return i-1;
            }
        }
        return 0;
    }
}
