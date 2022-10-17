import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int up = Integer.parseInt(st.nextToken()); //올라가는 길이
        int down = Integer.parseInt(st.nextToken()); //미끄러지는 길이
        int finish = Integer.parseInt(st.nextToken()); //정상

        int days = (finish - down) / (up - down); //정상에서 미끄러진 길이 뺀 값을 하루에 올라가는 높이로 나눈다.
        //위의 나눗셈에서 나머지 값이 발생하지 않을 경우 다 올라간 것이다.
        if((finish - down) % (up - down) != 0) //나머지가 있을 경우
            days++; //하루 더 올라가야 완주한다.

        bf.close();
        System.out.println(days);
    }
}

//https://github.com/ChoSooBeen/ReviewNote/blob/main/2869.md
