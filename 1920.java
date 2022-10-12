import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] array_n = new int[N];

        StringTokenizer st_n = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < N; i++)
            array_n[i] = Integer.parseInt(st_n.nextToken());
        Arrays.sort(array_n);

        int M = Integer.parseInt(bf.readLine());
        StringTokenizer st_m = new StringTokenizer(bf.readLine(), " ");

        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st_m.nextToken());

            if(Arrays.binarySearch(array_n, key) >= 0) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }

        bf.close();
    }
}

//https://github.com/ChoSooBeen/ReviewNote/blob/main/1920.md
