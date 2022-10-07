public class CompareVersion_165 {
    //todo
    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] stringsVersion1 = version1.split("\\.");
            String[] stringsVersion2 = version2.split("\\.");
            int m = Math.min(stringsVersion1.length, stringsVersion2.length);
            for (int i = 0; i < m; i++) {
                int intV1 = Integer.parseInt(stringsVersion1[0]);
                int intV2 = Integer.parseInt(stringsVersion2[0]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
