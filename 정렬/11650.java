import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] xy = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(xy, (o1, o2) -> { //lamda식으로 변경
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< N ; i++) {
            sb.append(xy[i][0] + " " + xy[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}

//https://github.com/ChoSooBeen/ReviewNote/blob/main/%EB%B0%B1%EC%A4%80/11650.md
