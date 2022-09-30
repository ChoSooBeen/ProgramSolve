import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine());
        int[] answer = new int[testcase];

        for(int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int H = Integer.parseInt(st.nextToken()); // 높이 = 층
            int W = Integer.parseInt(st.nextToken()); // 넓이 = 호
            int N = Integer.parseInt(st.nextToken()); // 도착한 순서

            int h = N % H;
            int w = N / H + 1;
            if(h == 0) {
                h = H;
                w -= 1;
            }

            answer[i] = h * 100 + w;
        }
        for(int i = 0; i < testcase; i++) {
            System.out.println(answer[i]);
        }
        bf.close();
    }
}
