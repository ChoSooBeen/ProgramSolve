import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //사람의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] time = new int[N];

        for(int i = 0; i < N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int[] result = new int[N+1];
        result[0] = time[0];
        int sum = result[0];
        for(int i = 1; i < N; i++){
            result[i] = result[i-1] + time[i];
            sum += result[i];
        }
        System.out.println(sum);
    }
}
