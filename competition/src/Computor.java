import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Computor {
    static Map<Operator, IComputer> computers;

    static {
        computers = new HashMap<Operator, IComputer>() {{
            put(Operator.ADD, new IComputer() {
                @Override
                public BigDecimal compute(BigDecimal a, BigDecimal b) {
                    return a.add(b);
                }

            });
            put(Operator.SUB, ((num1, num2) -> num1.subtract(num2)));
            put(Operator.MULTI, ((num1, num2) -> num1.multiply(num2)));
            put(Operator.DIVIDE, ((num1, num2) -> num1.divide(num2)));
        }};
    }

    public static void main(String[] args) {
        //测试验证 1+2
        BigDecimal result = compute(Operator.ADD, BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        //输出结果3
        System.out.println(result);
    }

    public static BigDecimal compute(Operator operator, BigDecimal num1, BigDecimal num2) {
        BigDecimal result = computers.get(operator).compute(num1, num2);
        return result;
    }


    enum Operator {
        ADD, SUB, MULTI, DIVIDE;
    }

    interface IComputer {
        public BigDecimal compute(BigDecimal a, BigDecimal b);
    }
}