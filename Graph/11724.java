import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점의 수
        int M = Integer.parseInt(st.nextToken()); //간선의 수

        int[][] graph = new int[N+1][N+1]; //접점을 인접 행렬로 저장
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //무방향 그래프라 생각하고 저장
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        boolean visited[] = new boolean[N + 1]; // 방문 여부를 검사할 배열
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(visited[i] == false) {
                //DFS
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(i);
                visited[i] = true;
                boolean flag = false; //더 탐색할 정정이 없으면 false
                while(!stack.isEmpty()) {
                    int w = stack.peek();
                    flag = false;

                    for (int k = 1; k <= N; k++) {
                        if (graph[w][k] == 1 && !visited[k]) {
                            stack.push(k);
                            visited[k] = true;
                            flag = true;
                            break;
                        }
                    }
                    //현재 노드에서 더이상 탐색할 노드가 없다면
                    if (!flag) {
                        stack.pop();
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
