import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ5430 {
    public static StringBuilder sb = new StringBuilder();

    /**
     * 새로운 언어 AC 명령어 실행하는 함수
     * @param deque 입력받은 배열
     * @param p 명령어 문자열
     */
    public static void cmd(Deque<String> deque, String p){
        //true 경우 앞에서부터, false 경우 뒤에서부터
        boolean flag = true;

        for(char c : p.toCharArray()){
            if(c == 'R') { //뒤집기 명령어 실행
                flag = !flag;
            }
            else { // 'D' 명령어 실행
                if(flag) {
                    if(deque.pollFirst() == null) {
                        sb.append("error").append("\n");
                        return;
                    }
                }
                else {
                    if(deque.pollLast() == null) {
                        sb.append("error").append("\n");
                        return;
                    }
                }
            }
        }
        /** 주의할점! 덱이 비어있는 상태에서 R명령어를 실행한 후 [] 출력할 수 있도록!!! 
         * 예시 입력
         * R
         * 0
         * []
         * 
         * 출력
         * []
         */
        printArray(deque, flag);
    }

    /**
     * 현재 배열 출력하는 함수
     * @param deque 배열
     * @param flag 현재 방향
     */
    public static void printArray(Deque<String> deque, boolean flag) {
        sb.append("[");
        if(deque.size() > 0) {
            if(flag){
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }

    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine()); //테스트케이스 수

        for(int i = 0; i < testcase; i++){
            String p = bf.readLine(); //수행할 함수
            int n = Integer.parseInt(bf.readLine()); //배열의 길이
            Deque<String> deque = new ArrayDeque<>();
            String tmp = bf.readLine();
            String[] s = tmp.substring(1, tmp.length()-1).split(",");

            for(int j = 0; j < n; j++){
                deque.add(s[j]);
            }
            cmd(deque, p);
        }
        System.out.println(sb);
    }
}
