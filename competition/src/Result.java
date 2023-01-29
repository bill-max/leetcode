import java.util.Scanner;

public class Result {
    public static void inputIntInLine() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] numstr = str.split(" ");
        int[] nums = new int[numstr.length];
        for (int i = 0; i < numstr.length; i++) {
            nums[i] = Integer.parseInt(numstr[i]);
        }
        for (int n : nums) {
            System.out.println(n);
        }
        System.out.println("end of input int in a line");
    }

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            System.out.println(str);
        }
    }
}
