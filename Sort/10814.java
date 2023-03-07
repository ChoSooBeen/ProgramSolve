import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[][] age = new int[N][2];
        String[] name = new String[N];
        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split(" ");
            age[i][0] = Integer.parseInt(s[0]);
            age[i][1] = i;
            name[i] = s[1];
        }

        Arrays.sort(age, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.printf("%d %s\n", age[i][0], name[age[i][1]]);
        }

        bf.close();
    }
}

//https://github.com/ChoSooBeen/ReviewNote/blob/main/10814.md
