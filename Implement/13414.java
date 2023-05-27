import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ13414 {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input[] = bf.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        String ready[] = new String[L];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < L; i++) {
            ready[i] = bf.readLine();
            if (map.containsKey(ready[i])) {
                map.put(ready[i], map.get(ready[i])+1);
            }
            else {
                map.put(ready[i], 1);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L; i++) {
            if (map.get(ready[i]) == 1) {
                sb.append(ready[i]+'\n');
                count++;
            }
            else {
                map.put(ready[i], map.get(ready[i])-1);
            }
            if (count == K) {
                break;
            }
        }
        System.out.println(sb);
    }
}
