import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DualPriorityQueue {
    /**
     * map에 포함되어 있는 최솟값 또는 최댓값을 구하면서 제거하는 함수
     * @param queue minHeap or maxHeap 즉, 최솟값 또는 최댓값 제거를 위한 구분
     * @param map 큐에 들어있는 원소 확인
     * @return 최솟값 또는 최댓값 반환
     */
    public static int remove(PriorityQueue<Integer> queue, HashMap<Integer,Integer> map){
        int num;
        while(true){
            num = queue.poll();
            if(map.containsKey(num)){
                int count = map.get(num);
                if(count == 1)
                    map.remove(num);
                else
                    map.put(num, count-1);
                break;
            }
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine()); //테스트케이스
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(bf.readLine()); // 입력데이터 수
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //최소힙
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
            HashMap<Integer,Integer> map = new HashMap<>(); //큐에 있는 원소를 확인하기 위한 map
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(bf.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(op.equals("I")){ //삽입 연산
                    minHeap.add(num);
                    maxHeap.add(num);
                    //getOrDefault(key, defaultValue)
                    map.put(num, map.getOrDefault(num, 0)+1);
                }
                else if(op.equals("D")){ //삭제 연산
                    if(map.isEmpty()){ //큐가 비어있을 경우
                        continue;
                    } else if(num == -1) {  //최소값 삭제
                        remove(minHeap, map);
                    }
                    else { //최댓값 삭제
                        remove(maxHeap, map);
                    }
                }
            }
            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            }
            else {
                /**
                 * 최댓값을 구한 후 map이 비어있는 경우가 있을 수 있다.
                 * 즉, 원소가 1개여서 최댓값 = 최솟값일 경우를 위해
                 * min은 삼항연산자를 사용하여 구한다.
                 */
                int max = remove(maxHeap, map);
                int min = map.size() > 0 ? remove(minHeap, map) : max;
                sb.append(max).append(" ");
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }
}
