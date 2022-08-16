import java.util.Scanner;

public class math_1712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(); //고정비용
        int b = scanner.nextInt(); //가변비용
        int c = scanner.nextInt(); //책정 가격

        if(c <= b)
            System.out.println("-1");
        else
            System.out.println(a/(c-b)+1);
    }
}
