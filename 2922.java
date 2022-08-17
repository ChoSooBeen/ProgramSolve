import java.util.Scanner;
public class math_2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int sum = 1;
        int count = 1;

        if(num == 1)
            System.out.println(1);
        else {
            while (true) {
                sum = sum + 6 * count;
                if (num <= sum) {
                    System.out.println(count + 1);
                    break;
                }
                count++;
            }
        }
    }
}

//https://github.com/ChoSooBeen/ReviewNote/blob/main/2922.md
