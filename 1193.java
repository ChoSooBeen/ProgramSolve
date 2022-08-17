import java.util.Scanner;
public class math_1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt(); //입력받은 숫자

        int parent = 1; //분모
        int child = 1; //분자
        int flag = 1; //현재 분모(0)가 바뀌었는지, 분자(1)가 바뀌었는지 나타낸다.

        if (num != 1){
            for(int i = 0; i < num-1; i++) {
                if(flag != 0 && child == 1) {
                    parent += 1;
                    flag = 0;
                }
                else if(flag != 1 && parent == 1) {
                    child += 1;
                    flag = 1;
                }
                else if(flag == 0) {
                    child += 1;
                    parent -= 1;
                }
                else if(flag == 1){
                    parent += 1;
                    child -= 1;
                }
            }
        }
        System.out.println(String.format("%d/%d", child, parent));
    }
}
