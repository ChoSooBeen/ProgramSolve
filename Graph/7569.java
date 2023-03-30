import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());;
        int M = Integer.parseInt(st.nextToken()); //가로 - 열
        int N = Integer.parseInt(st.nextToken()); //세로 - 행
        int H = Integer.parseInt(st.nextToken()); //상자의 개수


        int[][][] locker = new int[H][N][M]; //보관함
        Queue<int[]> queue = new LinkedList<>();
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j = 0; j < M; j++){
                    locker[h][i][j] = Integer.parseInt(st.nextToken());
                    //익은 토마토가 있으면 큐에 위치 삽입
                    if(locker[h][i][j] == 1) {
                        queue.offer(new int[] {h, i, j});
                    }
                }
            }
        }


        /**
         * X,Y를 이용하여 상하좌우 위치 표현
         * X[0], Y[0], Z[0] = 왼쪽
         * X[1], Y[1], Z[1] = 오른쪽
         * X[2], Y[2], Z[2] = 아래쪽
         * X[3], Y[3], Z[3] = 위쪽
         * X[4], Y[4], Z[4] = 앞쪽
         * X[5], Y[5], Z[5] = 뒤쪽
         */
        int[] X = {-1, 1, 0, 0, 0, 0};
        int[] Y = {0, 0, -1, 1, 0, 0};
        int[] Z = {0, 0, 0, 0, 1, -1};

        /**
         * BFS
         * 현재 1인 부분의 상하좌우 모두 탐색할 수 있도록 한다.
         */
        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int t = 0; t < 6; t++) {
                int z = poll[0] + Z[t];
                int x = poll[1] + X[t];
                int y = poll[2] + Y[t];
                if (z < 0 || z >= H || x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }
                //안 익은 토마토가 있으면
                if (locker[z][x][y] == 0) {
                    //주위에 있던 익은 토마토 날짜에 1을 더해 저장
                    locker[z][x][y] = locker[poll[0]][poll[1]][poll[2]] + 1;
                    queue.offer(new int[]{z, x, y});
                }
            }
        }
        int day = 0;
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(locker[h][i][j] == 0) {
                        day = -1;
                        break;
                    }
                    if(locker[h][i][j] > day){
                        day = locker[h][i][j];
                    }
                }
                if(day == -1)
                    break;
            }
            if(day == -1)
                break;
        }

        //기본 1부터 시작하므로 1을 빼준다.
        if(day == 1)
            day = 0;
        else if(day != -1)
            day -= 1;
        System.out.println(day);
    }
}
