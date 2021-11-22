import java.util.ArrayList;
import java.util.List;

public class Generate {
    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(1);
        res.add(level);
        if (numRows == 1) {
            return res;
        }
        for (int i = 1; i < numRows; i++) {
            level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < res.get(i - 1).size() ; j++) {
                int num = res.get(i - 1).get(j) + res.get(i - 1).get(j - 1);
                level.add(num);
            }
            level.add(1);
            res.add(level);
        }
        return res;
    }
}
