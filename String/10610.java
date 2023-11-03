import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("");
        int length = input.length;
        Arrays.sort(input); //오름차순 정렬(0~9까지 존재하므로 문자열로 정렬해도 int 형과 같음)

        int total = 0; //각 자릿수의 합
        StringBuilder sb = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            total += Integer.parseInt(input[i]);
            sb.append(input[i]);
        }

        //30의 배수가 되기 위한 조건
        //1. 1의 자리에는 무조건 0이 있어야 한다.
        //2. 각 자릿수의 합이 3의 배수이어야 한다.
        if(input[0].compareTo("0") != 0 || total % 3 != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}
