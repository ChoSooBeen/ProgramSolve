import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); //동생의 위치

        int count = 0; //수빈이가 동생을 찾는데 걸리는 최저의 시간

        //BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();

        /**
         * 방문 여부를 검사할 배열
         * 0 <= N, K <= 100000
         * 배열의 크기를 위의 범위 내로 만든다.
         */
        boolean visited[] = new boolean[100001];

        queue.offer(N);
        visited[N] = true;

        boolean flag = false; //반복문 종료를 위한 flag

        //수빈이와 동생이 같이 있지 않을 경우에만 실행
        while(N != K){
            count++;
            /**
             * while문이 실행될 때마다 수빈이가 동생을 찾는데 걸리는 시간 증가
             * size = 같은 시간에 탐색할 수 있는 경우의 수
             */
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int poll = queue.poll();
                if(poll-1 == K || poll+1 == K || poll*2 == K) {
                    flag = true;
                    break;
                }
                if(poll-1 >= 0 && !visited[poll-1]) {
                    visited[poll-1] = true;
                    queue.add(poll-1);
                }
                if(poll+1 <= 100000 && !visited[poll+1]) {
                    visited[poll+1] = true;
                    queue.add(poll+1);
                }
                if(poll*2 <= 100000 && !visited[poll*2]) {
                    visited[poll*2] = true;
                    queue.add(poll*2);
                }
            }
            if(flag)
                break;
        }
        System.out.println(count);
    }
}
