import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    //최대공약수
    public static int gcd(int num1, int num2){
        int tmp = 0;
        while(num2 > 0){
            tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }

    //최소공배수
    public static int lcm(int num1, int num2){
        return num1 * num2 / gcd(num1, num2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i = 0; i < testcase; i++){
            st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int last = lcm(M, N); //가장 마지막 연도
            int n = 0;
            int result = -1;
            while(n * M < last){
                if((n * M + x - y) % N == 0) {
                    result = n * M + x;
                    break;
                }
                n++;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
