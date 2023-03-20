import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //BOJ 유저의 수
        int M = Integer.parseInt(st.nextToken()); //친구 관계 수

        int[][] friend = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                /**
                 * 플로이드-워셜 알고리즘(Floyd-Warshall Algorithm)을 이용하기 위해
                 * 행렬을 자체 간선을 제외하고 큰 수로 초기화 한다.
                 * Integer.MAX_VALUE 로 초기화할 경우 틀리게 나오는데
                 * 예상으로는 오버플로우가 발생하여 후에 결과가 잘못 나오는것 같다.
                 */
                if(i != j)
                    friend[i][j] = 987654321;
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friend[x][y] = 1;
            friend[y][x] = 1;
        }

        /**
         * 플로이드-워셜 알고리즘(Floyd-Warshall Algorithm)
         * https://sskl660.tistory.com/61 참고
         */
        for(int k = 1; k <= N; k++) {
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    friend[a][b] = Math.min(friend[a][b], friend[a][k]+friend[k][b]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum += friend[i][j];
            }
            if(sum < min) {
                minIndex = i;
                min = sum;
            }
        }
        System.out.println(minIndex);
    }
}
