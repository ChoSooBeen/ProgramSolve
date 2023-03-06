import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class max_heap {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //연산의 개수

        //우선순위 큐
        //최대힙 - 최소힙 구현시 사용했던 코드에 반대로 정렬 사용
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(bf.readLine());
            if(input == 0) {
                if(maxHeap.size() <= 0) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(maxHeap.poll()).append("\n");
                }
            }
            else {
                maxHeap.add(input);
            }
        }
        System.out.println(sb);
    }
}
