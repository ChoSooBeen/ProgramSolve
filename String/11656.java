import java.io.*;
import java.util.Arrays;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int length = input.length();

        String[] suffix = new String[length];
        for(int i = 0; i < length; i++) {
            suffix[i] = input.substring(i);
        }
        Arrays.sort(suffix);
        for(int i = 0; i < length; i++) {
            bw.write(suffix[i] + '\n');
        }
        bw.flush();
        bw.close(); //스트림 닫기!
    }
}
