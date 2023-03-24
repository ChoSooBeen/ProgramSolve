import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        /**
         * I + OI * N
         * 즉, OI가 N번 반복되고 맨 앞에 I가 있으면 주어진 문자열에 Pn이 존재한다.
         * 
         * N = Pn의 O의 개수 = OI가 반복될 횟수
         * M = 입력받을 문자열 s의 길이
         */
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        String s = bf.readLine();

        int count = 0; //OI의 반복횟수를 저장하는 변수
        int result = 0; // Pn이 포함된 개수를 저장하는 변수

        for(int i = 1; i < M-1;){
            if(s.charAt(i) == 'O' && s.charAt(i+1) == 'I'){
                count++;
                if(count == N){ //OI가 N만큼 반복이 되었다면
                    if(s.charAt(i-count*2+1) == 'I'){ //Pn이 포함되는 조건이 충족되었다면
                        result++;
                    }
                    /**
                     * count--를 하는 이유는 OI의 반복 횟수가 N이 되었으므로
                     * 현재 확인한 문자열의 맨 앞의 OI는 이제 생각하지 않는다는 의미
                     * 
                     * 즉, 뒤에 또 다른 OI가 나올 수 있고
                     * 한번에 두개씩 확인하므로 i + 2 증가
                     */
                    count--;
                }
                i += 2;
            }
            //앞의 문자열은 조건확인이 끝나고 새로 시작
            else {
                count = 0;
                i++;
            }
        }
        System.out.println(result);
    }
}
