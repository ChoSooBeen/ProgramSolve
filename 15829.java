import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = "abcdefghijklmnopqrstuvwxyz"; //a~z까지 고유 번호 부여
        int num = Integer.parseInt(bf.readLine());
        String input = bf.readLine();

        BigInteger sum = new BigInteger("0"); //큰수를 다루기 위해 BigInteger 사용
        BigInteger r = new BigInteger("31");
        BigInteger M = new BigInteger("1234567891");
        for (int i = 0; i < num; i++) {
            String n = Integer.toString(s.indexOf(input.charAt(i))+1); //리스트는 0부터 시작! 고유 번호는 1부터 시작!
            BigInteger tmp = new BigInteger(n);
            tmp = tmp.multiply(r.pow(i));
            sum = sum.add(tmp);
        }
        System.out.println(sum.mod(M));
    }
}

//https://github.com/ChoSooBeen/ReviewNote/tree/main
