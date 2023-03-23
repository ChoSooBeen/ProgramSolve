import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
    public static int[][] complex; //맵
    public static boolean[][] visited; //방문여부 확인 배열
    public static int[] aparts; //아파트 단지에 있는 아파트 수 저장
    public static int aprtnum; //아파트 단지 번호

    static int BFS(int vx, int vy){
        Queue<int[]> queue = new LinkedList<>();

        //상하좌우를 확인하기 위한 배열
        int[] X = {-1, 1, 0, 0};
        int[] Y = {0, 0, -1, 1};

        queue.offer(new int[] {vx, vy});
        visited[vx][vy] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int t = 0; t < 4; t++) {
                int x = poll[0] + X[t];
                int y = poll[1] + Y[t];
                if (x >= 0 && x < complex.length && y >= 0 && y < complex.length) {
                    if (complex[x][y] == 1 && !visited[x][y]) {
                        complex[x][y] = aprtnum;
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //지도의 크기

        complex = new int[N][N];
        visited = new boolean[N][N];
        /** 지도의 크기에서 만들어질 수 있는 최대의 단지수
         *  N이 짝수일 경우 : N*N/2 + 1
         *  N이 홀수일 경우 : (N*N+1)/2 + 1
         *  둘 중 홀수일 경우의 식이 더 여유로우므로 선택
         */
        int size = ((N*N)+1)/2 + 1;
        aparts = new int[size];
        aprtnum = 0;
        for(int i = 0; i < N; i++) {
            String[] s = bf.readLine().split("");
            for(int j = 0; j < N; j++) {
                complex[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(complex[i][j] == 1 && !visited[i][j]){
                    aprtnum++;
                    aparts[aprtnum] = BFS(i, j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(aprtnum);
        for(int i = 0; i < aparts.length; i++){
            if(aparts[i] != 0)
                System.out.println(aparts[i]);
        }
    }
}
