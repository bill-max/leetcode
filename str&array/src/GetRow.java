import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> level = new ArrayList<>();
        level.add(1);
        if (rowIndex == 0) {
            return level;
        }
        for (int i = 1; i <= rowIndex; i++) {
            //temp为暂存量
            int temp = level.get(0);
            for (int j = 1; j < level.size() ; j++) {
                //当前值加上上一个值temp
                int sum = level.get(j) + temp;
                //上一个值更新，留给下一个数据使用
                temp = level.get(j);
                //更新当前数据
                level.set(j,sum);
            }
            //添加末尾元素
            level.add(1);
        }
        return level;
    }
}
