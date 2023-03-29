import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //정점의 수
        int[][] graph = new int[N+1][N+1]; //접점을 인접 행렬로 저장

        for(int i = 1; i <= N; i++){
            String[] s = bf.readLine().split(" ");
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        //플로이드-워셜 알고리즘(Floyd-Warshall Algorithm)
        for(int k = 1; k <= N; k++) {
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(graph[a][k] == 1 && graph[k][b] == 1){
                        graph[a][b] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sb.append(graph[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
