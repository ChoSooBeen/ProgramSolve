import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //계단 수
        int[] stair = new int[N+1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(bf.readLine());
        }

        int[] dp = new int[N+1]; //각 계단의 도달 최고 점수
        dp[1] = stair[1];
        if(N >= 2){ //N이 1일 경우 제외하기 위해 --> 예외처리를 해주지 않으면 인덱스 오류가 발생한다.
            dp[2] = stair[1]+stair[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-3]+stair[i-1], dp[i-2])+stair[i];
        }
        System.out.println(dp[N]);
    }
}
