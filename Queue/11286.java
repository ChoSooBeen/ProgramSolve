import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine()); //연산의 개수

        //절댓값 힙
        //https://comain.tistory.com/m/292 참고
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            /**
             * 절댓값 순으로 정렬
             * 절댓값이 같은 경우에는 음수를 앞에 정렬
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2))
                    return Math.abs(o1) - Math.abs(o2);
                else if(Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                else
                    return -1;
            }
        });
        
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
