import java.io.*;

public class Main {
    public static String palindrome(String num) {
        int len = num.length();
        String front, back;
        if(len % 2 == 0) {
            front = num.substring(0, len/2);
            back = num.substring(len/2);
        }
        else {
            front = num.substring(0, len/2);
            back = num.substring(len/2 + 1);
        }
      
        //문자열 뒤집을 때 reverse() 함수 사용!
        StringBuffer sb = new StringBuffer(back);
        back = sb.reverse().toString();

        if(front.equals(back)){
            return "yes";
        }
        else {
            return "no";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String num = bf.readLine();
        while(!num.equals("0")) {
            System.out.println(palindrome(num));
            num = bf.readLine();
        }
    }
}
