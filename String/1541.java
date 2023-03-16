import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 식의 최솟값을 구하기 위해서는 빼기를 가장 마지막에 해야한다.
         * - 를 구분자로 split한다.
         */
        String[] minus = bf.readLine().split("-");

        int result = 0;
        if(minus.length == 1){ //빼기가 없을 경우
            String[] plus = minus[0].split("\\+");
            for(int i = 0; i < plus.length; i++)
                result += Integer.parseInt(plus[i]);
        }
        else { //빼기가 존재할 경우
            for(int i = 0; i < minus.length; i++) {
                /**
                 * split은 정규식을 사용하여 문자열을 분리한다.
                 * 이때 . + 와 같은 기호는 정규식에서 특별한 의미를 지닌다.
                 * 그래서 이를 분리하기 위해서는 구분자 앞에 "\\"를 붙여준다.
                 */
                String[] plus = minus[i].split("\\+");
                int sum = 0;
                for(int j = 0; j < plus.length; j++)
                    sum += Integer.parseInt(plus[j]);
                /**
                 * i=0인 경우는 빼주는게 아니라 더해줘야한다.
                 * 즉, 제일 첫번째 값은  -가 붙은 상황이 아니다.
                 */
                if(i == 0)
                    result += sum;
                else
                    result -= sum;
            }
        }
        System.out.println(result);
    }
}
