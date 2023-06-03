import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {
    static void BFS(int[] graph, int N, int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[N+1]; // 방문 여부를 검사할 배열
        int count[] = new int[N+1];

        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(poll == 100) {
                System.out.println(count[N]);
                return;
            }
            for(int i = 1; i <= 6; i++) {
                int n = poll + i;
                if(n <= 100 && visited[n] == false) {
                    visited[n] = true;
                    if(graph[n] != 0) { //뱀 또는 사다리 위치일 경우
                        if(visited[graph[n]] == false) {
                            queue.offer((graph[n]));
                            visited[graph[n]] = true;
                            count[graph[n]] = count[poll] + 1;
                        }
                    }
                    else { //아무것도 없는 경우
                        queue.offer(n);
                        count[n] = count[poll] + 1;
                    }
                }
            }
        }
    }
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); //사다리의 수 -> 커진다.
        int M = Integer.parseInt(st.nextToken()); //뱀의 수 -> 작아진다.

        int ladder_and_snake[] = new int[101];
        for(int i = 0; i < N+M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt((st.nextToken()));
            int y = Integer.parseInt((st.nextToken()));
            ladder_and_snake[x] = y; //[x]의 위치에 있으면 y로 이동
        }
        BFS(ladder_and_snake, 100, 1);
    }
}
