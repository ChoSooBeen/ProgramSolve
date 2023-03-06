import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci {
    static Integer[][] dp = new Integer[41][2];

    //https://st-lab.tistory.com/124 참고
    //동적 프로그래밍 활용
    static Integer[] fib(int n){
        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fib(n-1)[0] + fib(n-2)[0];
            dp[n][1] = fib(n-1)[1] + fib(n-2)[1];
        }
        return dp[n];
    }
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 0; i < testcase;i++){
            int input = Integer.parseInt(bf.readLine());
            Integer[] result =  fib(input);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }
}
