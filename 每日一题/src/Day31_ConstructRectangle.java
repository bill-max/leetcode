public class Day31_ConstructRectangle {
    public int[] constructRectangle(int area) {
        int m = (int) Math.sqrt(area);
        while (area % m != 0) {
            m--;
        }
        return new int[]{area / m, m};
    }
}
