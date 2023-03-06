import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class min_heap {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //연산의 개수

        //우선순위 큐
        //최소힙이나 최대힙으로 사용할 수 있다.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(bf.readLine());
            if(input == 0) {
                if(minHeap.size() <= 0) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(minHeap.poll()).append("\n");
                }
            }
            else {
                minHeap.add(input);
            }
        }
        System.out.println(sb);
    }
}
