//직각 삼각형 구하기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] s = bf.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if(a == 0 && b == 0 && c == 0)
                break;
            else {
                if(a > b && a > c) {
                    int tmp = a;
                    a = c;
                    c = tmp;
                }
                else if(b > a && b > c) {
                    int tmp = b;
                    b = c;
                    c = tmp;
                }
                if(a * a + b * b == c * c)
                    sb.append("right");
                else
                    sb.append("wrong");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
