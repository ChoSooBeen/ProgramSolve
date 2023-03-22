import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    public static int[][] maze;

    /**
     * 미로를 탈출할 수 있는 최단거리 구하는 함수
     * @param N 도착 지점 X좌표
     * @param M 도착 지점 Y좌표
     * @param vX 시작 지점 X좌표
     * @param vY 시작 지점 Y좌표
     */
    static void BFS(int N, int M, int vX, int vY){
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[N+1][M+1]; // 방문 여부를 검사할 배열

        //상하좌우를 확인하기 위한 배열
        int[] X = {-1, 1, 0, 0};
        int[] Y = {0, 0, -1, 1};

        queue.offer(new int[] {vX, vY});
        visited[vX][vY] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int t = 0; t < 4; t++) {
                int x = poll[0] + X[t];
                int y = poll[1] + Y[t];
                if (x <= 0 || x > N || y <= 0 || y > M) {
                    continue;
                }
                //갈 수 있는 길이 있으면
                if (maze[x][y] == 1) {
                    /**
                     * 시작 위치와 끝 위치에 간 횟수도 포함해야하기 때문에
                     * 시작 1을 시작으로 갈때마다 전에 구한 값에 1을 더해서 저장해준다.
                     */
                    maze[x][y] = maze[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        System.out.println(maze[N][M]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //1번 부터 N번 까지 / 1번 부터 M번 까지
        maze = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            String[] s = bf.readLine().split("");
            for(int j = 1; j <= M; j++){
                // s에 인덱스를 접근할 때 0부터 M-1까지만 가능하므로 주의!!
                maze[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        BFS(N, M, 1, 1);
    }
}
