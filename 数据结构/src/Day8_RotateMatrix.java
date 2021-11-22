public class Day8_RotateMatrix {
    public static void main(String[] args) {
//        int[][] num = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] num = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(num);
        for (int[] a:
             num) {
            for (int n:
                 a) {
                System.out.print(" "+n+" ");
            }
            System.out.println("\n");
        }
    }
    public static void rotate(int[][] matrix) {
        //转置
        int temp=0;
        int n= matrix.length;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //交换列
        for (int i=0;i<n;i++){
            for (int j=0;j<n/2;j++){
                temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
}
