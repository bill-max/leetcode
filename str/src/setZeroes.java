import java.util.*;

public class setZeroes {
    public void setZeroes(int[][] matrix) {
        int nRow = matrix.length;
        int nColumn = matrix[0].length;
        Set<Integer> countRow=new HashSet<>();
        Set<Integer> countColumn = new HashSet<>();
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {
                if (matrix[i][j] == 0) {
                    if (!countRow.contains(i)){
                        countRow.add(i);
                    }
                    if (!countColumn.contains(j)) {
                        countColumn.add(j);
                    }
                }
            }
        }
        //删除元素
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {
                if (countRow.contains(i)||countColumn.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
