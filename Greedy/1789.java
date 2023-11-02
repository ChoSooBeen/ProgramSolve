import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(bf.readLine());
        int result = 1;
        BigInteger current = new BigInteger("1");
        BigInteger remain = N.subtract(current);
        BigInteger one = current;
        while (current.compareTo(remain) == -1) {
            result++;
            current = current.add(one);
            remain = remain.subtract(current);
        }
        System.out.println(result);
        
//        Long type 사용
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        long N = Long.parseLong(bf.readLine());
//        int result = 1;
//        long current = 1;
//        long remain = N - 1;
//        while (current < remain) {
//            result++;
//            current++;
//            remain -= current;
//        }
//        System.out.println(result);
    }
}
