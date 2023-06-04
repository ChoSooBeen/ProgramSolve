import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/117 참고
public class BOJ15652 {
    static int arr[]; //수열을 저장할 배열
    static int N; //1 ~ N 숫자
    static int M; //수열의 길이
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1, 0);
    }
    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        else {
            for (int i = start; i <= N; i++) {
                arr[depth] = i;
                dfs(i, depth+1);
            }
        }
    }
}
