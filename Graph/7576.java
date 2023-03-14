import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());;
        
        int M = Integer.parseInt(st.nextToken()); //가로 - 열
        int N = Integer.parseInt(st.nextToken()); //세로 - 행


        int[][] locker = new int[N][M]; //토마토 보관함
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++){
                locker[i][j] = Integer.parseInt(st.nextToken());
                //이미 익은 토마토가 있으면 큐에 위치 삽입
                if(locker[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        /**
         * X,Y를 이용하여 상하좌우 위치 표현
         * X[0], Y[0] = 왼쪽
         * X[1], Y[1] = 오른쪽
         * X[2], Y[2] = 아래쪽
         * X[3], Y[3] = 위쪽
         */
        int[] X = {-1, 1, 0, 0};
        int[] Y = {0, 0, -1, 1};

        /**
         * BFS
         * 현재 익은 토마토의 주위를 모두 탐색하면서 1일씩 증가한다.
         */
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int t = 0; t < 4; t++) { //상하좌우 확인하기
                int x = poll[0] + X[t];
                int y = poll[1] + Y[t];
                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }
                //현재 익은 토마토 주위에 안 익은 토마토가 있으면
                if (locker[x][y] == 0) {
                    //주위에 있던 익은 토마토 익은 날짜에 1을 더해 저장 -> 다음날 익으므로
                    locker[x][y] = locker[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        int day = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(locker[i][j] == 0) { //안 익은 토마토가 있으면 -1
                    day = -1;
                    break;
                }
                if(locker[i][j] > day){ //날짜의 최댓값을 구한다.
                    day = locker[i][j];
                }
            }
            if(day == -1)
                break;
        }
        
        //기본 익은 날짜가 1부터 시작하므로 1을 빼준다.
        if(day != -1)
            day -= 1;
        System.out.println(day);
    }
}
